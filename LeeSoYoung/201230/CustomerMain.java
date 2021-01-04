import java.util.List;
import java.util.Scanner;

import com.my.dao.CustomerDAO;
import com.my.dao.CustomerDAOList;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.vo.Customer;

public class CustomerMain {
	private CustomerDAO dao = new CustomerDAOList();

	private static Scanner sc = new Scanner(System.in);

	public void findAll() {
		System.out.println(">>1.고객 전체 조회<<");
		List<Customer> cAll;
		try {
			cAll = dao.selectAll();
			for (int i = 0; i < cAll.size(); i++) {
				Customer c = cAll.get(i);
				System.out.println(c.getId() + ", " + c.getPwd() + ", " + c.getName());
			}
		} catch (FindException e) {

			System.out.println(e.getMessage());
		}

	}

	public void add() {
		System.out.println(">>2.고객추가<<");
		System.out.print("아이디를 입력하세요:");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요:");
		String pwd = sc.nextLine();
		System.out.print("이름을 입력하세요:");
		String name = sc.nextLine();

		try {
			dao.insert(new Customer(id, pwd, name));

		} catch (AddException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public void findById() {
		System.out.println(">>3.고객 ID로 조회<<");
		System.out.print("조회할 아이디를 입력하세요:");
		String id = sc.nextLine();

		Customer c;
		try {
			c = dao.selectById(id);
			System.out.println(c.getId() + ", " + c.getPwd() + ", " + c.getName());

		} catch (FindException e) {
			System.out.println(e.getMessage());
		}

	}

	public void update() {
		System.out.println(">>4.고객 수정<<");
		System.out.print("수정할 아이디를 입력하세요:");
		String id = sc.nextLine();
		String pwd = sc.nextLine();
		String name = sc.nextLine();
		// cu = new Customer(id, pwd, name);
		Customer c;
		Customer cu = new Customer(id,pwd,name);
		try {
			c = dao.selectById(id);
			dao.update(c, cu);
			System.out.println("수정할 id:" + c.getId() + ", " + c.getPwd() + ", " + c.getName());
			System.out.println("수정 성공");
		} catch (FindException e) {
			e.printStackTrace();
			System.out.println("수정 실패");
		}

	}

	public void delete() {
		System.out.println(">>5.고객 삭제<<");
		System.out.print("삭제할 아이디를 입력하세요:");
		String id = sc.nextLine();

		Customer c;
		try {
			c = dao.selectById(id);
			dao.delete(c);

			System.out.println("삭제된 id:" + id);
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		CustomerMain cm = new CustomerMain();

		while (true) {
			System.out.println("사용법: 1.고객 전체 조회, 2.고객추가, 3.고객 ID로 조회, 4.고객 수정 , 5.고객 삭제, 9.종료");
			System.out.print("작업을 선택하세요:");
			String menu = sc.nextLine();
			if ("1".equals(menu)) {
				cm.findAll();
			} else if ("2".equals(menu)) {
				cm.add();
			} else if ("3".equals(menu)) {
				cm.findById();
			} else if ("4".equals(menu)) {
				cm.update();
			} else if ("5".equals(menu)) {
				cm.delete();
			} else if ("9".equals(menu)) {
				return;
			} else {
				System.out.println("잘못된 값을 입력하셨습니다.");
			}
		}
	}
}
