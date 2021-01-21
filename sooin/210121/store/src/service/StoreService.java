package service;

import java.util.ArrayList;

import dao.StoreDAO;
import vo.Stuff;

public class StoreService {
	static StoreDAO dao = new StoreDAO();

	public boolean signUp(String id, String pwd, int balance) {

		boolean result = dao.insertUser(id, pwd, balance);
		return result;
	}

	public boolean login(String id, String pwd) {
		boolean result = dao.login(id, pwd);
		return result;
	}

	public boolean pay(String id, String productName) {
		boolean result = dao.updateProduct(id, productName);
		return result;
	}

	public boolean charge(String id, int balance) {
		boolean result = dao.insertBalance(id, balance);
		return result;
	}
	
	public boolean addProduct(String productName, int productPrice) {
		boolean result = dao.addProduct(productName, productPrice);
		return result;
	}
	public ArrayList<Stuff> productList() {
		ArrayList<Stuff>stuffs = dao.productList();
		return stuffs;
	}
}