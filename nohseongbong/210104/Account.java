package Review1;

public class Account {// 고객정보 저장소
	private String ano; // 계좌 번호
	private String owner; // 계좌주 
	private long balance; // 초기입금액
	
	
	public Account(String ano,String owner,long balance) {
		this.ano =ano;
		this.owner =owner;
		this.balance =balance;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	
	
}
