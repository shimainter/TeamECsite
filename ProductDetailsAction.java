package com.internousdev.jupiter.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.jupiter.dao.ProductInfoDAO;
import com.internousdev.jupiter.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailsAction extends ActionSupport implements SessionAware {

	private int productId;
	private String productName;
	private String productNameKana;
	private String productDescription;
	private int categoryId;
	private int price;
	private String imageFilePath;
	private String imageFileName;
	private Date releaseDate;
	private String releaseCompany;
	private List<Integer> productCountList;
	private List<ProductInfoDTO> relatedProductList;
	private Map<String, Object> session;

	public String execute() throws SQLException {

		// セッションのタイムアウトを記載
		 if (session.isEmpty()) {
		 return "sessionTimeout";
		 }

		// 商品情報の詳細情報
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		productInfoDTO = productInfoDAO.getProductInfo(productId);

		// sessionを使いカートに情報を送る
		session.put("addCartList", productInfoDTO);

		productId = productInfoDTO.getProductId();
		productName = productInfoDTO.getProductName();
		productNameKana = productInfoDTO.getProductNameKana();
		productDescription = productInfoDTO.getProductDescription();
		categoryId = productInfoDTO.getCategoryId();
		price = productInfoDTO.getPrice();
		imageFilePath = productInfoDTO.getImageFilePath();
		imageFileName = productInfoDTO.getImageFileName();
		releaseDate = productInfoDTO.getReleaseDate();
		releaseCompany = productInfoDTO.getReleaseCompany();
		releaseDate = productInfoDTO.getReleaseDate();
		productDescription = productInfoDTO.getProductDescription();

		// 購入個数のリスト
		productCountList = new ArrayList<Integer>();
		for (int i = 1; i <= 5; i++) {
			productCountList.add(i);
		}

		// 関連商品
		relatedProductList = productInfoDAO.getProductInfoListByCategoryId(productInfoDTO.getCategoryId(),
				productInfoDTO.getProductId(), 0, 3);

		categoryId = 1;

		String result = SUCCESS;

		return result;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNameKana() {
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	public List<Integer> getProductCountList() {
		return productCountList;
	}

	public void setProductCountList(List<Integer> productCountList) {
		this.productCountList = productCountList;
	}

	public List<ProductInfoDTO> getRelatedProductList() {
		return relatedProductList;
	}

	public void setRelatedProductList(List<ProductInfoDTO> relatedProductList) {
		this.relatedProductList = relatedProductList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
