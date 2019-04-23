
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolber" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="./css/productDetails.css">
<link rel="stylesheet" type=text/css href="./css/header.css">
<link rel="stylesheet" type=text/css href="./css/jupiter.css">
<script type="text/javascript" src="./js/header.js"></script>
<title>商品詳細画面</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="contents">
		<h1>商品詳細</h1>
	</div>

	<!-- 		productNameにデータが入っていたら -->
	<s:if test="!productName.isEmpty()">

		<!-- 	カートに送る -->
		<s:form action="AddCartAction">

			<!-- 		写真のリンク -->
			<img
				src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'
				class="productDetails-image">
			<table>
				<tr>
					<th>商品名</th>
					<td><s:property value="productName" /></td>
				</tr>

				<tr>
					<th>商品名ふりがな</th>
					<td><s:property value="productNameKana" /></td>
				</tr>

				<tr>
					<th>値段</th>
					<td><s:property value="price" /> <span>円</span></td>
				</tr>
				<tr>
					<th>購入個数</th>
					<td><s:select name="productCount" list="%{productCountList}" />個</td>
				</tr>
				<tr>
					<th>販売会社</th>
					<td><s:property value="releaseCompany" /></td>
				</tr>
				<tr>
					<th>発売年月日</th>
					<td><s:property value="releaseDate" /></td>
				</tr>

				<tr>
					<th>商品詳細情報</th>
					<td class="Details" valign="top"><s:property
							value="productDescription" escape="false" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<div class ="cartbtn">
							<s:submit value="カートに追加" class="btn" />
						</div>
					</td>
				</tr>
			</table>
		</s:form>
	</s:if>
	<s:else>
		<div class = "message">商品情報がありません</div>
	</s:else>

	<s:if test="!relatedProductList.isEmpty()">
		<!-- 		同カテゴリの関連商品 -->
		<h3>関連商品</h3>

		<s:iterator value="relatedProductList">
			<div class="productDetails">
				<!-- 		画像リンク -->
				<a
					href='<s:url action="ProductDetailsAction">
				<s:param name="productId" value="%{productId}"/>
				</s:url>'>
					<img
					src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'
					width="150px" height="150px"></a> <br>
				<div class="kannren" align="center">
					<s:property value="productName" />
				</div>
			</div>
		</s:iterator>
	</s:if>
</body>
</html>