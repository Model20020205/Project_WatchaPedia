<%@page import="java.util.ArrayList"%>
<%@page import="dto.SimpleOptionDto"%>
<%@page import="dto.SimpleProductDto"%>
<%@page import="dao.SpecialProductDao"%>
<%@page import="dto.SpecialProductDetailsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int pdIdx = 1;   // 1 : 그냥 초기값
	try {
		pdIdx = Integer.parseInt(request.getParameter("pd_idx"));
	} catch(Exception e) { }
	String tionOp1 = request.getParameter("tionop1");
	String tionOp2 = request.getParameter("tionop2");

	SpecialProductDao spDao = new SpecialProductDao();
	SimpleProductDto spDto = spDao.getSimpleProductDtoByPdIdx(pdIdx);

	String 옵션출력방식 = spDao.getTypeTionOp(pdIdx);   // "타원형", "드롭다운"
	ArrayList<SimpleOptionDto> listOptionDto = spDao.getListSimpleOption(pdIdx);	
%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Customized</title>
	<link rel= "stylesheet" href="css/Project_CustmizeProduct.css"/>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
	$(document).ready(function(){
	    $('.decrement').click(function(){
	        var input = $(this).siblings('.quantity-input');
	        var value = parseInt(input.val());
	        if(value > 1) {
	            input.val(value - 1);
	        }
	    });

	    $('.increment').click(function(){
	        var input = $(this).siblings('.quantity-input');
	        var value = parseInt(input.val());
	        input.val(value + 1);
	    });
	});
	</script>
</head>
<body>
	<div id= "header">
		<div>
			<div>
				<div><svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 21 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path fill="#4A4A4A" fill-rule="evenodd" d="M10.177 3H14.83c.535 0 .98 0 1.345.03.38.03.736.098 1.073.27a2.75 2.75 0 0 1 1.202 1.202c.172.337.24.693.27 1.073.03.365.03.81.03 1.345v5.91c0 .535 0 .98-.03 1.345-.03.38-.098.736-.27 1.073a2.75 2.75 0 0 1-1.201 1.202c-.338.172-.694.24-1.074.27-.365.03-.81.03-1.345.03H9.963c-.196 0-.347 0-.483-.013a2.75 2.75 0 0 1-2.467-2.467C7 14.134 7 13.983 7 13.787v-.037a.75.75 0 0 1 1.5 0c0 .25 0 .32.006.373a1.25 1.25 0 0 0 1.121 1.121c.052.005.123.006.373.006h4.8c.572 0 .957 0 1.252-.025.288-.023.425-.065.515-.111a1.25 1.25 0 0 0 .547-.546c.046-.091.088-.228.111-.515.024-.296.025-.68.025-1.253V6.95c0-.572 0-.957-.025-1.252-.023-.288-.065-.425-.111-.515a1.25 1.25 0 0 0-.547-.547l.339-.663-.338.663c-.091-.046-.228-.088-.516-.111-.295-.024-.68-.025-1.252-.025h-4.55c-.5 0-.641.004-.744.024a1.25 1.25 0 0 0-.982.982c-.02.103-.024.243-.024.744a.75.75 0 0 1-1.5 0v-.073c0-.393 0-.696.053-.963a2.75 2.75 0 0 1 2.16-2.161C9.482 3 9.784 3 10.178 3ZM4.56 10.5l.97.97a.75.75 0 0 1-1.061 1.06l-2.25-2.25a.75.75 0 0 1 0-1.06l2.25-2.25a.75.75 0 1 1 1.06 1.06L4.56 9h6.69a.75.75 0 0 1 0 1.5H4.56Z" clip-rule="evenodd"></path></svg></div>
				<div><span>Dawn</span></div>
			</div>
			<div>				
				<span>
					<svg viewBox="0 0 20 20"><path d="M6 10c0-.93 0-1.395.102-1.776a3 3 0 0 1 2.121-2.122C8.605 6 9.07 6 10 6c.93 0 1.395 0 1.776.102a3 3 0 0 1 2.122 2.122C14 8.605 14 9.07 14 10s0 1.395-.102 1.777a3 3 0 0 1-2.122 2.12C11.395 14 10.93 14 10 14s-1.395 0-1.777-.102a3 3 0 0 1-2.12-2.121C6 11.395 6 10.93 6 10Z"></path></svg>
					<span style = "white-space:pre;">라이브</span>
				</span>
			</div>
			<div>
				<button>
					<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M6 10a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0Z"></path><path d="M11.5 10a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0Z"></path><path d="M17 10a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0Z"></path></svg>
				</button>
			</div>
		</div>
		<div> \  
			<div>
				<button>
					<div>
						<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path fill-rule="evenodd" d="M3 10a7 7 0 1 1 14 0 7 7 0 0 1-14 0Zm7-5.5a5.497 5.497 0 0 0-4.737 2.703l2 1.999c.472.472.737 1.113.737 1.78v.518a.5.5 0 0 0 .5.5 2 2 0 0 1 2 2v1.478a5.504 5.504 0 0 0 4.52-3.228h-1.02a.75.75 0 0 1-.75-.75v-.5a.75.75 0 0 0-.75-.75h-2.5a1.755 1.755 0 0 1-1.07-3.144l.463-.356a.393.393 0 0 0 .152-.312v-.04c0-.885.62-1.624 1.449-1.808a5.531 5.531 0 0 0-.994-.09Zm2.875.81a1.85 1.85 0 0 1-1.477.735.352.352 0 0 0-.353.353v.04c0 .587-.271 1.14-.736 1.499l-.462.356a.256.256 0 0 0 .153.457h2.5a2.25 2.25 0 0 1 2.236 2h.713a5.497 5.497 0 0 0-2.574-5.44Zm-8.375 4.69c0-.443.052-.875.152-1.288l1.55 1.55c.19.191.298.45.298.72v.518a2 2 0 0 0 2 2 .5.5 0 0 1 .5.5v1.41a5.502 5.502 0 0 1-4.5-5.41Z"></path></svg>
						<div>기본</div>
						<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path fill-rule="evenodd" d="M5.72 8.47a.75.75 0 0 1 1.06 0l3.47 3.47 3.47-3.47a.75.75 0 1 1 1.06 1.06l-4 4a.75.75 0 0 1-1.06 0l-4-4a.75.75 0 0 1 0-1.06Z"></path></svg>
					</div>
				</button>
			</div>
			<div></div>
			<div>
				<button>
					<div>
						<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M13 8a1 1 0 1 0 0-2 1 1 0 0 0 0 2Z"></path><path fill-rule="evenodd" d="M11.276 3.5a3.75 3.75 0 0 0-2.701 1.149l-4.254 4.417a2.75 2.75 0 0 0 .036 3.852l2.898 2.898a2.5 2.5 0 0 0 3.502.033l4.747-4.571a3.25 3.25 0 0 0 .996-2.341v-2.187a3.25 3.25 0 0 0-3.25-3.25h-1.974Zm-1.62 2.19a2.25 2.25 0 0 1 1.62-.69h1.974c.966 0 1.75.784 1.75 1.75v2.187c0 .475-.194.93-.536 1.26l-4.747 4.572a1 1 0 0 1-1.401-.014l-2.898-2.898a1.25 1.25 0 0 1-.016-1.75l4.253-4.418Z"></path></svg>
						<div>기본 제품</div>
						<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path fill-rule="evenodd" d="M5.72 8.47a.75.75 0 0 1 1.06 0l3.47 3.47 3.47-3.47a.75.75 0 1 1 1.06 1.06l-4 4a.75.75 0 0 1-1.06 0l-4-4a.75.75 0 0 1 0-1.06Z"></path></svg>
					</div>
				</button>
			</div>
		</div>
		<div>
			<div>
				<div>
					<button>
						<svg width="20" height="20" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path fill-rule="evenodd" clip-rule="evenodd" d="M3.25 5c0-.966.784-1.75 1.75-1.75h.5a.75.75 0 0 1 0 1.5H5a.25.25 0 0 0-.25.25v.5a.75.75 0 0 1-1.5 0V5Zm0 10c0 .966.784 1.75 1.75 1.75h.5a.75.75 0 0 0 0-1.5H5a.25.25 0 0 1-.25-.25v-.5a.75.75 0 0 0-1.5 0v.5ZM15 3.25c.966 0 1.75.784 1.75 1.75v.5a.75.75 0 0 1-1.5 0V5a.25.25 0 0 0-.25-.25h-.5a.75.75 0 0 1 0-1.5h.5Zm-11 5a.75.75 0 0 1 .75.75v2a.75.75 0 0 1-1.5 0V9A.75.75 0 0 1 4 8.25ZM11.75 4a.75.75 0 0 1-.75.75H9a.75.75 0 0 1 0-1.5h2a.75.75 0 0 1 .75.75Zm-1.506 5.043a.75.75 0 0 0-.957.957l2.121 6.01a.75.75 0 0 0 1.238.28l1.237-1.237 1.415 1.415a.75.75 0 0 0 1.06 0l.354-.354a.75.75 0 0 0 0-1.06l-1.415-1.415 1.238-1.237a.75.75 0 0 0-.28-1.238l-6.011-2.121Z"></path></svg>
					</button>
				</div>
				<div>
					<ul>
						<li>
							<button>
								<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path fill-rule="evenodd" d="M3.5 6.25a2.75 2.75 0 0 1 2.75-2.75h7.5a2.75 2.75 0 0 1 2.75 2.75v4.5a2.75 2.75 0 0 1-2.75 2.75h-1.25v1.5h.75a.75.75 0 0 1 0 1.5h-6.5a.75.75 0 0 1 0-1.5h.75v-1.5h-1.25a2.75 2.75 0 0 1-2.75-2.75v-4.5Zm5.5 7.25h2v1.5h-2v-1.5Zm-2.75-8.5c-.69 0-1.25.56-1.25 1.25v3.25h10v-3.25c0-.69-.56-1.25-1.25-1.25h-7.5Zm8.725 6c-.116.57-.62 1-1.225 1h-7.5a1.25 1.25 0 0 1-1.225-1h9.95Z"></path></svg>
							</button>
						</li>
						<li>
							<button>
								<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M7.75 13.75a.75.75 0 0 1 .75-.75h3a.75.75 0 0 1 0 1.5h-3a.75.75 0 0 1-.75-.75Z"></path><path fill-rule="evenodd" d="M4.75 5.75a2.75 2.75 0 0 1 2.75-2.75h5a2.75 2.75 0 0 1 2.75 2.75v8.5a2.75 2.75 0 0 1-2.75 2.75h-5a2.75 2.75 0 0 1-2.75-2.75v-8.5Zm2.75-1.25c-.69 0-1.25.56-1.25 1.25v8.5c0 .69.56 1.25 1.25 1.25h5c.69 0 1.25-.56 1.25-1.25v-8.5c0-.69-.56-1.25-1.25-1.25h-.531a1 1 0 0 1-.969.75h-2a1 1 0 0 1-.969-.75h-.531Z"></path></svg>
							</button>
						</li>
						<li>
							<button>
								<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M4 5.75a2.75 2.75 0 0 1 2.75-2.75h6.5a2.75 2.75 0 0 1 2.75 2.75v.875a.75.75 0 0 1-1.5 0v-.875c0-.69-.56-1.25-1.25-1.25h-6.5c-.69 0-1.25.56-1.25 1.25v.875a.75.75 0 0 1-1.5 0v-.875Z"></path><path d="M4.75 12.625a.75.75 0 0 1 .75.75v.875c0 .69.56 1.25 1.25 1.25h6.5c.69 0 1.25-.56 1.25-1.25v-.875a.75.75 0 0 1 1.5 0v.875a2.75 2.75 0 0 1-2.75 2.75h-6.5a2.75 2.75 0 0 1-2.75-2.75v-.875a.75.75 0 0 1 .75-.75Z"></path><path d="M9.75 10a.75.75 0 0 1-.75.75h-2.44l.72.72a.75.75 0 1 1-1.06 1.06l-2-2a.75.75 0 0 1 0-1.06l2-2a.75.75 0 1 1 1.06 1.06l-.72.72h2.44a.75.75 0 0 1 .75.75Z"></path><path d="M11 10.75a.75.75 0 0 1 0-1.5h2.44l-.72-.72a.75.75 0 0 1 1.06-1.06l2 2a.75.75 0 0 1 0 1.06l-2 2a.75.75 0 1 1-1.06-1.06l.72-.72h-2.44Z"></path></svg>
							</button>
						</li>
					</ul>
				</div>
				<div>
					<button>
						<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M7.47 3.72a.75.75 0 0 1 1.06 1.06l-1.72 1.72h3.94a5 5 0 0 1 0 10h-1.5a.75.75 0 0 1 0-1.5h1.5a3.5 3.5 0 1 0 0-7h-3.94l1.72 1.72a.75.75 0 1 1-1.06 1.06l-3-3a.75.75 0 0 1 0-1.06l3-3Z"></path></svg>
					</button>
					<button>
						<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M12.53 3.72a.75.75 0 1 0-1.06 1.06l1.72 1.72h-3.94a5 5 0 0 0 0 10h1.5a.75.75 0 0 0 0-1.5h-1.5a3.5 3.5 0 1 1 0-7h3.94l-1.72 1.72a.75.75 0 1 0 1.06 1.06l3-3a.75.75 0 0 0 0-1.06l-3-3Z"></path></svg>
					</button>
				</div>
			</div>
			<div>
				<button>
					<span>저장</span>
				</button>
			</div>
		</div>
	</div>
	<div id= "boad">
		<div id="boad_1">
			<ul>
				<li>
					<button>
						<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M3.5 6.25c0-1.519 1.231-2.75 2.75-2.75.414 0 .75.336.75.75s-.336.75-.75.75c-.69 0-1.25.56-1.25 1.25 0 .414-.336.75-.75.75s-.75-.336-.75-.75Z"></path><path fill-rule="evenodd" d="M3.5 9.25c0-.966.784-1.75 1.75-1.75h9.5c.966 0 1.75.784 1.75 1.75v1.5c0 .966-.784 1.75-1.75 1.75h-9.5c-.966 0-1.75-.784-1.75-1.75v-1.5Zm1.75-.25c-.138 0-.25.112-.25.25v1.5c0 .138.112.25.25.25h9.5c.138 0 .25-.112.25-.25v-1.5c0-.138-.112-.25-.25-.25h-9.5Z"></path><path d="M3.5 13.75c0 1.519 1.231 2.75 2.75 2.75.414 0 .75-.336.75-.75s-.336-.75-.75-.75c-.69 0-1.25-.56-1.25-1.25 0-.414-.336-.75-.75-.75s-.75.336-.75.75Z"></path><path d="M13.75 3.5c1.519 0 2.75 1.231 2.75 2.75 0 .414-.336.75-.75.75s-.75-.336-.75-.75c0-.69-.56-1.25-1.25-1.25-.414 0-.75-.336-.75-.75s.336-.75.75-.75Z"></path><path d="M13.75 16.5c1.519 0 2.75-1.231 2.75-2.75 0-.414-.336-.75-.75-.75s-.75.336-.75.75c0 .69-.56 1.25-1.25 1.25-.414 0-.75.336-.75.75s.336.75.75.75Z"></path><path d="M11.75 4.25c0 .414-.336.75-.75.75h-2c-.414 0-.75-.336-.75-.75s.336-.75.75-.75h2c.414 0 .75.336.75.75Z"></path><path d="M11 16.5c.414 0 .75-.336.75-.75s-.336-.75-.75-.75h-2c-.414 0-.75.336-.75.75s.336.75.75.75h2Z"></path></svg>
					</button>
				</li>
				<li>
					<button>
						<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path fill-rule="evenodd" d="M12.5 10a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0Zm-1.5 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0Z"></path><path fill-rule="evenodd" d="M9.377 2.5c-.926 0-1.676.75-1.676 1.676v.688c0 .056-.043.17-.198.251-.153.08-.303.168-.448.262-.147.097-.268.076-.318.048l-.6-.346a1.676 1.676 0 0 0-2.29.613l-.622 1.08a1.676 1.676 0 0 0 .613 2.289l.648.374c.048.028.124.12.119.29a5.484 5.484 0 0 0 .005.465c.009.175-.07.27-.119.299l-.653.377a1.676 1.676 0 0 0-.613 2.29l.623 1.08a1.676 1.676 0 0 0 2.29.613l.7-.405c.048-.028.166-.048.312.043.115.071.233.139.353.202.155.08.198.195.198.251v.811c0 .926.75 1.676 1.676 1.676h1.246c.926 0 1.676-.75 1.676-1.676v-.81c0-.057.042-.171.197-.252.121-.063.239-.13.354-.202.146-.091.264-.07.312-.043l.7.405a1.676 1.676 0 0 0 2.29-.614l.623-1.08a1.676 1.676 0 0 0-.613-2.289l-.653-.377c-.05-.029-.128-.123-.119-.3a5.494 5.494 0 0 0 .005-.463c-.005-.171.07-.263.12-.291l.647-.374a1.676 1.676 0 0 0 .613-2.29l-.623-1.079a1.676 1.676 0 0 0-2.29-.613l-.6.346c-.049.028-.17.048-.318-.048a5.4 5.4 0 0 0-.448-.262c-.155-.081-.197-.195-.197-.251v-.688c0-.926-.75-1.676-1.676-1.676h-1.246Zm-.176 1.676c0-.097.078-.176.176-.176h1.246c.097 0 .176.079.176.176v.688c0 .728.462 1.298 1.003 1.58.11.058.219.122.323.19.517.337 1.25.458 1.888.09l.6-.346a.176.176 0 0 1 .24.064l.623 1.08a.176.176 0 0 1-.064.24l-.648.374c-.623.36-.888 1.034-.868 1.638a4.184 4.184 0 0 1-.004.337c-.032.615.23 1.31.867 1.677l.653.377a.176.176 0 0 1 .064.24l-.623 1.08a.176.176 0 0 1-.24.065l-.701-.405c-.624-.36-1.341-.251-1.855.069a3.91 3.91 0 0 1-.255.145c-.54.283-1.003.853-1.003 1.581v.811a.176.176 0 0 1-.176.176h-1.246a.176.176 0 0 1-.176-.176v-.81c0-.73-.462-1.3-1.003-1.582a3.873 3.873 0 0 1-.255-.146c-.514-.32-1.23-.428-1.855-.068l-.7.405a.176.176 0 0 1-.241-.065l-.623-1.08a.176.176 0 0 1 .064-.24l.653-.377c.637-.368.899-1.062.867-1.677a3.97 3.97 0 0 1-.004-.337c.02-.604-.245-1.278-.868-1.638l-.648-.374a.176.176 0 0 1-.064-.24l.623-1.08a.176.176 0 0 1 .24-.064l.6.346c.638.368 1.37.247 1.888-.09a3.85 3.85 0 0 1 .323-.19c.54-.282 1.003-.852 1.003-1.58v-.688Z"></path></svg>
					</button>
				</li>
			</ul>
		</div>
		<div id="boad_2">
			<div>
				<div>
					<div>
						<div>
							<div><h1>Default product</h1></div>
							<div>
								<div>
									<h3>미리 보기</h3>
									<button>
										<span>변경</span>
									</button>
								</div>
								<div>
									<div>
										<div>
											<a>Tong Armor</a>
										</div>
										<div>
											<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg" focusable="false" aria-hidden="true"><path d="M11.75 4.5a.75.75 0 0 0 0 1.5h1.19l-2.72 2.72a.75.75 0 1 0 1.06 1.06l2.72-2.72v1.19a.75.75 0 0 0 1.5 0v-3a.75.75 0 0 0-.75-.75h-3Z"></path><path d="M15 11.25a.75.75 0 0 0-1.5 0v1c0 .69-.56 1.25-1.25 1.25h-4.5c-.69 0-1.25-.56-1.25-1.25v-4.5c0-.69.56-1.25 1.25-1.25h1a.75.75 0 0 0 0-1.5h-1a2.75 2.75 0 0 0-2.75 2.75v4.5a2.75 2.75 0 0 0 2.75 2.75h4.5a2.75 2.75 0 0 0 2.75-2.75v-1Z"></path></svg>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div style= "overflow-x: hidden; overflow-y: scroll;">
				<section>
					<div id="head_text">
						<section>
							<h3>머리글</h3>
						</section>
						<section>
							<ol class="list">
								<li>
									<div>
										<button class="one__">
											<svg viewBox="0 0 20 20" class="two_ Online-Store-UI-IconWrapper__Icon_1aflm"><path fill-rule="evenodd" d="M6.24 8.2a.75.75 0 0 1 1.06.04l2.7 2.908 2.7-2.908a.75.75 0 1 1 1.1 1.02l-3.25 3.5a.75.75 0 0 1-1.1 0l-3.25-3.5a.75.75 0 0 1 .04-1.06Z"></path></svg>
											<svg viewBox="0 0 20 20" class="two_ Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M3.5 6.25c0-1.519 1.231-2.75 2.75-2.75.414 0 .75.336.75.75s-.336.75-.75.75c-.69 0-1.25.56-1.25 1.25 0 .414-.336.75-.75.75s-.75-.336-.75-.75Z"></path><path fill-rule="evenodd" d="M3.5 9.25c0-.966.784-1.75 1.75-1.75h9.5c.966 0 1.75.784 1.75 1.75v1.5c0 .966-.784 1.75-1.75 1.75h-9.5c-.966 0-1.75-.784-1.75-1.75v-1.5Zm1.75-.25c-.138 0-.25.112-.25.25v1.5c0 .138.112.25.25.25h9.5c.138 0 .25-.112.25-.25v-1.5c0-.138-.112-.25-.25-.25h-9.5Z"></path><path d="M3.5 13.75c0 1.519 1.231 2.75 2.75 2.75.414 0 .75-.336.75-.75s-.336-.75-.75-.75c-.69 0-1.25-.56-1.25-1.25 0-.414-.336-.75-.75-.75s-.75.336-.75.75Z"></path><path d="M13.75 3.5c1.519 0 2.75 1.231 2.75 2.75 0 .414-.336.75-.75.75s-.75-.336-.75-.75c0-.69-.56-1.25-1.25-1.25-.414 0-.75-.336-.75-.75s.336-.75.75-.75Z"></path><path d="M13.75 16.5c1.519 0 2.75-1.231 2.75-2.75 0-.414-.336-.75-.75-.75s-.75.336-.75.75c0 .69-.56 1.25-1.25 1.25-.414 0-.75.336-.75.75s.336.75.75.75Z"></path><path d="M11.75 4.25c0 .414-.336.75-.75.75h-2c-.414 0-.75-.336-.75-.75s.336-.75.75-.75h2c.414 0 .75.336.75.75Z"></path><path d="M11 16.5c.414 0 .75-.336.75-.75s-.336-.75-.75-.75h-2c-.414 0-.75.336-.75.75s.336.75.75.75h2Z"></path></svg>
											<span class="two__">공지 표시줄</span>
										</button>
									</div>
									<div>
										<ol class="list">
											<li>
												<button class="one__">
													<svg viewBox="0 0 20 20" class="two_ Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M5 6.25c0-.69.56-1.25 1.25-1.25h2a.75.75 0 0 0 0-1.5h-2a2.75 2.75 0 0 0-2.75 2.75v2a.75.75 0 0 0 1.5 0v-2Z"></path><path d="M13.75 5c.69 0 1.25.56 1.25 1.25v2a.75.75 0 0 0 1.5 0v-2a2.75 2.75 0 0 0-2.75-2.75h-2a.75.75 0 0 0 0 1.5h2Z"></path><path d="M13.75 15c.69 0 1.25-.56 1.25-1.25v-2a.75.75 0 0 1 1.5 0v2a2.75 2.75 0 0 1-2.75 2.75h-2a.75.75 0 0 1 0-1.5h2Z"></path><path d="M6.25 15c-.69 0-1.25-.56-1.25-1.25v-2a.75.75 0 0 0-1.5 0v2a2.75 2.75 0 0 0 2.75 2.75h2a.75.75 0 0 0 0-1.5h-2Z"></path></svg>
													<span class="two__">~~~대박 할인 이벤트~~~</span>
												</button>
											</li>
											<li>
												<button class="one__">
													<span>
														<span class="two_ fl">
														<svg viewBox="0 0 20 20" class="two_ Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M5 6.25c0-.69.56-1.25 1.25-1.25h2a.75.75 0 0 0 0-1.5h-2a2.75 2.75 0 0 0-2.75 2.75v2a.75.75 0 0 0 1.5 0v-2Z"></path><path d="M13.75 5c.69 0 1.25.56 1.25 1.25v2a.75.75 0 0 0 1.5 0v-2a2.75 2.75 0 0 0-2.75-2.75h-2a.75.75 0 0 0 0 1.5h2Z"></path><path d="M13.75 15c.69 0 1.25-.56 1.25-1.25v-2a.75.75 0 0 1 1.5 0v2a2.75 2.75 0 0 1-2.75 2.75h-2a.75.75 0 0 1 0-1.5h2Z"></path><path d="M6.25 15c-.69 0-1.25-.56-1.25-1.25v-2a.75.75 0 0 0-1.5 0v2a2.75 2.75 0 0 0 2.75 2.75h2a.75.75 0 0 0 0-1.5h-2Z"></path></svg>
														</span>
														<span class="two__ fl">내가 이 세상에서 가장 강력한 케이스다!!</span>
													</span>
												</button>
											</li>
											<li>
												<button class="one__">
													<svg viewBox="0 0 20 20" class="two_ Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M5 6.25c0-.69.56-1.25 1.25-1.25h2a.75.75 0 0 0 0-1.5h-2a2.75 2.75 0 0 0-2.75 2.75v2a.75.75 0 0 0 1.5 0v-2Z"></path><path d="M13.75 5c.69 0 1.25.56 1.25 1.25v2a.75.75 0 0 0 1.5 0v-2a2.75 2.75 0 0 0-2.75-2.75h-2a.75.75 0 0 0 0 1.5h2Z"></path><path d="M13.75 15c.69 0 1.25-.56 1.25-1.25v-2a.75.75 0 0 1 1.5 0v2a2.75 2.75 0 0 1-2.75 2.75h-2a.75.75 0 0 1 0-1.5h2Z"></path><path d="M6.25 15c-.69 0-1.25-.56-1.25-1.25v-2a.75.75 0 0 0-1.5 0v2a2.75 2.75 0 0 0 2.75 2.75h2a.75.75 0 0 0 0-1.5h-2Z"></path></svg>
													<span class="two__">Welcome to our store</span>
												</button>
											</li>
											<li>
												<button class="one__">
													<svg style= "fill: #005bd3;" viewBox="0 0 20 20" class="two_ Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M6.25 10a.75.75 0 0 1 .75-.75h2.25v-2.25a.75.75 0 0 1 1.5 0v2.25h2.25a.75.75 0 0 1 0 1.5h-2.25v2.25a.75.75 0 0 1-1.5 0v-2.25h-2.25a.75.75 0 0 1-.75-.75Z"></path><path fill-rule="evenodd" d="M10 17a7 7 0 1 0 0-14 7 7 0 0 0 0 14Zm0-1.5a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11Z"></path></svg>
													<span calss="two__"style="color:#005bd3">공지 추가</span>
												</button>
											</li>
										</ol>
									</div>
								</li>
								<li>
									<div>
										<button class="one__">
											<svg viewBox="0 0 20 20" class="two_ Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path fill-rule="evenodd" d="M3.5 5.25c0-.966.784-1.75 1.75-1.75h9.5c.966 0 1.75.784 1.75 1.75v1.5a1.75 1.75 0 0 1-1.75 1.75h-9.5a1.75 1.75 0 0 1-1.75-1.75v-1.5Zm1.75-.25a.25.25 0 0 0-.25.25v1.5c0 .138.112.25.25.25h9.5a.25.25 0 0 0 .25-.25v-1.5a.25.25 0 0 0-.25-.25h-9.5Z"></path><path d="M3.5 11.25c0-.966.784-1.75 1.75-1.75h.5a.75.75 0 0 1 0 1.5h-.5a.25.25 0 0 0-.25.25v.5a.75.75 0 0 1-1.5 0v-.5Z"></path><path d="M3.5 14.75c0 .966.784 1.75 1.75 1.75h.5a.75.75 0 0 0 0-1.5h-.5a.25.25 0 0 1-.25-.25v-.5a.75.75 0 0 0-1.5 0v.5Z"></path><path d="M14.75 9.5c.966 0 1.75.784 1.75 1.75v.5a.75.75 0 0 1-1.5 0v-.5a.25.25 0 0 0-.25-.25h-.5a.75.75 0 0 1 0-1.5h.5Z"></path><path d="M14.75 16.5a1.75 1.75 0 0 0 1.75-1.75v-.5a.75.75 0 0 0-1.5 0v.5a.25.25 0 0 1-.25.25h-.5a.75.75 0 0 0 0 1.5h.5Z"></path><path d="M11.75 10.25a.75.75 0 0 1-.75.75h-2a.75.75 0 0 1 0-1.5h2a.75.75 0 0 1 .75.75Z"></path><path d="M11 16.5a.75.75 0 0 0 0-1.5h-2a.75.75 0 0 0 0 1.5h2Z"></path></svg>
											<span class="two__">머리글</span>
										</button>
									</div>
								</li>
							</ol>
						</section>
					</div>
				</section>
				<section>
					<div id="template">
						<section>
							<h3>템플릿</h3>
						</section>
						<section>
							<ol class="list">
								<li>
									<div>
										<button>
											<svg viewBox="0 0 20 20" class="two_ Online-Store-UI-IconWrapper__Icon_1aflm"><path fill-rule="evenodd" d="M6.24 8.2a.75.75 0 0 1 1.06.04l2.7 2.908 2.7-2.908a.75.75 0 1 1 1.1 1.02l-3.25 3.5a.75.75 0 0 1-1.1 0l-3.25-3.5a.75.75 0 0 1 .04-1.06Z"></path></svg>
											<svg viewBox="0 0 20 20" class="two_ Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M3.5 6.25c0-1.519 1.231-2.75 2.75-2.75.414 0 .75.336.75.75s-.336.75-.75.75c-.69 0-1.25.56-1.25 1.25 0 .414-.336.75-.75.75s-.75-.336-.75-.75Z"></path><path fill-rule="evenodd" d="M3.5 9.25c0-.966.784-1.75 1.75-1.75h9.5c.966 0 1.75.784 1.75 1.75v1.5c0 .966-.784 1.75-1.75 1.75h-9.5c-.966 0-1.75-.784-1.75-1.75v-1.5Zm1.75-.25c-.138 0-.25.112-.25.25v1.5c0 .138.112.25.25.25h9.5c.138 0 .25-.112.25-.25v-1.5c0-.138-.112-.25-.25-.25h-9.5Z"></path><path d="M3.5 13.75c0 1.519 1.231 2.75 2.75 2.75.414 0 .75-.336.75-.75s-.336-.75-.75-.75c-.69 0-1.25-.56-1.25-1.25 0-.414-.336-.75-.75-.75s-.75.336-.75.75Z"></path><path d="M13.75 3.5c1.519 0 2.75 1.231 2.75 2.75 0 .414-.336.75-.75.75s-.75-.336-.75-.75c0-.69-.56-1.25-1.25-1.25-.414 0-.75-.336-.75-.75s.336-.75.75-.75Z"></path><path d="M13.75 16.5c1.519 0 2.75-1.231 2.75-2.75 0-.414-.336-.75-.75-.75s-.75.336-.75.75c0 .69-.56 1.25-1.25 1.25-.414 0-.75.336-.75.75s.336.75.75.75Z"></path><path d="M11.75 4.25c0 .414-.336.75-.75.75h-2c-.414 0-.75-.336-.75-.75s.336-.75.75-.75h2c.414 0 .75.336.75.75Z"></path><path d="M11 16.5c.414 0 .75-.336.75-.75s-.336-.75-.75-.75h-2c-.414 0-.75.336-.75.75s.336.75.75.75h2Z"></path></svg>		
											<span class="two__">제품 정보</span>
										</button>
									</div>
									<ol class="list">
										<li>
											<button class="one__">
												<svg viewBox="0 0 20 20" class="two_" focusable="false" aria-hidden="true"><path d="M4 4.75a.75.75 0 0 1 .75-.75h10.5a.75.75 0 0 1 .75.75v1.5a.75.75 0 0 1-1.5 0v-.75h-3.5v8.75h1.25a.75.75 0 0 1 0 1.5h-4.5a.75.75 0 0 1 0-1.5h1.25v-8.75h-3.5v.75a.75.75 0 0 1-1.5 0v-1.5Z"></path></svg>
												<span class="two__">제목</span>
											</button>
										</li>
										<li>
											<button class="one__">
													<svg viewBox="0 0 20 20" class="two_" focusable="false" aria-hidden="true"><path d="M3.75 4a.75.75 0 0 0 0 1.5h12.5a.75.75 0 0 0 0-1.5h-12.5Z"></path><path d="M4 7.5a.75.75 0 0 0 0 1.5h8a.75.75 0 0 0 0-1.5h-8Z"></path><path d="M3 11.75a.75.75 0 0 1 .75-.75h12.5a.75.75 0 0 1 0 1.5h-12.5a.75.75 0 0 1-.75-.75Z"></path><path d="M4 14.5a.75.75 0 0 0 0 1.5h8a.75.75 0 0 0 0-1.5h-8Z"></path></svg>
													<span class="two__ fl">설명</span>
											</button>
										</li>
										<li>
											<button class="one__">
												<svg viewBox="0 0 20 20" class="two_ Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M8.575 4.649c.707-.734 1.682-1.149 2.7-1.149h1.975c1.795 0 3.25 1.455 3.25 3.25v1.5c0 .414-.336.75-.75.75s-.75-.336-.75-.75v-1.5c0-.966-.784-1.75-1.75-1.75h-1.974c-.611 0-1.197.249-1.62.69l-4.254 4.417c-.473.49-.466 1.269.016 1.75l2.898 2.898c.385.386 1.008.392 1.4.014l.451-.434c.299-.288.773-.279 1.06.02.288.298.28.773-.02 1.06l-.45.434c-.981.945-2.538.93-3.502-.033l-2.898-2.898c-1.06-1.06-1.075-2.772-.036-3.852l4.254-4.417Z"></path><path d="M14 7c0 .552-.448 1-1 1s-1-.448-1-1 .448-1 1-1 1 .448 1 1Z"></path><path d="M13.25 10.857c-.728.257-1.25.952-1.25 1.768 0 1.036.84 1.875 1.875 1.875h.75c.207 0 .375.168.375.375s-.168.375-.375.375h-1.875c-.414 0-.75.336-.75.75s.336.75.75.75h.5v.25c0 .414.336.75.75.75s.75-.336.75-.75v-.254c.977-.064 1.75-.877 1.75-1.871 0-1.036-.84-1.875-1.875-1.875h-.75c-.207 0-.375-.168-.375-.375s.168-.375.375-.375h1.875c.414 0 .75-.336.75-.75s-.336-.75-.75-.75h-1v-.25c0-.414-.336-.75-.75-.75s-.75.336-.75.75v.357Z"></path></svg>
												<span class="two__">가격</span>
											</button>
										</li>
										<li>
											<button class="one__">
												<svg viewBox="0 0 20 20" class="two_ Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path fill-rule="evenodd" d="M6.01 13.99c.122 1.406 1.302 2.51 2.74 2.51h5c1.519 0 2.75-1.231 2.75-2.75v-5c0-1.438-1.104-2.618-2.51-2.74-.122-1.406-1.302-2.51-2.74-2.51h-5c-1.519 0-2.75 1.231-2.75 2.75v5c0 1.438 1.104 2.618 2.51 2.74Zm-.01-5.24c0-1.519 1.231-2.75 2.75-2.75h3.725c-.116-.57-.62-1-1.225-1h-5c-.69 0-1.25.56-1.25 1.25v5c0 .605.43 1.11 1 1.225v-3.725Zm1.5 4.836v-4.836c0-.69.56-1.25 1.25-1.25h4.836l-6.086 6.086Zm7.5.164v-4.836l-6.086 6.086h4.836c.69 0 1.25-.56 1.25-1.25Z"></path></svg>
												<span class="two__">이형 상품 피커</span>
											</button>
										</li>
										<li>
											<button class="one__">
												<svg viewBox="0 0 20 20" class="two_ Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path fill-rule="evenodd" d="M14.239 4.379a.75.75 0 1 0-1.478-.257l-.457 2.628h-3.478l.413-2.371a.75.75 0 0 0-1.478-.257l-.457 2.628h-2.804a.75.75 0 0 0 0 1.5h2.543l-.609 3.5h-2.434a.75.75 0 0 0 0 1.5h2.174l-.413 2.372a.75.75 0 1 0 1.478.257l.457-2.629h3.478l-.413 2.372a.75.75 0 1 0 1.478.257l.457-2.629h2.804a.75.75 0 0 0 0-1.5h-2.543l.609-3.5h2.434a.75.75 0 0 0 0-1.5h-2.174l.413-2.371Zm-6.282 7.371h3.477l.61-3.5h-3.478l-.61 3.5Z"></path></svg>
												<span class="two__">수량 선택기</span>
											</button>
										</li>
										<li>
											<button class="one__">
												<svg viewBox="0 0 20 20" class="two_ Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M6.75 4a3.75 3.75 0 0 0-3.75 3.75v2.5a3.75 3.75 0 0 0 3.75 3.75h1.5a.75.75 0 0 0 0-1.5h-1.5a2.25 2.25 0 0 1-2.25-2.25v-2.5a2.25 2.25 0 0 1 2.25-2.25h6.5a2.25 2.25 0 0 1 2.25 2.25v.5a.75.75 0 0 0 1.5 0v-.5a3.75 3.75 0 0 0-3.75-3.75h-6.5Z"></path><path d="M9.464 8.464a.75.75 0 0 1 .78-.176l6.01 2.12a.75.75 0 0 1 .281 1.238l-1.237 1.238 1.414 1.414a.75.75 0 0 1 0 1.06l-.353.354a.75.75 0 0 1-1.06 0l-1.415-1.414-1.238 1.238a.75.75 0 0 1-1.237-.281l-2.121-6.01a.75.75 0 0 1 .176-.78Z"></path></svg>
												<span class="two__">구매 버튼</span>
											</button>
										</li>
										<li>
											<button class="one__">
												<svg viewBox="0 0 20 20" class="two_ Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M5 6.25c0-.69.56-1.25 1.25-1.25h2a.75.75 0 0 0 0-1.5h-2a2.75 2.75 0 0 0-2.75 2.75v2a.75.75 0 0 0 1.5 0v-2Z"></path><path d="M13.75 5c.69 0 1.25.56 1.25 1.25v2a.75.75 0 0 0 1.5 0v-2a2.75 2.75 0 0 0-2.75-2.75h-2a.75.75 0 0 0 0 1.5h2Z"></path><path d="M13.75 15c.69 0 1.25-.56 1.25-1.25v-2a.75.75 0 0 1 1.5 0v2a2.75 2.75 0 0 1-2.75 2.75h-2a.75.75 0 0 1 0-1.5h2Z"></path><path d="M6.25 15c-.69 0-1.25-.56-1.25-1.25v-2a.75.75 0 0 0-1.5 0v2a2.75 2.75 0 0 0 2.75 2.75h2a.75.75 0 0 0 0-1.5h-2Z"></path></svg>
												<span class="two__">FEATURES</span>
											</button>
										</li>
										<li>
											<button class="one__">
												<svg style= "fill: #005bd3;" viewBox="0 0 20 20" class="two_ Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M6.25 10a.75.75 0 0 1 .75-.75h2.25v-2.25a.75.75 0 0 1 1.5 0v2.25h2.25a.75.75 0 0 1 0 1.5h-2.25v2.25a.75.75 0 0 1-1.5 0v-2.25h-2.25a.75.75 0 0 1-.75-.75Z"></path><path fill-rule="evenodd" d="M10 17a7 7 0 1 0 0-14 7 7 0 0 0 0 14Zm0-1.5a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11Z"></path></svg>
												<span calss="two__"style="color:#005bd3">블록 추가</span>
											</button>
										</li>
									</ol>
									<div>
										<button>
											<div class="two_"></div>
											<svg viewBox="0 0 20 20" class="two_ Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M3.5 6.25c0-1.519 1.231-2.75 2.75-2.75.414 0 .75.336.75.75s-.336.75-.75.75c-.69 0-1.25.56-1.25 1.25 0 .414-.336.75-.75.75s-.75-.336-.75-.75Z"></path><path fill-rule="evenodd" d="M3.5 9.25c0-.966.784-1.75 1.75-1.75h9.5c.966 0 1.75.784 1.75 1.75v1.5c0 .966-.784 1.75-1.75 1.75h-9.5c-.966 0-1.75-.784-1.75-1.75v-1.5Zm1.75-.25c-.138 0-.25.112-.25.25v1.5c0 .138.112.25.25.25h9.5c.138 0 .25-.112.25-.25v-1.5c0-.138-.112-.25-.25-.25h-9.5Z"></path><path d="M3.5 13.75c0 1.519 1.231 2.75 2.75 2.75.414 0 .75-.336.75-.75s-.336-.75-.75-.75c-.69 0-1.25-.56-1.25-1.25 0-.414-.336-.75-.75-.75s-.75.336-.75.75Z"></path><path d="M13.75 3.5c1.519 0 2.75 1.231 2.75 2.75 0 .414-.336.75-.75.75s-.75-.336-.75-.75c0-.69-.56-1.25-1.25-1.25-.414 0-.75-.336-.75-.75s.336-.75.75-.75Z"></path><path d="M13.75 16.5c1.519 0 2.75-1.231 2.75-2.75 0-.414-.336-.75-.75-.75s-.75.336-.75.75c0 .69-.56 1.25-1.25 1.25-.414 0-.75.336-.75.75s.336.75.75.75Z"></path><path d="M11.75 4.25c0 .414-.336.75-.75.75h-2c-.414 0-.75-.336-.75-.75s.336-.75.75-.75h2c.414 0 .75.336.75.75Z"></path><path d="M11 16.5c.414 0 .75-.336.75-.75s-.336-.75-.75-.75h-2c-.414 0-.75.336-.75.75s.336.75.75.75h2Z"></path></svg>		
											<span class="two__">관련 제품</span>
										</button>
										<button class="one__">
											<div class="two_"></div>
											<svg style= "fill: #005bd3;" viewBox="0 0 20 20" class="two_ Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M6.25 10a.75.75 0 0 1 .75-.75h2.25v-2.25a.75.75 0 0 1 1.5 0v2.25h2.25a.75.75 0 0 1 0 1.5h-2.25v2.25a.75.75 0 0 1-1.5 0v-2.25h-2.25a.75.75 0 0 1-.75-.75Z"></path><path fill-rule="evenodd" d="M10 17a7 7 0 1 0 0-14 7 7 0 0 0 0 14Zm0-1.5a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11Z"></path></svg>
											<span calss="two__"style="color:#005bd3">블록 추가</span>
										</button>
									</div>
								</li>
							</ol>
						</section>
						<section>
							<div id = "floor">
								<section>
									<div>
										<h3>바닥글</h3>
									</div>
								</section>
								<section>
									<div>
										<div>
											<ol>
												<li>
													<div>
														<button>
															<svg viewBox="0 0 20 20" class="Online-Store-UI-IconWrapper__Icon_1aflm"><path fill-rule="evenodd" d="M6.24 8.2a.75.75 0 0 1 1.06.04l2.7 2.908 2.7-2.908a.75.75 0 1 1 1.1 1.02l-3.25 3.5a.75.75 0 0 1-1.1 0l-3.25-3.5a.75.75 0 0 1 .04-1.06Z"></path></svg>
															<span>
																<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path fill-rule="evenodd" d="M5.75 4.5c-1.519 0-2.75 1.231-2.75 2.75v5.5c0 1.519 1.231 2.75 2.75 2.75h8.5c1.519 0 2.75-1.231 2.75-2.75v-5.5c0-1.519-1.231-2.75-2.75-2.75h-8.5Zm-1.25 2.75c0-.69.56-1.25 1.25-1.25h8.5c.69 0 1.25.56 1.25 1.25v5.5c0 .69-.56 1.25-1.25 1.25h-8.5c-.69 0-1.25-.56-1.25-1.25v-5.5Zm2.067.32c-.375-.175-.821-.013-.997.363-.175.375-.013.821.363.997l3.538 1.651c.335.156.723.156 1.058 0l3.538-1.651c.376-.176.538-.622.363-.997-.175-.376-.622-.538-.997-.363l-3.433 1.602-3.433-1.602Z"></path></svg>
																<span>이메일 가입</span>
															</span>
														</button>
													</div>
													<div>
														<ol>
															<li class= "liyeon">
																<button>
																	<span>
																		<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M4 4.75a.75.75 0 0 1 .75-.75h10.5a.75.75 0 0 1 .75.75v1.5a.75.75 0 0 1-1.5 0v-.75h-3.5v8.75h1.25a.75.75 0 0 1 0 1.5h-4.5a.75.75 0 0 1 0-1.5h1.25v-8.75h-3.5v.75a.75.75 0 0 1-1.5 0v-1.5Z"></path></svg>
																		<span>Subscribe to our emails</span>
																	</span>
																</button>
															</li>
															<li class= "liyeon">
																<button>
																	<span>
																		<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M3.75 4a.75.75 0 0 0 0 1.5h12.5a.75.75 0 0 0 0-1.5h-12.5Z"></path><path d="M4 7.5a.75.75 0 0 0 0 1.5h8a.75.75 0 0 0 0-1.5h-8Z"></path><path d="M3 11.75a.75.75 0 0 1 .75-.75h12.5a.75.75 0 0 1 0 1.5h-12.5a.75.75 0 0 1-.75-.75Z"></path><path d="M4 14.5a.75.75 0 0 0 0 1.5h8a.75.75 0 0 0 0-1.5h-8Z"></path></svg>
																		<span>소제목</span>
																	</span>
																</button>
															</li>
															<li class= "liyeon">
																<button>
																	<span>
																		<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path fill-rule="evenodd" d="M5.75 4.5c-1.519 0-2.75 1.231-2.75 2.75v5.5c0 1.519 1.231 2.75 2.75 2.75h8.5c1.519 0 2.75-1.231 2.75-2.75v-5.5c0-1.519-1.231-2.75-2.75-2.75h-8.5Zm-1.25 2.75c0-.69.56-1.25 1.25-1.25h8.5c.69 0 1.25.56 1.25 1.25v5.5c0 .69-.56 1.25-1.25 1.25h-8.5c-.69 0-1.25-.56-1.25-1.25v-5.5Zm2.067.32c-.375-.175-.821-.013-.997.363-.175.375-.013.821.363.997l3.538 1.651c.335.156.723.156 1.058 0l3.538-1.651c.376-.176.538-.622.363-.997-.175-.376-.622-.538-.997-.363l-3.433 1.602-3.433-1.602Z"></path></svg>
																		<span>이메일 양식</span>
																	</span>
																</button>
															</li>
														</ol>
													</div>
												</li>
												<li></li>
												<li>
													<div>
														<button>
															<svg viewBox="0 0 20 20" class="Online-Store-UI-IconWrapper__Icon_1aflm"><path fill-rule="evenodd" d="M6.24 8.2a.75.75 0 0 1 1.06.04l2.7 2.908 2.7-2.908a.75.75 0 1 1 1.1 1.02l-3.25 3.5a.75.75 0 0 1-1.1 0l-3.25-3.5a.75.75 0 0 1 .04-1.06Z"></path></svg>
															<span>
																<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M3.5 5.25c0-.966.784-1.75 1.75-1.75h.5a.75.75 0 0 1 0 1.5h-.5a.25.25 0 0 0-.25.25v.5a.75.75 0 0 1-1.5 0v-.5Z"></path><path fill-rule="evenodd" d="M3.5 13.25c0-.966.784-1.75 1.75-1.75h9.5c.966 0 1.75.784 1.75 1.75v1.5a1.75 1.75 0 0 1-1.75 1.75h-9.5a1.75 1.75 0 0 1-1.75-1.75v-1.5Zm1.75-.25a.25.25 0 0 0-.25.25v1.5c0 .138.112.25.25.25h9.5a.25.25 0 0 0 .25-.25v-1.5a.25.25 0 0 0-.25-.25h-9.5Z"></path><path d="M3.5 8.75c0 .966.784 1.75 1.75 1.75h.5a.75.75 0 0 0 0-1.5h-.5a.25.25 0 0 1-.25-.25v-.5a.75.75 0 0 0-1.5 0v.5Z"></path><path d="M14.75 3.5c.966 0 1.75.784 1.75 1.75v.5a.75.75 0 0 1-1.5 0v-.5a.25.25 0 0 0-.25-.25h-.5a.75.75 0 0 1 0-1.5h.5Z"></path><path d="M14.75 10.5a1.75 1.75 0 0 0 1.75-1.75v-.5a.75.75 0 0 0-1.5 0v.5a.25.25 0 0 1-.25.25h-.5a.75.75 0 0 0 0 1.5h.5Z"></path><path d="M11.75 4.25a.75.75 0 0 1-.75.75h-2a.75.75 0 0 1 0-1.5h2a.75.75 0 0 1 .75.75Z"></path><path d="M11 10.5a.75.75 0 0 0 0-1.5h-2a.75.75 0 0 0 0 1.5h2Z"></path></svg>
																<span>바닥글</span>
															</span>
														</button>
													</div>
													<div>
														<ol>
															<li class= "liyeon">
																<button>
																	<span>
																		<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M3.75 4a.75.75 0 0 0 0 1.5h12.5a.75.75 0 0 0 0-1.5h-12.5Z"></path><path d="M4 7.5a.75.75 0 0 0 0 1.5h8a.75.75 0 0 0 0-1.5h-8Z"></path><path d="M3 11.75a.75.75 0 0 1 .75-.75h12.5a.75.75 0 0 1 0 1.5h-12.5a.75.75 0 0 1-.75-.75Z"></path><path d="M4 14.5a.75.75 0 0 0 0 1.5h8a.75.75 0 0 0 0-1.5h-8Z"></path></svg>
																		<span>INFO</span>
																	</span>
																</button>
															</li>
															<li class= "liyeon">
																<button>
																	<span>
																		<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M3.75 4a.75.75 0 0 0 0 1.5h12.5a.75.75 0 0 0 0-1.5h-12.5Z"></path><path d="M4 7.5a.75.75 0 0 0 0 1.5h8a.75.75 0 0 0 0-1.5h-8Z"></path><path d="M3 11.75a.75.75 0 0 1 .75-.75h12.5a.75.75 0 0 1 0 1.5h-12.5a.75.75 0 0 1-.75-.75Z"></path><path d="M4 14.5a.75.75 0 0 0 0 1.5h8a.75.75 0 0 0 0-1.5h-8Z"></path></svg>
																		<span>LEGAL</span>
																	</span>
																</button>
															</li>
															<li class= "liyeon">
																<button>
																	<span>
																		<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M3.75 4a.75.75 0 0 0 0 1.5h12.5a.75.75 0 0 0 0-1.5h-12.5Z"></path><path d="M4 7.5a.75.75 0 0 0 0 1.5h8a.75.75 0 0 0 0-1.5h-8Z"></path><path d="M3 11.75a.75.75 0 0 1 .75-.75h12.5a.75.75 0 0 1 0 1.5h-12.5a.75.75 0 0 1-.75-.75Z"></path><path d="M4 14.5a.75.75 0 0 0 0 1.5h8a.75.75 0 0 0 0-1.5h-8Z"></path></svg>
																		<span>SUPPORT</span>
																	</span>
																</button>
															</li>
															<li class= "liyeon">
																<button>
																	<span>
																		<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M3.75 4a.75.75 0 0 0 0 1.5h12.5a.75.75 0 0 0 0-1.5h-12.5Z"></path><path d="M4 7.5a.75.75 0 0 0 0 1.5h8a.75.75 0 0 0 0-1.5h-8Z"></path><path d="M3 11.75a.75.75 0 0 1 .75-.75h12.5a.75.75 0 0 1 0 1.5h-12.5a.75.75 0 0 1-.75-.75Z"></path><path d="M4 14.5a.75.75 0 0 0 0 1.5h8a.75.75 0 0 0 0-1.5h-8Z"></path></svg>
																		<span>OTHERS</span>
																	</span>
																</button>
															</li>
															<li class= "liyeon">
																<button>
																	<span>
																		<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M3.75 4a.75.75 0 0 0 0 1.5h12.5a.75.75 0 0 0 0-1.5h-12.5Z"></path><path d="M4 7.5a.75.75 0 0 0 0 1.5h8a.75.75 0 0 0 0-1.5h-8Z"></path><path d="M3 11.75a.75.75 0 0 1 .75-.75h12.5a.75.75 0 0 1 0 1.5h-12.5a.75.75 0 0 1-.75-.75Z"></path><path d="M4 14.5a.75.75 0 0 0 0 1.5h8a.75.75 0 0 0 0-1.5h-8Z"></path></svg>
																		<span>Shiver</span>
																	</span>
																</button>
															</li>
															<li class= "liyeon">
																<button>
																	<span>
																		<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M3.75 4a.75.75 0 0 0 0 1.5h12.5a.75.75 0 0 0 0-1.5h-12.5Z"></path><path d="M4 7.5a.75.75 0 0 0 0 1.5h8a.75.75 0 0 0 0-1.5h-8Z"></path><path d="M3 11.75a.75.75 0 0 1 .75-.75h12.5a.75.75 0 0 1 0 1.5h-12.5a.75.75 0 0 1-.75-.75Z"></path><path d="M4 14.5a.75.75 0 0 0 0 1.5h8a.75.75 0 0 0 0-1.5h-8Z"></path></svg>
																		<span>Heading</span>
																	</span>
																</button>
															</li>
															<li class= "liyeon">
																<button>
																	<span>
																		<img src="https://cdn.shopify.com/s/files/1/0645/3939/4240/files/b51a05dbee7ab1a7c4d621c78230fa4a_80x80.svg?v=1713947639"/>
																		<span>Image</span>
																	</span>
																</button>
															</li>
															<li class= "liyeon">
																<button>
																	<span>
																		<svg viewBox="0 0 20 20" class="Polaris-Icon__Svg_375hu" focusable="false" aria-hidden="true"><path d="M6.25 10a.75.75 0 0 1 .75-.75h2.25v-2.25a.75.75 0 0 1 1.5 0v2.25h2.25a.75.75 0 0 1 0 1.5h-2.25v2.25a.75.75 0 0 1-1.5 0v-2.25h-2.25a.75.75 0 0 1-.75-.75Z"></path><path fill-rule="evenodd" d="M10 17a7 7 0 1 0 0-14 7 7 0 0 0 0 14Zm0-1.5a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11Z"></path></svg>
																		<span>블록 추가</span>
																	</span>
																</button>
															</li>
														</ol>
													</div>
												</li>
												<li></li>
											</ol>
										</div>
									</div>
								</section>
							</div>
						</section>
					</div>
				</section>
			</div>
		</div>
		<div id="boad_3">
			<div class="scroll-container">
				<div class="noticeline border">이시영</div>
				<div class="headline border">하는중</div>
				<section class="mainproduct">
					<div class="page-width">
						<div class="product-left-right">
							<div class="product-left">
								<ul class="left-ul">
									<li class="big-li"><img src="<%=spDto.getUpload()%>"></li>
<!-- 									<li class="small-li"><img src="//cdn.shopify.com/s/files/1/0645/3939/4240/files/ToughArmor1.png?v=1714098393&width=1946"></li>
									<li class="small-li"><img src="//cdn.shopify.com/s/files/1/0645/3939/4240/files/ToughArmor2.png?v=1714098436&width=1946"></li> -->
								</ul>
							</div>
							<div class="product-right">
								<div class="right-div">
									<div class="pdtitle">
										<h1><%=spDto.getPdName() %></h1>
									</div>
									<div class="pdcontent">
										<p><%=spDto.getPdContent() %></p>
									</div>
									<div class="pdprice">
										<span>₩<%=spDto.getPrice() %> KRW</span>
									</div>
									<% if("타원형".equals(옵션출력방식)) { %>
										<div class="pdoption">
											<fieldset class="option1">
								                <legend><%=listOptionDto.get(0).getName() %></legend>
								                <% for(int i=1; i<=listOptionDto.size(); i++) { %>
									                <input type="radio" id="op<%=i%>" name="option" value="<%=listOptionDto.get(i-1).getIdx()%>" <%=((i==1) ? "checked" : "") %>>
									                <label for="op<%=i%>" class="custom-radio-btn"><%=listOptionDto.get(i-1).getType() %></label><br>
								                <% } %>
								                <%-- 
								                <input type="radio" id="op1" name="option1" value="1" checked>
								                <label for="op1" class="custom-radio-btn">iphone 15 pro max</label><br>
								                <input type="radio" id="op2" name="option1" value="2">
								                <label for="op2" class="custom-radio-btn">iphone 15 pro</label>
								                <input type="radio" id="op3" name="option1" value="3">
								                <label for="op3" class="custom-radio-btn">iphone 15</label>
								                --%>
								            </fieldset>
										</div>
									<% } else { %>
										<div class="pdoption">
											...
										</div>
									<% } %>
									<div class="pdquantity">
										 <fieldset>
							                <legend>수량</legend>
							                <button class="decrement">-</button>
							                <input type="text" class="quantity-input" value="1">
							                <button class="increment">+</button>
							            </fieldset>
							            
									</div>
									<div class="pdaddcart border"></div>
								</div>
							</div>
						</div>
					</div>
				</section>
				<div class ="relateproduct border"></div>
				<div class ="emailcreate border"></div>
				<footer class ="foot border"></footer>
			</div>
		</div>
		<div id="boad_4">
			<div>
				<div>
					<svg viewBox="0 0 20 20" class="Online-Store-UI-IconWrapper__Icon_1aflm"><path d="M3.5 6.25c0-1.519 1.231-2.75 2.75-2.75.414 0 .75.336.75.75s-.336.75-.75.75c-.69 0-1.25.56-1.25 1.25 0 .414-.336.75-.75.75s-.75-.336-.75-.75Z"></path><path fill-rule="evenodd" d="M3.5 9.25c0-.966.784-1.75 1.75-1.75h9.5c.966 0 1.75.784 1.75 1.75v1.5c0 .966-.784 1.75-1.75 1.75h-9.5c-.966 0-1.75-.784-1.75-1.75v-1.5Zm1.75-.25c-.138 0-.25.112-.25.25v1.5c0 .138.112.25.25.25h9.5c.138 0 .25-.112.25-.25v-1.5c0-.138-.112-.25-.25-.25h-9.5Z"></path><path d="M3.5 13.75c0 1.519 1.231 2.75 2.75 2.75.414 0 .75-.336.75-.75s-.336-.75-.75-.75c-.69 0-1.25-.56-1.25-1.25 0-.414-.336-.75-.75-.75s-.75.336-.75.75Z"></path><path d="M13.75 3.5c1.519 0 2.75 1.231 2.75 2.75 0 .414-.336.75-.75.75s-.75-.336-.75-.75c0-.69-.56-1.25-1.25-1.25-.414 0-.75-.336-.75-.75s.336-.75.75-.75Z"></path><path d="M13.75 16.5c1.519 0 2.75-1.231 2.75-2.75 0-.414-.336-.75-.75-.75s-.75.336-.75.75c0 .69-.56 1.25-1.25 1.25-.414 0-.75.336-.75.75s.336.75.75.75Z"></path><path d="M11.75 4.25c0 .414-.336.75-.75.75h-2c-.414 0-.75-.336-.75-.75s.336-.75.75-.75h2c.414 0 .75.336.75.75Z"></path><path d="M11 16.5c.414 0 .75-.336.75-.75s-.336-.75-.75-.75h-2c-.414 0-.75.336-.75.75s.336.75.75.75h2Z"></path></svg>
				</div>
				<div>
					<h2>템플릿 사용자 지정</h2>
					<p>
						<span>시작하려면 사이드바에서 섹션또는 블록<br/>을 선택합니다.</span>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>