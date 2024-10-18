package Dao;

 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dto.Customer;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void save(Customer customer) 
	{
    entityTransaction.begin();
    entityManager.persist(customer);
    entityTransaction.commit();
	}

	public List<Customer> fetch(long mobile) 
	{
   /*Customer customer  = entityManager.find(Customer.class, mobile);
		
		return customer;*/
		
		List<Customer> list  = entityManager.createQuery("select x from Customer x where mob=?1").setParameter(1, mobile).getResultList();
		return list;
	}

	public List<Customer> fetch(String email) 
	{
		/*Customer customer  = entityManager.find(Customer.class, email);
		
		return customer;*/
		
		 List<Customer> list  = entityManager.createQuery("select x from Customer x where email=?1").setParameter(1, email).getResultList();
			return list;
	}
 
 public  Customer	fetchByCustId( long custid)
 {
	Customer customer    =entityManager.find(Customer.class,custid);
    return customer;
 }

 public void update(Customer customer) 
 {
	entityTransaction.begin();
	entityManager.merge(customer);
	entityTransaction.commit();
}
	

}

