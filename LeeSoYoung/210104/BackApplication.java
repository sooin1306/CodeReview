package codeReview200104;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BackApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	static int index = 0;

	public static void main(String[] args) {

		boolean run = true;
		while (run) {
			System.out.println("----------------------------------------");
			System.out.println("1.계좌생성  | 2.계좌목록 | 3.예금 | 4.출금  | 5.종료");
			System.out.println("-----------------------------------------");
			System.out.println("선택 >");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				createAccount();
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

	// 계좌생성
	private static void createAccount() {
		// try catch하기

		System.out.print(" 계좌번호  : ");
		String stringNumber = scanner.next();
		System.out.print(" 계좌주 : ");
		String stringName = scanner.next();
		System.out.print(" 초기입금액 : ");
		int selectNo = scanner.nextInt();

		try {
			accountArray[index] = new Account(stringNumber, stringName, selectNo);
			index++;
		} catch (InputMismatchException e) {
		}
		System.out.println("결과 : 계좌가 생성되었습니다.");
	}

	// 계좌목록보기
	private static void accountList() {
		try {
			for (int i = 0; i < accountArray.length; i++) {
				Account a = accountArray[i];
				System.out.println(a.getAno() + ", " + a.getOwner() + ", " + a.getBalance());
			}
		} catch (NullPointerException e) {

		}
	}

	// 예금하기
	private static void deposit() {
		// try {
		// Account ac = new Account();
		// amount = ac.getBalance();
		//
		// System.out.print(" 계좌번호를 입력하여 주십시오 ");
		// String stringNumber = scanner.next();
		//
		// System.out.print(" 입금액을 입력하여 주십시오 ");
		// int selectNo = scanner.nextInt();
		//
		// System.out.println("계좌번호 : "+ac.getAno() + ", " +"예금액 : "+
		// ac.getBalance());
		//
		// for (int i = 0; i < accountArray.length; i++) {
		// String ano1 = accountArray[i].getAno();
		// if (ac.getAno().equals(ano1)) {
		// amount += selectNo;
		//
		// }
		//
		// }
		//
		// } catch (NullPointerException e) {
		// }
		try {
			System.out.print(" 계좌번호를 입력하여 주십시오 ");
			String stringNumber = scanner.next();

			if (stringNumber == null || "".equals(stringNumber)) {
				System.out.print("정상적인 계좌번호를 입력해주세요.");
				return;
			}

			Account ac = findAccount(stringNumber);

			if (ac == null) {
				System.out.println("계좌번호가 없습니다.");
				return;
			}

			System.out.print(" 입금액을 입력하여 주십시오 ");
			int money = scanner.nextInt();

			ac.setBalance(ac.getBalance() + money);

			System.out.println("계좌번호 : " + ac.getAno() + ", " + "예금액 : " + ac.getBalance());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 출금하기
	private static void withdraw() {

		try {
			System.out.print(" 계좌번호를 입력하여 주십시오 ");
			String stringNumber = scanner.next();

			if (stringNumber == null || "".equals(stringNumber)) {
				System.out.print("정상적인 계좌번호를 입력해주세요.");
				return;
			}
			Account ac = findAccount(stringNumber);

			if (ac == null) {
				System.out.println("계좌번호가 없습니다.");
				return;
			}

			System.out.print(" 출금액을 입력하여 주십시오 ");
			int money = scanner.nextInt();
			if ((ac.getBalance() - money) < 0) {
				System.out.println("잔액이 부족합니다.");
				System.out.println("현재금액 : " + ac.getBalance() + " / 출금 요청금액 : " + money);
				return;

			}
			ac.setBalance(ac.getBalance() - money);

			System.out.println("계좌번호 : " + ac.getAno() + ", " + "예금액 : " + ac.getBalance());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Account 배열에서 ano와 동등한 Account객체찾기
	private static Account findAccount(String ano) {
		try {
			if (ano == null || "".equals(ano)) {
				System.out.println("계좌번호를 입력해주세요");
				return null;
			}
			for (int i = 0; i < accountArray.length; i++) {
				String ano1 = accountArray[i].getAno();
				if (ano.equals(ano1)) {
					return accountArray[i];
				}
			}

		} catch (java.util.InputMismatchException e) {

		}
		return null;
	}
}
