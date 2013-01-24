package wsht.runtime.enums;

public enum ExpressionLanguageEnum {

	    SBQL("sbql"),
	    XPATH("xpath");
	  
	    private final String value;

	    ExpressionLanguageEnum(String v) {
	        value = v;
	    }

	    public String value() {
	        return value;
	    }

	    public static ExpressionLanguageEnum fromValue(String v) {
	        for (ExpressionLanguageEnum c: ExpressionLanguageEnum.values()) {
	            if (c.value.equals(v)) {
	                return c;
	            }
	        }
	        throw new IllegalArgumentException(v);
	    }
}
