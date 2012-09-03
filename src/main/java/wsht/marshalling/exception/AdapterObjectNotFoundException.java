package wsht.marshalling.exception;

import java.io.Serializable;

public class AdapterObjectNotFoundException extends WSHTException {
	private static final long serialVersionUID = -5867119953148842741L;
	
	private Class adapterBoundType;
    private Serializable id;
    private long rejectionReasonId;

    public AdapterObjectNotFoundException(Throwable cause, Class adapterBoundType, Serializable id, long rejectionReasonId) {
        super(cause);
        this.adapterBoundType = adapterBoundType;
        this.id = id;
    }

    public Class getAdapterBoundType() {
        return adapterBoundType;
    }


    public Serializable getId() {
        return id;
    }


    public long getRejectionReasonId() {
        return rejectionReasonId;
    }

}
