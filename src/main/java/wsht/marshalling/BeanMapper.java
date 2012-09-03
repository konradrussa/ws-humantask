package wsht.marshalling;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import org.dozer.Mapper;

public class BeanMapper implements IBeanMapper, IWSHTMarshallingService {
	
	private Mapper mapper;
	
	
	public <G,T> T map(G serialize, Class<T> unserialize) {
		T retObject = null;
		retObject = (T) mapper.map(serialize, unserialize);
		return retObject;
	}
	
	public <G,T> List<T> mapList(List<G> serializeList,Class<T> unserialize) {
		List<T> unserializeList = new ArrayList<T>();
		if(serializeList!=null){
			Iterator<G> it = serializeList.iterator();
			while(it.hasNext()){
				unserializeList.add(map(it.next(), unserialize));
			}
		}
		return unserializeList;
	}
	
	@Override
	public <T> String marshall(T object, Class<T> clazz) {
		java.io.StringWriter sw = new StringWriter();
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(object, sw);
		} catch (PropertyException e) {
			throw new IllegalStateException(e.getMessage()); //TODO
		} catch (JAXBException e) {
			throw new IllegalStateException(e.getMessage()); //TODO
		}
		
		return sw.toString();
	}
	
	
	/**
	 * Gettery i Settery
	 */
	public Mapper getMapper() {
		return mapper;
	}

	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

	
}