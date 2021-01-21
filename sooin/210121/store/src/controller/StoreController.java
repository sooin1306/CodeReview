package controller;

import java.util.ArrayList;

import service.StoreService;
import vo.Stuff;

public class StoreController {
	static StoreService service = new StoreService();

	public String signUp(String id, String pwd, int option,int balance) {
		String newId = null;
		boolean result;
		String str;
		if(option ==1) {
			newId = id+"u";
			
		}else if(option ==2) {
			newId = id +"m";
		}else {
			result =  false;
		}
		result = service.signUp(newId, pwd,balance);
		if(result) {
			str = "아이디가 생성되었습니다";
		}else {
			str = "이미 생성되어있는 아이디입니다.";
		}
		return str;
	}

	public boolean login(String id,String pwd,int option) {
		String newId;
		
		boolean result;
		
		if(option ==1) {
			newId = id+"u";
			
		}else if(option ==2) {
			newId = id +"m";
		}else {
			result =  false;
			return result;
		}
		result = service.login(newId, pwd);
		
		return result;
	}


	public String pay(String id, int option ,String productName) {
		String newId = null;
		if (option ==1) {
			newId = id + "u";
		}else if(option ==2) {
			newId = id+"m";
		}
		boolean result = service.pay(newId,productName);
		
		String str;
		
		if(result) {
			str = "결제 완료했습니다.";
		}else {
			str = "결제에 실패했습니다 \n 잔액을 확인해주세요";
		}
		return str;
	}
	
	public String charge(String id, int option, int balance) {
		String newId = null;
		if (option == 1) {
			newId = id+"u";
		}else if(option == 2) {
			newId = id + "m";
		}
		
		boolean result = service.charge(newId, balance);
		String str;
		
		if(result) {
			str = "입금 성공 되었습니다.";
		}else {
			str = "입금 실패 하였습니다.";
		}
		return str;
	}
	
	public String addProduct(String productName, int productPrice) {
		boolean result = service.addProduct(productName, productPrice);
		String str;
		if (result) {
			str = "제품등록이 완료되었습니다.";
		}else {
			str = "제품등록에 실패하였습니다.//이미 등록된 제품이 있습니다.";
		}return str;
	}
	public String productList(){
		ArrayList<Stuff> stuffs = service.productList();
		String strStuff = null;
		for(int i = 0; i<stuffs.size();i++ ) {
			strStuff = stuffs.get(i).getName();
			strStuff += strStuff+"\n";
		}return strStuff;

	}
}
