package wsht.infrastructure.domain.enums;

public enum ReturnAttachmentsEnum {

	ALL("all"),
	NEW_ONLY("newOnly"),
	NONE("none");
    
    private final String value;

    private ReturnAttachmentsEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReturnAttachmentsEnum fromValue(String v) {
        for (ReturnAttachmentsEnum c: ReturnAttachmentsEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
