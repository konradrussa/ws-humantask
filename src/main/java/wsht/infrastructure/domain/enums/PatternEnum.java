package wsht.infrastructure.domain.enums;

public enum PatternEnum {

	MANUAL("manual"),
	AUTOMATIC("automatic");
    
    private final String value;
    
    private PatternEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PatternEnum fromValue(String v) {
        for (PatternEnum c: PatternEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
