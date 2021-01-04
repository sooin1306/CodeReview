package bank;

import java.util.Scanner;

public class AccountExample {
	public static void main(String[] args) {
		
		// account 기본생성자를 이용해서 객체를 생성한다.
		Account account = new Account();
		
		// 반복문을 이용해서 메뉴를 계속선택 가능하도록 만들었습니다.
		while(true) {
			System.out.println("---------------------------");
			System.out.println("1.입금    2.출금    3.잔고확인    4.종료");
			System.out.println("---------------------------");
			int result;
			
			Scanner sc = new Scanner(System.in);
			System.out.print("메뉴를 입력하세요 > ");
			// 사용자의 메뉴를 입력받습니다.
			String num = sc.nextLine();
			
			// 1.입금을 선택
			if(num.equals("1")) {
				System.out.print("입금할 금액을 입력해주세요.>");
				int money = sc.nextInt();
				
				// 잔액에다가 더하기 위해서 getter를 이용해서 불러온후 입금할 금액을 더합니다.
				money += account.getMoney();
				account.setMoney(money);
				System.out.println("현재 잔액은 :"+money);
				
			// 2.출금을 선택
			}else if(num.equals("2")) {
				int balance=account.getMoney();
				System.out.println("잔책은 : "+ balance);
				System.out.print("출금할 금액을 입력해주세요.>");
				int money = sc.nextInt();
				if(balance < money) {
					System.out.println("통장잔고보다 출금하려는 잔액이 많아 출금이 불가합니다.");
				}else {
					
					// 잔액을 getter를 이용해서 불러온 이후에 출금할 금액을 빼줍니다.
					money -= account.getMoney();
					account.setMoney(money);
					System.out.println("현재 잔액은" + money);
				}
				
			// 3.잔액을 선택
			}else if(num.equals("3")) {
				int money = account.getMoney();
				System.out.println("잔액 : "+money);
			}
			
			// 4. 종료를 선택
			else if(num.equals("4")) {
				System.out.println("시스템을 종료합니다.");
				break;
			}
		}
		
		
		
		
		
	}

	
}
