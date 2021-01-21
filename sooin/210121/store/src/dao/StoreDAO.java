package dao;

import java.util.ArrayList;

import vo.Stuff;
import vo.User;

public class StoreDAO {

	// 회원 목록을 가지고 있는 ArryaList입니다.
	private ArrayList<User> users = new ArrayList<User>();

	// 물건 목록을 가지고 있는 ArrayList입니다.
	private ArrayList<Stuff> stuffs = new ArrayList<Stuff>();

	public boolean insertUser(String id, String pwd, int balance) {
		boolean result = false;
		if (selectById(id) == null) {// 생성되어있는 id가 없다면 저장
			User user = new User(id, pwd, balance);
			users.add(user);
			result = true;
		} else {// 같은 아이디가 이미 생성되어 있다면 false
			result = false;
		}
		return result;
	}

	public boolean login(String id, String pwd) {

		User user = selectById(id);

		boolean result = false;

		if (user.getPwd().equals(pwd)) {
			result = true;
		} else {
			result = false;
		}
		return result;

	}

	public User selectById(String id) {
		User member = null;
		for (int i = 0; i < users.size(); i++) {

			if (users.get(i).getId().equals(id)) {
				member = users.get(i);
				break;
			} else {
				member = null;
			}
		}
		return member;
	}

	public boolean updateProduct(String id, String productName) {
		
		boolean result = false;
		Stuff getStuff = selectByStuff(productName);
		
		if (getStuff != null) {// 물품이름으로 찾은 객체가 존재하는 경우
			int productPrice = getStuff.getPrice();
			User member = selectById(id);
			if (member != null) {// id로 찾은 객체가 존재하는 경우
				if (member.getBalance() >= productPrice) {// 잔액이 물건 가격보다 크거나 같은경우
					member.setBalance(member.getBalance() - productPrice);
					result = true;
				} else {
					result = false;
				}

			} else {
				result = false;
			}

		} else {
			result = false;
		}
		return result;

	}

	

	public Stuff selectByStuff(String productName) {
		Stuff getStuff = null;
		for(int i = 0; i<stuffs.size(); i++) {
			if(stuffs.get(i).getName().equals(productName)){
				getStuff = stuffs.get(i);
				break;
			}else {
				getStuff = null;
			}
		}return getStuff;

	}

	
	public boolean insertBalance(String id, int balance) {
		boolean result = false;

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(id)) {
				users.get(i).setBalance(balance + users.get(i).getBalance());
				User user = users.get(i);
				users.add(user);
				result = true;
				System.out.println("if : " + users.get(i).getId());
				break;
			} else {
				result = false;
			}
			System.out.println("if2 : " + users.get(i).getId());
		}
		return result;
	}

	
	public boolean addProduct(String productName, int productPrice) {
		boolean result = false;
		
		if(selectByStuff(productName) == null) {//저장된 같은 이름의 제품이 없다면 저장
			Stuff stuff = new Stuff(productName, productPrice);
			stuffs.add(stuff);
			result = true;
		}else {
			result = false;
		}return result;
	}

	public ArrayList<Stuff> productList() {
		
		ArrayList<Stuff> stuffs1 = stuffs;
		return stuffs1;
	}

}
