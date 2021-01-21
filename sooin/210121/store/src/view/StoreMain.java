package view;

import java.util.Scanner;

import controller.StoreController;

public class StoreMain {

	static StoreController controller = new StoreController();

	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);

			System.out.println("1. 로그인   2. 회원가입");

			System.out.print("선택 >");
			int num = sc.nextInt();
			int option;
			if (num == 1) {
				boolean result = false;
				while (!result) {
					System.out.print("1.회원  2. 메니저");
					option = sc.nextInt();
					System.out.println("로그인을 위해 아이디와 비밀번호를 입력해주세요");
					System.out.print("아이디 : ");
					String id = sc.next();
					System.out.print("비밀번호 : ");
					String pwd = sc.next();
					result = controller.login(id, pwd, option);

					if (result) {
						System.out.println("로그인 성공되었습니다.");
						
						if (option == 1) {// 로그인 한 유저만 사용 가능합니다.

							boolean run = true;
							while (run) {
								System.out.println("1.물건 결제하기  2.충전  3.나가기");
								System.out.print("선택  > ");
								int num2 = sc.nextInt();
								if (num2 == 1) {
									System.out.println("물건 결제하기");
									System.out.print("제품이름을 입력하세요");
									String productName = sc.next();
									String str = controller.pay(id,option, productName);
									System.out.println(str);

								} else if (num2 == 2) {
									System.out.println("충전");
									System.out.print("충전하실 금액을 입력하세요");
									int balance = sc.nextInt();
									String str = controller.charge(id,option, balance);
									System.out.println(str);
								} else if(num2 == 3) {
									run = false;
								}
							}

						} else if (option == 2) {// manager만 가능한 조작입니다.
							boolean run = true;
							while(run) {
								System.out.println(" 1. 판매 물품 등록하기  2. 판매 물품 리스트보기 3.나가기");
								System.out.print("선택 >");
								int num3 = sc.nextInt();
								if (num3 == 1) {
									System.out.println("판매물품 등록");
									System.out.print("등록할 물품의 이름을 입력하세요");
									String productName = sc.next();
									System.out.print("등록할 물품의 가격을 입력하세요");
									int productPrice = sc.nextInt();
									String str = controller.addProduct(productName, productPrice);
									System.out.println(str);
								} else if (num3 == 2) {
									System.out.println("판매 물품 리스트");
									String StuffList = controller.productList();
									System.out.println(StuffList);
								}else if(num3 == 3) {
									System.out.println("나가기");
									run = false;
								}
							}

							
						}
					}

				}

			} else if (num == 2) {
				String str;
				while (true) {
					System.out.println("회원가입");
					System.out.println("가입 유형 선택");
					System.out.println("1. 회원   2. 메니저");
					System.out.print("선택 >");
					option = sc.nextInt();
					System.out.println("아이디 : ");
					String id = sc.next();
					System.out.println("비밀번호 : ");
					String pwd = sc.next();
					int balance = 0;
					str = controller.signUp(id, pwd, option, balance);
					System.out.println(str);
					break;
				}

			}
		}
	}
}
