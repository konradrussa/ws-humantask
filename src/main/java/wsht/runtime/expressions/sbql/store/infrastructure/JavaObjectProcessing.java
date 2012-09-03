package wsht.runtime.expressions.sbql.store.infrastructure;

import wsht.runtime.expressions.sbql.store.SBAStore;



public class JavaObjectProcessing {
	
	public void loadContainer(SBAStore sbaStore, Object obj) {
		new ASMVisitorWithSBAProcessing(sbaStore, obj).process();
	}
	
}
