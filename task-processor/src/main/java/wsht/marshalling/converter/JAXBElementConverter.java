package wsht.marshalling.converter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.xml.bind.JAXBElement;
import org.dozer.*;
import org.dozer.util.*;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TGenericHumanRoleAssignment;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.TPotentialOwnerAssignment;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TOrganizationalEntity;

import wsht.infrastructure.domain.entity.GenericHumanRoleAssignment;
import wsht.infrastructure.domain.entity.OrganizationalEntity;
import wsht.infrastructure.domain.entity.PotentialOwnerAssignment;

public class JAXBElementConverter implements ConfigurableCustomConverter,
		MapperAware {
	private String creationMethodName;
	private Class<?> innerClass;
	private Mapper mapper;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object convert(Object existingDestinationFieldValue,
			final Object sourceFieldValue, final Class<?> destinationClass,
			final Class<?> sourceClass) {
		if (sourceFieldValue == null) {
			return null;
		}
		if (sourceFieldValue instanceof JAXBElement
				&& destinationClass == JAXBElement.class) {
			System.out.println("_^_^_^_" + "sourceFieldValue instanceof JAXBElement && destinationClass == JAXBElement.class" + "_^_^_^_");
		}
		if (sourceFieldValue instanceof JAXBElement
				&& destinationClass != JAXBElement.class) {
			return mapper.map(((JAXBElement) sourceFieldValue).getValue(),
					destinationClass);
		}
		if(sourceClass == ArrayList.class) {
			List list = (List) sourceFieldValue;
			
			for(Object o : list) {
				if(o instanceof JAXBElement) {
					if(((JAXBElement) o).getValue() instanceof TGenericHumanRoleAssignment) {
						if(existingDestinationFieldValue == null) {
							existingDestinationFieldValue = new ArrayList();
						}
						GenericHumanRoleAssignment r = mapper.map(((JAXBElement) o).getValue(), GenericHumanRoleAssignment.class);
						r.setName(((JAXBElement) o).getName().getLocalPart());
						((ArrayList) existingDestinationFieldValue).add(r);
					} 
					if(((JAXBElement) o).getValue() instanceof TPotentialOwnerAssignment) {
						if(existingDestinationFieldValue == null) {
							existingDestinationFieldValue = new ArrayList();
						}
						PotentialOwnerAssignment po = mapper.map(((JAXBElement) o).getValue(), PotentialOwnerAssignment.class);
						po.setName(((JAXBElement) o).getName().getLocalPart());
						((ArrayList) existingDestinationFieldValue).add(po);
					}
					
				}
			}
			return existingDestinationFieldValue;
		}
		
		if(sourceFieldValue instanceof TOrganizationalEntity) {
			existingDestinationFieldValue = new OrganizationalEntity();
			((OrganizationalEntity)existingDestinationFieldValue).setGroupOrg(new HashSet<String>());
			((OrganizationalEntity)existingDestinationFieldValue).setUserOrg(new HashSet<String>());
			TOrganizationalEntity oe = (TOrganizationalEntity) sourceFieldValue;
			for(JAXBElement<String> e : oe.getUserOrGroup()) {
				if(e.getName().toString().equals("{http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803}user")) {
					((OrganizationalEntity)existingDestinationFieldValue).getUserOrg().add(e.getValue());
				} else {
					((OrganizationalEntity)existingDestinationFieldValue).getGroupOrg().add(e.getValue());
				}
			}
			return existingDestinationFieldValue;
		} 
		
		if (sourceClass != JAXBElement.class
				&& destinationClass == JAXBElement.class) {
			String innerClassName = innerClass.getCanonicalName();
			String packageName = innerClassName.substring(0,
					innerClassName.lastIndexOf(".") + 1);
			Class<?> objectFactory = MappingUtils.loadClass(packageName
					+ "ObjectFactory");
			Object factory = ReflectionUtils.newInstance(objectFactory);
			Method method = null;
			try {
				method = ReflectionUtils.getMethod(objectFactory,
						creationMethodName, new Class[] { innerClass });
			} catch (NoSuchMethodException e) {
				MappingUtils.throwMappingException(e);
			}
			JAXBElement returnObject = (JAXBElement) ReflectionUtils.invoke(
					method, factory, new Object[] { null });
			returnObject.setValue(mapper.map(sourceFieldValue, innerClass));
			return returnObject;
		}
		
		throw new IllegalArgumentException("Not supported mapping");
	}

	public void setParameter(final String parameter) {
		/*if (parameter == null) {
			throw new IllegalArgumentException("'parameter' can't be null");
		}
		int delimiterIndex = parameter.lastIndexOf("#");
		if (delimiterIndex == -1) {
			throw new IllegalArgumentException("Uncorrect parameter format");
		}
		String className = parameter.substring(0, delimiterIndex);
		try {
			this.innerClass = Class.forName(className);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Class " + className
					+ " not found", e);
		}
		this.creationMethodName = parameter.substring(delimiterIndex + 1);*/
	}

	public void setMapper(final Mapper mapper) {
		this.mapper = mapper;
	}
}