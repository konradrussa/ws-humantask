package wsht.runtime.model.views;

import java.util.Date;

public class SimpleTaskView extends AbstractTaskView {

	private Boolean HasPotentialOwners;
	private Boolean StartByTimeExists;
	private Boolean CompleteByTimeExists;
	private Boolean RenderingMethodExists;
	
	public Boolean getHasPotentialOwners() {
		return HasPotentialOwners;
	}
	public void setHasPotentialOwners(Boolean hasPotentialOwners) {
		HasPotentialOwners = hasPotentialOwners;
	}
	public Boolean getStartByTimeExists() {
		return StartByTimeExists;
	}
	public void setStartByTimeExists(Boolean startByTimeExists) {
		StartByTimeExists = startByTimeExists;
	}
	public Boolean getCompleteByTimeExists() {
		return CompleteByTimeExists;
	}
	public void setCompleteByTimeExists(Boolean completeByTimeExists) {
		CompleteByTimeExists = completeByTimeExists;
	}
	public Boolean getRenderingMethodExists() {
		return RenderingMethodExists;
	}
	public void setRenderingMethodExists(Boolean renderingMethodExists) {
		RenderingMethodExists = renderingMethodExists;
	}
	
	
}
