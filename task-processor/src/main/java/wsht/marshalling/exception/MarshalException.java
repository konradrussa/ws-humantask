package wsht.marshalling.exception;

public class MarshalException extends WSHTException {
    private Object obj;

    public MarshalException(Throwable cause, Object obj) {
        super(cause);
        this.obj = obj;
    }

}
