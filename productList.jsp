<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" Content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="./css/productList.css">
<link rel="stylesheet" type=text/css href="./css/header.css">
<link rel="stylesheet" type=text/css href="./css/jupiter.css">
<script type="text/javascript" src="./js/header.js"></script>
<title>商品一覧画面</title>
</head>

<body>
	<jsp:include page="header.jsp" />
	<div id="main">
<div class="contents">
		<h1>商品一覧画面</h1>
</div>
		<!-- 入力エラーメッセージ -->
		<s:if test="!keywordsErrorMessageList.isEmpty()">
				<div class="error-message">
					<s:iterator value="keywordsErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
		</s:if>

		<s:if test="!productInfoDTOList.isEmpty()">
			<s:iterator value="productInfoDTOList">
				<div id="product-list">
					<s:form>
						<tr>
							<td><a
								href='<s:url action="ProductDetailsAction"><s:param name="productId" value="%{productId}"/>
							</s:url>'><img
									src="<s:property value="imageFilePath" />/<s:property value="imageFileName" />"
									class="productList-image"><input type="hidden"
									name="productId" value="<s:property value='productId' />"></a></td>
							<td><br> <s:property value="productName" /></td>
							<td><br> <s:property value="productNameKana" /></td>
							<td><br> <s:property value="price" /> <span>円</span></td>
						</tr>
					</s:form>
				</div>
			</s:iterator>

		</s:if>
		<s:if test="productInfoDTOList.isEmpty()">
			<div class="message">検索結果がありません。</div>
		</s:if>
	</div>
</body>
</html>