
import java.util.ArrayList;
import java.util.List;

import com.my.dao.CustomerDAO;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.vo.Customer;

public class CustomerDAOList implements CustomerDAO {
	private List<Customer> customers; //고객저장소
	public CustomerDAOList() {
		customers = new ArrayList<Customer>(); //
	}
	public CustomerDAOList(int size) {
		customers = new ArrayList<Customer>(size);
	}
	
	@Override
	public void insert(Customer c) throws AddException {
		try {
			selectById(c.getId());
			throw new AddException("이미 존재하는 아이디입니다");
		} catch (FindException e) {
			//저장소에 추가하기
			customers.add(c);			
		}
	}

	@Override
	public List<Customer> selectAll() throws FindException {
		if(customers.size() == 0) {
			throw new FindException("고객이 한명도 없습니다");
		}
		return customers;		
	}
	@Override
	public Customer selectById(String id) throws FindException {
		for(int i=0; i<customers.size(); i++) {
			Customer c = customers.get(i);
			if(c.getId().equals(id)) {
				return c;
			}
		}
		throw new FindException("아이디에 해당하는 고객이 없습니다");
	}

	@Override
	public void update(Customer c,Customer cu) {
		c.setName(cu.getName());
		c.setPwd(cu.getPwd());
		  
	}

	@Override
	public void delete(Customer c) {
		customers.remove(c);
		
	}

}