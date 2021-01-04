package exercise_0620;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	static int cnt = 0;

	public static void main(String[] args) {
		boolean run = true;

		while (run) {
			System.out.println("-----------------------------------");
			System.out.println("1.계좌생성 |2.계좌목록|3.예금|4.출금|5.종료");
			System.out.println("-----------------------------------");
			System.out.print("선택>");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				createAccount(null);
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");

	}

	// 계좌생성하기
	private static void createAccount(Account a) {
		System.out.println("---------");
		System.out.println("계좌생성");
		System.out.println("---------");
		System.out.print("계좌번호 :");
		String ano = scanner.next();
		System.out.print("계좌주 :");
		String owner = scanner.next();
		System.out.print("초기 입금액 :");
		int balance = scanner.nextInt();
		System.out.println("결과 : 계좌가 생성되었습니다.");
		
		a = new Account(ano,owner,balance);
		accountArray[cnt] = a;
		cnt++;
	}

	private static void accountList() {
		System.out.println("---------");
		System.out.println("계좌목록");
		System.out.println("---------");
		for (int i = 0; i < cnt; i++) {
			System.out.println(accountArray[i].getAno() + "   " + accountArray[i].getOwner() + "  "
					+ accountArray[i].getBalance());
		}
	}

	private static void deposit() {
		System.out.println("---------");
		System.out.println("예금");
		System.out.println("---------");
		System.out.print("계좌번호 :");
		String ano = scanner.next();
		System.out.print("입금액 : ");
		int deposit = scanner.nextInt();
		Account a = findAccount(ano);
		if(deposit>=0) {
		a.setBalance(a.getBalance()+deposit);
		System.out.println("예금액 :" + deposit);
		System.out.println("결과 : 예금이 성공되었습니다.");
		}else {
			System.out.println("결과 : 예금에 실패하였습니다.");
		}

	}



	private static void withdraw() {
		System.out.println("---------");
		System.out.println("출금");
		System.out.println("---------");
		System.out.print("계좌번호 :");
		String ano = scanner.next();
		System.out.print("출금액 : ");
		int withdraw = scanner.nextInt();
		Account a = findAccount(ano);
		if(a.getBalance() >= withdraw) {
		a.setBalance(a.getBalance()-withdraw);
				System.out.println("출금액 :" + withdraw);
				System.out.println("결과 : 출금이 성공되었습니다.");
		}else {
			System.out.println("결과 : 잔액이 모자랍니다.");
		}
			}
		


	private static Account findAccount (String ano) {
		for (int i = 0; i < cnt; i++) {
			if (ano.equals(accountArray[i].getAno())) {
				Account a = accountArray[i];
				return a;
			}else {
				System.out.println("입력한 계좌를 찾을 수 없습니다.");
			}
		}
		return null;

	}

}
