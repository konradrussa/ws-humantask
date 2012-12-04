package wsht.runtime.enums;

public enum FunctionEnum {
	
	getActualOwner,
	getBusinessAdministrators,
	getCountOfFinishedSubTasks,
	getCountOfSubTasks,
	getCountOfSubTasksInState,
	getCountOfSubTasksWithOutcome,
	getExcludedOwners,
	getInput,
	getLogicalPeopleGroup,
	getOutcome,
	getOutput,
	getPotentialOwners,
	getSubtaskOutput,
	getSubtaskOutputs,
	getTaskInitiator,
	getTaskPriority,
	getTaskStakeholders,
	except,
	intersect,
	union,
	concat,
	concatWithDelimiter,
	leastFrequentOccurence,
	mostFrequentOccurence,
	voteOnString,
	and,
	or,
	vote,
	avg,
	max,
	min,
	sum;
	
	public static FunctionEnum getOperationForName(String methodName) {
		for(FunctionEnum e : FunctionEnum.values()) {
			if(e.name().equals(methodName)) {
				return e;
			}
		}
		throw new IllegalArgumentException("FunctionEnum not found !!!");
	}
       

}
