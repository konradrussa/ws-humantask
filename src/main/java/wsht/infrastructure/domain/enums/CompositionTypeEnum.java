package wsht.infrastructure.domain.enums;


public enum CompositionTypeEnum {

    SEQUENTIAL("sequential"),
    PARALLEL("parallel");
    
    private final String value;

    private CompositionTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CompositionTypeEnum fromValue(String v) {
        for (CompositionTypeEnum c: CompositionTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
