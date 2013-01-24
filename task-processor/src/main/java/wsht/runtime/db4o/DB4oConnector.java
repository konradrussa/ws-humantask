package wsht.runtime.db4o;

import java.io.File;

import org.springframework.beans.factory.InitializingBean;

import wsht.runtime.exceptions.WSHTSystemStoreException;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class DB4oConnector implements IDB4oInterface, InitializingBean {

	private ObjectContainer db;
	private String filename;
	
	
	public void storeObject(Object obj) throws WSHTSystemStoreException {
		try {
			db.store(obj);
		} catch(Throwable e) {
			throw new WSHTSystemStoreException(e);
		}
	}
	
	public void deleteObject(Object obj) throws WSHTSystemStoreException {
		try {
			db.delete(obj);
		} catch(Throwable e) {
			throw new WSHTSystemStoreException(e);
		}
	}
	
	public Object qbe(Object obj) throws WSHTSystemStoreException {
		try {
			ObjectSet<?> ret =  db.queryByExample(obj);
			return ret;
		} catch(Throwable e) {
			throw new WSHTSystemStoreException(e);
		}
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void afterPropertiesSet() throws Exception {
		File dbFile = new File(filename);
		if(!dbFile.exists())
			dbFile.createNewFile();
		db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), filename);
	}
}
