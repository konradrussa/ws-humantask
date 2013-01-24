package wsht.runtime.utils;

import org.apache.commons.lang.StringUtils;

public class TaskSemanticUtils {
	
	public static String getExpressionLanguage(String childObjectExprLang, String parentObjectExprLang) {
		return StringUtils.isBlank(childObjectExprLang) ? parentObjectExprLang : childObjectExprLang;
	}

}
