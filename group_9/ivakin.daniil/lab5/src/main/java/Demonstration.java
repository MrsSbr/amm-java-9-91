import Convertors.JsonToPojoConvertor;
import Convertors.PojoToJsonConvertor;
import Example.Cat;
import Example.Gender;

public class Demonstration {
    public static void main(String[] args) {
        Cat cat = new Cat("Матроскин", 10, Gender.MALE, null, false);

        String jsonString = PojoToJsonConvertor.getJSONStr(cat);

        System.out.println("Объект в формате JSON:");
        System.out.println(jsonString);

        JsonToPojoConvertor deserializer = new JsonToPojoConvertor();
        Cat deserializedCat = (Cat) deserializer.getObject(Cat.class, jsonString);
        jsonString = PojoToJsonConvertor.getJSONStr(deserializedCat);
        System.out.println("Десериализованный объект в формате JSON:");
        System.out.println(jsonString);

        System.out.println("Десериализованный объект совпадает с изначальным?");
        System.out.println(cat.equals(deserializedCat));
    }
}