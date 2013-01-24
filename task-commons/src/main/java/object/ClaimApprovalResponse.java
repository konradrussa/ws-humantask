package object;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "claimApprovalResponse", propOrder = {
    "account",
    "approved",
    "amount"
})
@XmlRootElement
public class ClaimApprovalResponse {
	
	public ClaimApprovalResponse() {}
	
	@XmlElement(required = true)
	public Boolean approved;
	@XmlElement(required = false)
	public Customer account;
	@XmlElement(required = false)
	public Integer amount;

	public Boolean getApproved() {
		return approved;
	}
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	public Customer getAccount() {
		return account;
	}
	public void setAccount(Customer account) {
		this.account = account;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
}
