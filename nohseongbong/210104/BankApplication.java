package Review1;
import java.util.InputMismatchException;
import java.util.Scanner;


public class BankApplication {
	private static Account[] accountArray = new Account[100]; //100개의 공간을 가진 저장소
	private static Scanner sc = new Scanner(System.in);
	
	private static int e = 0;

	
	public static void main(String[] args){
		boolean run = true;
		
		while (run) {

			
			

			try {
				System.out.println("----------------------------------------------------");
				System.out.println(" 1. 계좌생성  ㅣ   2.계좌목록   ㅣ   3. 예금   ㅣ   4. 출금   ㅣ  5. 종료"  );
				System.out.println("----------------------------------------------------");
				System.out.print("선택 > ");
				long selectNo = sc.nextLong();
				
				if(selectNo == 1) {
					createAccount();
				}else if(selectNo == 2) {
					accountList();
				}else if(selectNo == 3) {
					deposit();
				}else if(selectNo == 4) {
					sithdraw();
				}else if(selectNo == 5) {
					run=false;
				}else {
					System.out.println("틀렸어요 >_<♡ 다시 입력해주세요!");
				}

			}catch(InputMismatchException ime) {
				sc = new Scanner(System.in);
				System.out.println("숫자만 입력하세요.");
			}
						
		}
		System.out.println("프로그램 종료");
	}
	
	
	

	private static void createAccount() {
		
		System.out.println("--------------");
		System.out.println("    계좌 생성");
		System.out.println("--------------");

		System.out.print("계좌번호: ");
		String ano = sc.next();

		try {
			Account fi = findAccount(ano);

			if(null!=fi) {
				System.out.println("이미 등록된 계좌번호입니다.");
			}
		  
			}catch(NullPointerException n) {
				System.out.print("계좌주: ");
				String owner = sc.next();
				System.out.print("초기입금액: ");
				long balance = sc.nextLong();
				if(balance >= 0) {
					Account c = new Account(ano,owner,balance);
				    accountArray[e] = c;
				      
				    System.out.println("결과: 계좌가 생성되었습니다.");
					e++;
				}else {
					System.out.println("돈을 가져가지 마세요 ♡");
				}
					
				
			}
	      
   }
	
		
	private static void accountList() {
		System.out.println("--------------");
		System.out.println("    계좌 목록");
		System.out.println("--------------");
		try{
			for(int i = 0;i<accountArray.length;i++) {
				System.out.println(" 계좌번호 : " + accountArray[i].getAno() + "   계좌주 : " + accountArray[i].getOwner()+"   초기입금액 : " + accountArray[i].getBalance());
			}			
		}catch(Exception e){}
	}
		
	
	
	private static void deposit(){
		System.out.println("--------------");
		System.out.println("    예금");
		System.out.println("--------------");
		
		System.out.print("계좌번호: ");
		String ano = sc.next();
		
		
		try {
			Account fi = findAccount(ano);
			if(fi != null) {
				System.out.print("예금액: ");
				long balance = sc.nextLong();
				if(balance > 0) {
					balance += fi.getBalance();
					fi.setBalance(balance);
					
					System.out.println("예금이 성공되었습니다.");
					System.out.println("예금 후 잔액 : " + fi.getBalance());
				}else {
					System.out.println("돈을 넣으라고 이 자식아 ㅡㅡ");
				}
				
			}
		}catch(NullPointerException e) {
			System.out.println("해당하는 계좌번호가 없습니다");
		}
		
						
		

		
	}
	
	
	private static void sithdraw(){
		System.out.println("--------------");
		System.out.println("    출금");
		System.out.println("--------------");
		
		System.out.print("계좌번호: ");
		String ano = sc.next();
		


		
		try {
			Account fi = findAccount(ano);
			if(fi != null) {
				System.out.print("출금액: ");
				long balance = sc.nextLong();
				if(balance > 0) {
					long bs = fi.getBalance();
					
					if(bs >= balance) {
						bs -= balance;
						
						fi.setBalance(bs);
						System.out.println("출금이 성공되었습니다.");
						System.out.println("출금 후 잔액 : " + fi.getBalance());
					}else {
						System.out.println("돈 부족하다 이 자식아 ㅡ.ㅡ  ");
						System.out.println("현재 금액 : " + bs);
					}
					if(bs == 0) {
						System.out.println("돈 벌자...너 이제 거지다...");
					}
				}else {
					System.out.println("마이너스는 쓰지마라... 제발..");
				}
				
				
			}
		}catch(NullPointerException e) {
			System.out.println("해당하는 계좌번호가 없습니다");
		}
		
		
	
		
		
		 
	}
	

	
	private static Account findAccount(String ano){
			for(int i = 0; i<accountArray.length;i++) {
				String find = accountArray[i].getAno();
				if(ano.equals(find)) {		
					return accountArray[i];
				}
			}
		
		return null;
		
	}

}
