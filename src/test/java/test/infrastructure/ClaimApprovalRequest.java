package test.infrastructure;

import java.util.Date;

public class ClaimApprovalRequest {
	public Integer amount = 2000;
	public String region = "regionalClerks";
	public Integer prio = 2;
	public Date activateAt = new Date();
	public Cust cust = new Cust();
}

class Cust {
	public String id = "idCust1";
	public String firstname = "John";
	public String lastname = "Rambo";
	
}