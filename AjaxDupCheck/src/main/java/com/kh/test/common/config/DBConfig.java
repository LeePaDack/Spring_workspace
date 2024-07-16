package com.kh.test.common.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration // = 컴퓨터 설정 = 컴퓨터 구성
// 설정

@PropertySource("classpath:/config.properties") //******************** 추후 변경 요망 *****//
// @PropertySource : properties 파일의 내용을 이용하겠다는 어노테이션
// 다른 properties 파일도 추가하고 싶다면 어노테이션을 계속 추가해주면 됨
// @PropertySource("classpath:/config2.properties")
// @PropertySource("classpath:/config3.properties")

public class DBConfig {
	@Autowired
	private ApplicationContext applicationContext; // 폴더 흐름
	// import org.springframework.context.ApplicationContext; 해야함
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	// properties 파일의 내용을 이용해서 생성되는 bean 을 설정하는 어노테이션
	// prefix = 시작 위치를 지정해서 spring.datasource.hikari 로 시작하는 설정을 모두 적용
	// spring.datasource.hikari = Oracle DataBase 연결할 때 사용하는 툴
	// 빠르고 가벼워서 사용
	public HikariConfig hikariConfig() { // -> 주소 설정만
		return new HikariConfig();
	}
	
	@Bean // Spring Context 스프링 안에서 관리되고 있는 기능이다 라는 설정
	// -> 연결된 DB 를 Spring 에서 관리하겠다. 관리하는 용도로 등록한 것
	public DataSource dataSource(HikariConfig config) { 
		DataSource dataSource = new HikariDataSource(config);
		return dataSource;
	}
	
	///////////// MyBatis 설정 추가 /////////////
	// SQLSessionFactory : SQLSession 을 만드는 객체
	@Bean
	public SqlSessionFactory sessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		
		// 매퍼 파일이 모여있는 경로 설정
		sessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mappers/**.xml")); //******************** 추후 변경 요망 *****//
	
		// 별칭을 지정해야하는 DTO 가 모여있는 패키지 지정
		// -> 해당 패키지에 있는 모든 클래스가 클래스명으로 별칭이 지정됨
		// Aliase = 별칭 Aliases = 별칭들 package = 폴더 밑에 있는 파일 모두
		sessionFactoryBean.setTypeAliasesPackage("com.kh.dto"); //******************** 추후 변경 요망 *****//
		// 마이바티스 설정 파일 경로 지정
		sessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml")); //******************** 추후 변경 요망 *****//
		
		return sessionFactoryBean.getObject();
	}
	
	// 기본 SQL 실행 + Commit 처리 = 트랜잭션 처리 commit = 한글문서나 엑셀 최종 파일저장
	// SqlSessionTemplate = 기본 sql 실팽 + 프랜잭션 처리
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sessionFactory) {
		return new SqlSessionTemplate(sessionFactory);
	}
	
	// 전반적인 Commit 과 Rollback 과 같은 관리를 해주는 트랜잭션 매니저
	// DataSourceTransactionManager = 트랜잭션 매니저
	@Bean 
	public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
