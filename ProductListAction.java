package com.internousdev.jupiter.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.jupiter.dao.ProductInfoDAO;
import com.internousdev.jupiter.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductListAction extends ActionSupport implements SessionAware {
	private List<ProductInfoDTO> productInfoDTOList;
	private Map<String, Object> session;

	public String execute() throws SQLException {

//		 セッションのタイムアウトを記載
		if (session.isEmpty()) {
			return "sessionTimeout";
		}

		// DAOから商品一覧表示メソッドを呼び出す
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		productInfoDTOList = productInfoDAO.getProductInfoList();

		return SUCCESS;
	}

	public List<ProductInfoDTO> getProductInfoDTOList() {
		return productInfoDTOList;
	}

	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList) {
		this.productInfoDTOList = productInfoDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

