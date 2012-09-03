package wsht.infrastructure.domain.enums;


public enum BooleanEnum {

    YES("yes"),
    NO("no");
    
    private final String value;
    
    private BooleanEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BooleanEnum fromValue(String v) {
        for (BooleanEnum c: BooleanEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
