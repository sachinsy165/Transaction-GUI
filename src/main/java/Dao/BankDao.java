package Dao;

 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Dto.Bankaccount;

public class BankDao 
{
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void save(Bankaccount bankaccount) 
	{
		entityTransaction.begin();
		entityManager.persist(bankaccount);
		entityTransaction.commit();
	}

	public List<Bankaccount> fetch_All_Bank_Details() 
	{
		List<Bankaccount>	list =entityManager.createQuery("select x from Bankaccount x").getResultList();
		
		return list;
	 
	}
	
	public Bankaccount fetch_by_accno(long acno) 
	{
		Bankaccount bankaccount      =entityManager.find(Bankaccount.class, acno) ;
		
		return bankaccount;
	}
	
	public void update(Bankaccount bankaccount) 
	{
		 entityTransaction.begin();
		 entityManager.merge(bankaccount);
		 entityTransaction.commit();
	}
}

