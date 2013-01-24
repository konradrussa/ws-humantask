package wsht.runtime.utils;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import wsht.exception.WSHTException;

public class TaskMethodsUtils {

	
	public static XMLGregorianCalendar createXMlGregorianCalendar(Date date) throws WSHTException {
		if(date == null) return null;
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(date);
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			throw new WSHTException(e.getMessage());
		}


	}
}
