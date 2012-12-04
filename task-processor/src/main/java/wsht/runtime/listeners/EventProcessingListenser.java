package wsht.runtime.listeners;

public interface EventProcessingListenser {

	public void onStartDeadline();
	public void onEndDeadline();
	public void onStartEscalation();
	public void onEndEscalation();
	public void onNotification();
	public void onDelegation();
}
