package wsht.runtime.scheduler.enums;

public enum TaskParameterTypeEnum {

	CREATE_TASK,
	CREATE_LEAN_TASK,
	DEADLINE,
	ESCALATION;
	
    public static TaskParameterTypeEnum getType(String name) {
        for (TaskParameterTypeEnum l : TaskParameterTypeEnum.values()) {
            if (l.name().equals(name)) {
                return l;
            }
        }
        return null;
    }
}
