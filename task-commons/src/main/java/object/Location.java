package object;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "location", propOrder = {
    "locationId"
})
public class Location implements Serializable {
	
	public Location(){}
	
	@XmlElement(required = false)
	protected Integer locationId;


	public Integer getLocationId() {
		return locationId;
	}


	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
}