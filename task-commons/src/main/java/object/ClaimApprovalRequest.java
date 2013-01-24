package object;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "claimApprovalRequest", propOrder = {
    "person",
    "region",
    "prio",
    "activateAt",
    "amount"
})
@XmlRootElement
public class ClaimApprovalRequest  {
	
	public ClaimApprovalRequest(){}

	@XmlElement(required = true)
	public Customer person;
	@XmlElement(required = true)
	public String region;
	@XmlElement(required = true)
	public Integer prio;
	@XmlElement(required = true)
	public Date activateAt = new Date();
	@XmlElement(required = true)
	public Integer amount;
	

	public void setPerson(Customer person) {
		this.person = person;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setPrio(Integer prio) {
		this.prio = prio;
	}

	public void setActivateAt(Date activateAt) {
		this.activateAt = activateAt;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	

	public Customer getPerson() {
		return person;
	}

	public String getRegion() {
		return region;
	}

	public Integer getPrio() {
		return prio;
	}

	public Date getActivateAt() {
		return activateAt;
	}

	public Integer getAmount() {
		return amount;
	}
	
	
	
	
	
}
