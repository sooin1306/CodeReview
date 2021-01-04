package bankApplication;

import java.util.Scanner;

public class BankApplication {
    private static Account[] accountArry = new Account[100];
    private static Scanner scanner = new Scanner(System.in);


    public static void main (String[] args){
        boolean run = true;

        while(run){
            System.out.println("-------------------------------------");
            System.out.println("1.계좌생성, 2.계좌목록, 3.예금, 4.출금, 5.종료");
            System.out.println("-------------------------------------");
            System.out.println("선택> ");

            int selectNo = scanner.nextInt();{

            }
            //계좌 생성
            if(selectNo ==1){
                creatAccount();
            }
            // 계좌 목록
            else if(selectNo == 2){
                accountList();
            }
            // 예금
            else if(selectNo ==3){
                deposit();
            }
            // 출금
            else if(selectNo == 4){
                withdraw();
            }
            // 종료
            else if(selectNo ==5 ){
                run = false;
            // 1~5에 해당되지 않은 숫자들에 대한 예외 처리
            }else {
            	System.out.println("1~5숫자 이외에 다른것을 입력하지 말아주세요.");
            }
        }
        System.out.println("시스템이 종료되었습니다.");



        }



    //계좌 생성 메소들
    private static void creatAccount() {
        String ano ;
        String owner;
        int balance;
        System.out.println("----------------");
        System.out.println("계좌생성");
        System.out.println("----------------");
        System.out.print("계좌번호 : ");
        ano = scanner.next();
        System.out.println("계좌주 : ");
        owner = scanner.next();
        System.out.println("초기입금 잔액 : ");
        balance = scanner.nextInt();

        Account account = new Account(ano, owner, balance);
        for(int i=0; i<accountArry.length; i++){
            if(accountArry[i] == null) {
                accountArry[i] = account;
                System.out.println("계좌가 정상적으로 생성되었습니다.");
                break;
            }
        }
    }

    // 계좌 목록
    private static void accountList() {
        System.out.println("----------------");
        System.out.println("계좌목록");
        System.out.println("----------------");
        
        // 반복문을 통해서 모든 계좌를 출력해준다.
        for(int i = 0; i<accountArry.length; i++){
        	if(accountArry[i] != null) {
        		System.out.println(accountArry[i].getAno()+ "    "+accountArry[i].getOwner() +"    "+accountArry[i].getBalance());
        	 }else {
        		 break;
        	 }
        }

    }

    // 예금
    private static void deposit() {
        System.out.println("----------------");
        System.out.println("예금");
        System.out.println("----------------");
        System.out.print("계좌번호");
        String ano = scanner.next();
        
        Account account = findAccount(ano);
        // account null이 아니면 account객체를 활용한다.
        if(account!=null) {
        	 System.out.println("계좌번호 : " + account.getAno());
             System.out.print("예금액 : ");
             int num = scanner.nextInt();
             int balance = account.getBalance();
             account.setBalance(num+balance);
             System.out.print("결과 : 예금이 성공되었습니다.");
        }else {
        	System.out.println("존재하지 않은 계좌입니다.");
        }
       


    }

    // 출금
    private static void withdraw() {
        System.out.println("----------------");
        System.out.println("출금");
        System.out.println("----------------");
       
        System.out.print("계좌번호");
        String ano = scanner.next();
        Account account = findAccount(ano);
        // findAccount에서 null를 반환하였을 경우에 대한 예외 처리
        if(account !=null) {
        	// 해당하는 객체를 가져와서 활용한다.
        	System.out.println("현재 잔액 : ");
            int balance = account.getBalance();
            System.out.print(balance);
            
            System.out.print("출금액");
            int money = scanner.nextInt();
            
            account.setBalance(balance-money); 
            System.out.print("결과 : 출금이 성공되었습니다.");
        }else {
        	System.out.println("존재하지 않는 계좌입니다.");
        }
        
    }

    // 계좌번호 없을때 예외 처리는 값을 넘겨주었을때 null값을 넘겨주었을때 조건문 처리하였다.
    private static Account findAccount (String ano){
    	Account account = null;
        for(int i = 0; i<accountArry.length; i++){
            if(accountArry[i] !=null){
                if(accountArry[i].getAno().equals(ano)){
                     account = accountArry[i];
                    break;
                	
                }
            }
        }
        return account;
    }

}
