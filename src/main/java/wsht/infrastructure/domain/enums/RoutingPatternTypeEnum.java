package wsht.infrastructure.domain.enums;

public enum RoutingPatternTypeEnum {

	ALL("all"),
	SINGLE("single");
    
    private final String value;
    
    private RoutingPatternTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RoutingPatternTypeEnum fromValue(String v) {
        for (RoutingPatternTypeEnum c: RoutingPatternTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
