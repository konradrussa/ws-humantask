package wsht.marshalling.exception;

public class MarshalException extends WSHTMarshallingException {
    private Object obj;

    public MarshalException(Throwable cause, Object obj) {
        super(cause);
        this.obj = obj;
    }

}
