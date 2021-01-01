package com.my.view;

import java.util.List;
import java.util.Scanner;

import com.my.dao.CustomerDAO;
import com.my.dao.CustomerDAOList;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;
import com.my.vo.Customer;

public class CustomerMain {
	private CustomerDAO dao = new CustomerDAOList(3);
	// Scanner타입의 sc멤버변수 선언
	private static Scanner sc = new Scanner(System.in);

	public void findAll() {
		System.out.println(">>1. 고객 전체 조회<<");
		try {
			List<Customer> cAll = dao.selectAll();
			for (int i = 0; i < cAll.size(); i++) {
				Customer c = cAll.get(i);
				System.out.println(c.getId() + "," + c.getPwd() + ", " + c.getName());
			}
		} catch (FindException e) {
			System.out.println(e.getMessage());
		}
	}

	public void add() {
		System.out.println(">>2. 고객추가<<");
		System.out.print("아이디를 입력하세요:");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요:");
		String pwd = sc.nextLine();
		System.out.print("이름를 입력하세요:");
		String name = sc.nextLine();
		try {
			dao.insert(new Customer(id, pwd, name));
		} catch (AddException e) {
			System.out.println(e.getMessage());
		}
	}

	public void findById() {
		System.out.println(">>3. 고객 ID로 조회<<");
		System.out.print("아이디를 입력하세요:");
		String id = sc.nextLine();
		Customer c4;
		try {
			c4 = dao.selectById(id);
			System.out.println(c4.getId() + "," + c4.getPwd() + ", " + c4.getName());
		} catch (FindException e) {
			System.out.println(e.getMessage());
		}
	}

	public void modify(String id) {
		System.out.println(">>고객정보수정<<");

		try {
			dao.selectById(id);
			System.out.println("비밀번호를 입력하세요. 수정안하려면 enter를 누르세요.");
			String pwd = sc.nextLine();// enter를 누른경우 ""가 됨
			System.out.println("이름을 입력하세요. 수정안하려면 enter를 누르세요");
			String name = sc.nextLine();
			Customer c = new Customer(id, pwd, name);

			Customer c1 = dao.update(c);
			// try~catch
			System.out.println("수정 성공!" + c1.getId() + "," + c1.getPwd() + "," + c1.getName());

		} catch (FindException e) {
			System.out.println(e.getMessage());
		} catch (ModifyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void remove(String id) {
		System.out.println(">>고객정보삭제<<");

		try {
			dao.delete(id);
			System.out.println("삭제성공!");
		} catch (RemoveException e) {
			System.out.println(e.getMessage());

		}

	}

	public void login() {
		System.out.println(">>6.로그인<<");
		System.out.print("아이디를 입력하세요: ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요 : ");
		String pwd = sc.nextLine();

		Customer c;

		try {
			c = dao.selectById(id);

			if (c.getPwd().equals(pwd)) {
				System.out.println("로그인 성공");
				System.out.println("아이디 : " + c.getId() + "비밀번호 : " + c.getPwd() + "이름 : " + c.getName());
				System.out.println("실행할 작업을 선택하세요 : 1.수정 | 2.삭제 | 9.로그아웃 ");
				System.out.print("선택 > ");
				String num = sc.nextLine();

				if (num.equals("1")) {
					modify(id);
				} else if (num.equals("2")) {
					remove(id);
				} else if (num.equals("9")) {
					return;
				} else {
					System.out.println("잘못 입력하였습니다.");
				}

			} else {
				System.out.println("로그인 실패");
			}
		} catch (FindException e) {
			System.out.println("로그인 실패");
		}

	}

	static public void main(String[] args) {
		CustomerMain customerMain = new CustomerMain();
		while (true) {
			System.out.println("사용법: 1.고객전체조회, 2.고객추가, 3.고객 ID로 조회, 6.로그인  9.종료");
			System.out.print("작업을 선택하세요:");
			String menu = sc.nextLine();
			// System.out.println(menu);
			if ("1".equals(menu)) {
				customerMain.findAll();
			} else if ("2".equals(menu)) {
				customerMain.add();
			} else if ("3".equals(menu)) {
				customerMain.findById();
			} else if ("6".equals(menu)) {
				customerMain.login();
			} else if ("9".equals(menu)) {
				return;
			}
		}
	}
}
