/**
 * 순수 자바스크립트 형식 작성해줄 수 있고, jquery 형식도 넣을 수 있는 공간
 */
// <button onclick="버튼()">자바스크립트 연결 테스트</button> 를 클릭했을 때 나오는 기능
function 버튼() {
	alert("버튼이 클릭되었습니다.");
}

// <button id="버튼">자바스크립트 연결 테스트</button> 를 클릭했을 때 나오는 기능
document.querySelector("#btn").addEventListener("click",btn);


// // <button id="버튼">자바스크립트 연결 테스트</button> 를 제이커리 형식으로 변경
$("#btn").readt(function(){
	$("#btn").click(btn);
});
