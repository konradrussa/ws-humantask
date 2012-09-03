package wsht.infrastructure.domain.enums;


public enum PotentialDelegateesEnum {

	
    ANYBODY("anybody"),
    NOBODY("nobody"),
    POTENTIAL_OWNERS("potentialOwners"),
    OTHER("other");
	
    private final String value;

    PotentialDelegateesEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PotentialDelegateesEnum fromValue(String v) {
        for (PotentialDelegateesEnum c: PotentialDelegateesEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
