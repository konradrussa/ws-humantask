package wsht.marshalling;

import java.util.List;

public interface IBeanMapper {

	public <G,T> T map(G serialize, Class<T> unserialize);
	public <G,T> List<T> mapList(List<G> serializeList,Class<T> unserialize);
}
