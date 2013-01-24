package wsht.runtime.db4o;

import com.db4o.ObjectSet;

import wsht.runtime.exceptions.WSHTSystemStoreException;

public interface IDB4oInterface {
	public void storeObject(Object obj) throws WSHTSystemStoreException;
	public void deleteObject(Object obj) throws WSHTSystemStoreException;
	public Object qbe(Object obj) throws WSHTSystemStoreException;
}
