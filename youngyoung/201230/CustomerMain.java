package com.my.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.my.dao.CustomerDAO;
import com.my.dao.CustomerDAOList;
import com.my.exception.FindException;
import com.my.vo.Customer;

public class CustomerMain {
	private static CustomerDAO dao = new CustomerDAOList();
	static List<Customer> customers = new ArrayList<Customer>();
	private static void selectAll() {
		
		try {
			customers = dao.selectAll();
			for(int i=0; i<customers.size(); i++) {
				Customer c = customers.get(i);
				System.out.println(c.getId()+", "+c.getId()+", "+c.getPwd()+", "+c.getName());
			}
		} catch (FindException e) {
			// 찾지 못하였을경우 예외상황이 발생한다. 그상황을 여기서 찹아준다.
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void selectAll1() {
		String result = dao.selectAll1();
		System.out.println(result);
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		System.out.println("1. 전체조회 ( try~catch ) 2. 전체조회 (if)");
		int menu = sc.nextInt();
		
		if(menu== 1) {
			// 전체 조회
			selectAll();
		}else if(menu ==2) {
			// 고객 추가
			selectAll1();
		}else {
			// 나머지
		}
	}

	

	
}
