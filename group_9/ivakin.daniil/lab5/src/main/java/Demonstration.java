import Convertors.JsonToPojoConvertor;
import Convertors.PojoToJsonConvertor;
import Example.Cat;
import Example.Gender;

public class Demonstration {
    public static void main(String[] args) {
        Cat cat = new Cat("Матроскин", 10, Gender.MALE, null, false);

        PojoToJsonConvertor serializer = new PojoToJsonConvertor();
        JsonToPojoConvertor deserializer = new JsonToPojoConvertor();


        String jsonString = serializer.getJSONStr(cat);

        System.out.println("Объект в формате JSON:");
        System.out.println(jsonString);

        Cat deserializedCat = (Cat) deserializer.getObject(Cat.class, jsonString);
        jsonString = serializer.getJSONStr(deserializedCat);
        System.out.println("Десериализованный объект в формате JSON:");
        System.out.println(jsonString);

        System.out.println("Десериализованный объект совпадает с изначальным?");
        System.out.println(cat.equals(deserializedCat));
    }
}