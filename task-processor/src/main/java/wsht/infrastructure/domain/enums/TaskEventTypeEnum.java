package wsht.infrastructure.domain.enums;


public enum TaskEventTypeEnum {
	   
	    CREATE("create"),
	    CLAIM("claim"),
	    START("start"),
	    STOP("stop"),
	    RELEASE("release"),
	    SUSPEND("suspend"),
	    SUSPEND_UNTIL("suspendUntil"),
	    RESUME("resume"),
	    COMPLETE("complete"),
	    REMOVE("remove"),
	    FAIL("fail"),
	    SET_PRIORITY("setPriority"),
	    ADD_ATTACHMENT("addAttachment"),
	    DELETEATTACHMENT("deleteAttachment"),
	    ADD_COMMENT("addComment"),
	    SKIP("skip"),
	    FORWARD("forward"),
	    DELEGATE("delegate"),
	    SET_OUTPUT("setOutput"),
	    DELETE_OUTPUT("deleteOutput"),
	    SET_FAULT("setFault"),
	    DELETE_FAULT("deleteFault"),
	    ACTIVATE("activate"),
	    NOMINATE("nominate"),
	    SET_GENERIC_HUMAN_ROLE("setGenericHumanRole"),
	    EXPIRE("expire"),
	    ESCALATED("escalated");
	    
	    private final String value;

	    TaskEventTypeEnum(String v) {
	        value = v;
	    }

	    public String value() {
	        return value;
	    }

	    public static TaskEventTypeEnum fromValue(String v) {
	        for (TaskEventTypeEnum c: TaskEventTypeEnum.values()) {
	            if (c.value.equals(v)) {
	                return c;
	            }
	        }
	        throw new IllegalArgumentException(v);
	    }

	}

