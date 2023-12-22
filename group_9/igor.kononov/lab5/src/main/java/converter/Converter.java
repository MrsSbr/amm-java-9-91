package converter;


public class Converter {
    private final Serializer serializer;
    private final Deserializer deserializer;

    public Converter() {
        serializer = new Serializer();
        deserializer = new Deserializer();
    }

    public String serializeToJSON(Object obj) {
        return serializer.serializeJSON(obj);
    }

    public Object deserialiseFromJSON(String json, Class<?> objType) {
        return deserializer.DeserializeJSON(json, objType);
    }
}
