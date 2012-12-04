package wsht.marshalling;

public interface IWSHTMarshallingService {

	public <T> String marshall(T object, Class<T> clazz);
}
