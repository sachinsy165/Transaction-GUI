package Dto;

 

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Bankaccount 
{
    @Id
    
    @SequenceGenerator(initialValue = 45678432,allocationSize = 1,sequenceName ="accno",name = "accno" )
    @GeneratedValue(generator = "accno")
	long acc_no;
    
    String account_type;
    
    double amount;
    
    double acc_limit;
    
    boolean status;
    
   @ManyToOne
   
   Customer customer;

   @OneToMany (cascade = CascadeType.ALL) //directly we can save the data without et.begin() ,em.persist(); et.commit().
   List<BankTransaction>bankTransactions;

public long getAcc_no() {
	return acc_no;
}

public void setAcc_no(long acc_no) {
	this.acc_no = acc_no;
}

public String getAccount_type() {
	return account_type;
}

public void setAccount_type(String account_type) {
	this.account_type = account_type;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public double getAcc_limit() {
	return acc_limit;
}

public void setAcc_limit(double acc_limit) {
	this.acc_limit = acc_limit;
}

public boolean isStatus() {
	return status;
}

public void setStatus(boolean status) {
	this.status = status;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public List<BankTransaction> getBankTransactions() {
	return bankTransactions;
}

public void setBankTransactions(List<BankTransaction> bankTransactions) {
	this.bankTransactions = bankTransactions;
}

 
   
}

