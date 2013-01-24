package wsht.infrastructure.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import wsht.exception.WSHTException;

public class ReflectionUtils {
	
	public static Method getAnnotatedMethod(final Class clazz, final Class annotation) {
        Method[] methods = clazz.getDeclaredMethods();

        for(Method method : methods) {
            if(method.getAnnotation(annotation) != null) {
                return method;
            }
        }
        return null;
    }
	
	public static Class[] getGenericTypes(final Class type) {
		Type superclass = type.getGenericSuperclass();
		if (superclass instanceof ParameterizedType) {
			ParameterizedType genericTypeClass = (ParameterizedType) superclass;
			return cast(genericTypeClass.getActualTypeArguments());
		}
		return new Class[0];
	}

	// Rzutowanie w dół z Type do Class.
	public static Class[] cast(final Type[] types) {
		Class[] classTypes = new Class[types.length];
		for (int i = 0, j = types.length; i < j; i++) {
			classTypes[i] = (Class) types[i];
		}
		return classTypes;
	}
	
	public static Object invokeMethod(final Object o, final Method m, final Object...params) throws WSHTException {
		String msg;
		try {
			System.out.println(m.getName() + " " + m.isAccessible());
			m.setAccessible(true);
			
			return m.invoke(o, params);
		} catch (IllegalArgumentException e) {
			msg = e.getMessage();
		} catch (IllegalAccessException e) {
			msg = e.getMessage();
		} catch (InvocationTargetException e) {
			msg = e.getMessage();
		}
		
		throw new WSHTException(msg);		
	}
	
	public static boolean checkIfComplexObject(final Object o) {
		if(o == null) return false;
		return checkIfComplexClass(o.getClass());
	}
	
	public static boolean checkIfComplexClass(final Class c) {

		if(c == String.class 
			|| c == Integer.class
			|| c == Double.class
			|| c == Boolean.class
			|| c == Long.class
			|| c == Date.class
			|| c == Float.class) { 
			return false;
		}
		return true;
	}
	
	public static boolean checkIfListSignature(final String signature) {
		return signature.contains("Ljava/util/List");
	}
	
	public static boolean checkIfSetSignature(final String signature) {
		return signature.contains("Ljava/util/Set");
	}
	
	public static boolean checkIfMapSignature(final String signature) {
		return signature.contains("Ljava/util/Map");
	}
	

}
