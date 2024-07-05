<%@page import="project_shopifyJDBC_Dto.ShowAllQAListDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="project_shopifyJDBC_Dao.ShowAllQAListDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ShowAllQAListDao dao = new ShowAllQAListDao();
	ArrayList<ShowAllQAListDto> listQAListDto = dao.showAllList();
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Q&A메인페이지</title>
	<link rel="stylesheet" href="Project_QA_main_page.css">
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<script>
		$(function(){
			$("#div_상단바2-4").click(function(){
				alert("비밀글로 작성자만 볼 수 있습니다.");
			});
			$("#div_상단바3-4").click(function(){
				alert("비밀글로 작성자만 볼 수 있습니다.");
			});
			$("#div_상단바4-4").click(function(){
				alert("비밀글로 작성자만 볼 수 있습니다.");
			});
			$("#div_상단바5-4").click(function(){
				alert("비밀글로 작성자만 볼 수 있습니다.");
			});
			$("#div_상단바6-4").click(function(){
				$("#div_QA_main_open").css("display", "flex");
			});
			$("#div_back_QA_main_page").click(function(){
				$("#div_QA_main_open").css("display", "none");
			});
			$("#div_QA_down_button1").click(function(){
				$("#div_QA_write_page_open").css("display", "flex");
			});
			$("#div_QA_write_back_button_box").click(function(){
				$("#div_QA_write_page_open").css("display", "none");
			});
		});
	</script>
</head>
<body>
	<div id="div_header1">
		<div id="div_header_content1">
			Q&A 상품문의
		</div>
	</div>
	<div id="div_QA_all_page">
	<div id="div_QA_main_page">
	<div id="div_QA_inquiry_main_screen">
		<div id="div_content_box1">
			<div id="div_content_text1-1">Q&A 상품문의(2,769)</div>
			<form action="Project_QA_condition.html">
				<div id="div_QA_product_list_button">
					<input type="submit" id="QA_product_list_button" value="목록">
				</div>
			</form>
		</div>
		<div id="div_content_box2">
			<select id="div_전체상품문의_box">
				<option value="">전체 상품문의</option>
				<option value="사이즈">사이즈</option>
				<option value="배송">배송</option>
				<option value="재입고">재입고</option>
			</select>
			<button id="div_비밀글제외_box">
				<div id="div_비밀글설정_box">
					<img id="div_비밀글설정_img" src="img/QA_비밀글 설정_logo.png">
					비밀글 제외
				</div>
			</button>
		</div>
		<div id="div_content_box3">
			<div id="div_content_small_box1" class="border">
				<span id="div_상단바1">번호</span>
				<span id="div_상단바2">답변여부</span>
				<span id="div_상단바3">구분</span>
				<span id="div_상단바4">내용</span>
				<span id="div_상단바5">작성자</span>
				<span id="div_상단바6">등록일자</span>
			</div>
			
			<% for(int i=2; i<=7; i++) { %>
				<div id="div_content_small_box<%=i%>">
					<div id="div_상단바<%=i%>-1"><%=listQAListDto.get(i-2).getProductInquiryIdx() %></div>
					<div id="div_상단바<%=i%>-2">답변<%=(listQAListDto.get(i-2).getAnswer() != null ? "완료" : "대기") %></div>
					<div id="div_상단바<%=i%>-3"><%=listQAListDto.get(i-2).getGubun()%></div>
					<div id="div_상단바<%=i%>-4">
						<%=listQAListDto.get(i-2).getTitle() %>
						<% if(listQAListDto.get(i-2).getSecretPost()==0) {  // 비밀글일 때 %>
							<img src="img/QA_열쇠.png">
						<% } %>
					</div>
					<div id="div_상단바<%=i%>-5"><%=listQAListDto.get(i-2).getEmail() %></div>
					<div id="div_상단바<%=i%>-6"><%=listQAListDto.get(i-2).getRegisterDate().split(" ")[0] %></div>
				</div>
			<% } %>
			<%--
			<div id="div_content_small_box2">
				<span id="div_상단바2-1">2,769</span>
				<span id="div_상단바2-2">답변완료</span>
				<span id="div_상단바2-3">사이즈</span>
				<span id="div_상단바2-4">
					상품 관련 문의입니다.
					<img src="img/QA_열쇠.png">
				</span>
				<span id="div_상단바2-5">nic***</span>
				<span id="div_상단바2-6">2024-02-28</span>
			</div>
			<div id="div_content_small_box3">
				<span id="div_상단바3-1">2,768</span>
				<span id="div_상단바3-2">답변완료</span>
				<span id="div_상단바3-3">배송</span>
				<span id="div_상단바3-4">
					상품 관련 문의입니다.
					<img src="img/QA_열쇠.png">
				</span>
				<span id="div_상단바3-5">soo***</span>
				<span id="div_상단바3-6">2024-02-25</span>
			</div>
			<div id="div_content_small_box4">
				<span id="div_상단바4-1">2,767</span>
				<span id="div_상단바4-2">답변완료</span>
				<span id="div_상단바4-3">재입고</span>
				<span id="div_상단바4-4">
					상품 관련 문의입니다.
					<img src="img/QA_열쇠.png">
				</span>
				<span id="div_상단바4-5">soy***</span>
				<span id="div_상단바4-6">2024-02-23</span>
			</div>
			<div id="div_content_small_box5">
				<span id="div_상단바5-1">2,766</span>
				<span id="div_상단바5-2">답변완료</span>
				<span id="div_상단바5-3">배송</span>
				<span id="div_상단바5-4">
					상품 관련 문의입니다.
					<img src="img/QA_열쇠.png">
				</span>
				<span id="div_상단바5-5">dhs***</span>
				<span id="div_상단바5-6">2024-02-21</span>
			</div>
			<div id="div_content_small_box6">
				<span id="div_상단바6-1">2,765</span>
				<span id="div_상단바6-2">답변완료</span>
				<span id="div_상단바6-3">재입고</span>
				<span id="div_상단바6-4">환불 문의</span>
				<span id="div_상단바6-5">uyt***</span>
				<span id="div_상단바6-6">2024-02-19</span>
			</div>
			<div id="div_content_small_box7">
				<span id="div_상단바7-1">2,764</span>
				<span id="div_상단바7-2">답변완료</span>
				<span id="div_상단바7-3">배송</span>
				<span id="div_상단바7-4">배송 관련 문의</span>
				<span id="div_상단바7-5">jan***</span>
				<span id="div_상단바7-6">2024-02-14</span>
			</div>
		
			--%>
		
		
		
		</div>
		<div id="div_content_box4">
			<span id="div_page_box">1/277페이지</span>
		</div>
		<div id="div_content_box5">
			<div id="div_page_down_box1">
				<img src="img/QA_더블우측꺽쇠.png"> 
			</div>
			<div id="div_page_down_box1">
				<img src="img/QA_우측꺽쇠.png">
			</div>
			<div id="div_page_down_box1">5</div>
			<div id="div_page_down_box1">4</div>
			<div id="div_page_down_box1">3</div>
			<div id="div_page_down_box1">2</div>
			<div id="div_page_down_box1">1</div>
			<div id="div_page_down_box1">
				<img src="img/QA_좌측꺽쇠.png">
			</div>
			<div id="div_page_down_box1">
				<img src="img/QA_더블좌측꺽쇠.png">
			</div>
		</div>
		<div id="div_content_box6">
			<button id="div_QA_down_button1">작성하기</button>
			<span id="div_QA_down_content1">타 쇼핑몰 언급, 거래 글, 분쟁 유발, 허위 사실 유포는 금지됩니다.</span>
		</div>
	</div>
	</div>
	</div>
<!-- Q&A글 클릭 시 -->
	<div id="div_QA_main_open">
		<div id="div_main_content_screen">
		<div id="div_main_content1">
			SPIGEN
		</div>
		<div id="div_main_content2">
			<div id="div_middle_content1">
				<span id="div_coment1">
					안녕하세요. SPIGEN 입니다.
				</span> <br/>
			</div>
			<div id="div_middle_content1">
				<span id="div_coment1">
					상품 구매 전 옵션에 특정 결함이 노출이 안 되는 경우, 일시적인 판매중지 및 품절인 상태인 점 안내해 드립니다.
				</span>
				<span id="div_coment1">
					문의하신 사항에 대한 자세한 답변은 판매 재개 후 이용이 가능한 점 양해 부탁드립니다
				</span>
			</div>
			<div id="div_middle_content1">
				<span id="div_coment1">
					이용에 도움 드리지 못해 죄송합니다.
				</span>
			</div>
			<div id="div_middle_content1">
				<span id="div_coment1">
					회원님의 편안한 쇼핑을 위해 최선을 다하겠습니다.
					감사합니다.
				</span>
			</div>
		</div>
		<div id="div_main_content3">
			<div id="div_back_QA_button_box">
				<button id="div_back_QA_main_page">
					<img id="div_back_QA_main_page_img" src="img/meta_X_logo.png">
				</button>
			</div>
			2024-02-19
		</div>
	</div>
	</div>
		
<!-- Q&A작성버튼 클릭 시 -->

	<div id="div_QA_write_page_open">
		<div id="div_main_screen">
		<div id="div_QA_write_header1">
			<div id="div_QA_write_header_content1">
				<div id="div_QA_product_inquiry_box">
					상품문의
				</div>
				<div id="div_QA_write_back_button_box">
					<button id="div_QA_write_back_button_cover_box">
						<img id="div_QA_write_back_button" src="img/meta_X_logo.png">
					</button>
				</div>
			</div>
		</div>
		<div id="div_QA_write_content1">
			<img id="div_QA_write_product_img" src="img/QA_작성상품.png">
			<div id="div_QA_write_product_box1">
				<div id="div_QA_write_product_small_box1">
					<div id="div_QA_write_product_text1">iPhone 15 Pro Max Case</div>
				</div>
				<div id="div_QA_write_product_small_box2">
					<div id="div_QA_write_product_text2">Tough Armor (MagFit)</div>
				</div>
				<div id="div_QA_write_product_small_box3">
					<div id="div_QA_write_product_text3">가격: 59,000원</div>
				</div>
			</div>
		</div>
		<div id="div_QA_write_content2">
			<div id="div_inquiry_type_box1">
				문의유형
				<input id="div_inquiry_type" type="radio" name="value1" value="사이즈">
				사이즈
				<input id="div_inquiry_type" type="radio" name="value1" value="배송">
				배송
				<input id="div_inquiry_type" type="radio" name="value1" value="재입고">
				재입고
				<input id="div_inquiry_type" type="radio" name="value1" value="상품상세문의">
				상품상세문의
			</div>
			<div id="div_inquiry_type_box2">
				<b>
					- 클레임(교환/환불/취소)관련 문의는 마이페이지>1:1문의에서 문의바랍니다.
				</b>
			</div>
		</div>
		<div id="div_QA_write_content3">
			<div id="div_QA_write_title1">
				제목
			</div>
			<input type="text" id="div_input_box1" placeholder="15자 이내 입력">
			<div id="div_secret_box">
				<input type="checkbox" id="div_check_box1" name="제목" value="title">
				비밀글
			</div>
		</div>
		<div id="div_QA_write_content4">
			<div id="div_내용">
				내용
			</div>
			<div id="div_내용_box1">
				<input type="text" id="div_내용_box2" placeholder="내용 입력">
			</div>
		</div>
		<div id="div_content5">
			<button id="div_플러스_button" style="font-size: 15px;">+</button>
		</div>
	</div>
	</div>


</body>
</html>