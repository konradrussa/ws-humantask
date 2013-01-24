package object;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customer", propOrder = {
    "id",
    "type",
    "name",
    "location",
    "firstname",
    "lastname"
})
public class Customer implements Serializable {
	
	public Customer(){}
	
	@XmlElement(required = true)
	public String id;
	@XmlElement(required = true)
	public String type;
	@XmlElement(required = true)
	public String name;
	@XmlElement(required = false)
	public Location location;
	@XmlElement(required = true)
	public String firstname;
	@XmlElement(required = true)
	public String lastname;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	
}
