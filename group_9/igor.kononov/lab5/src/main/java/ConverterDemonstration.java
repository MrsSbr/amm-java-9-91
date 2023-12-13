import converter.Converter;
import example.Cat;
import example.Gender;

public class ConverterDemonstration {
    public static void main(String[] args) {
        var cat = new Cat("Tom", 5, Gender.MALE, "Persian", false);

        var converter = new Converter();

        var json = converter.serializeToJSON(cat);
        System.out.println("Serialized object: " + json);
        var deserializedCat = converter.deserialiseFromJSON(json, Cat.class);

        if (cat.equals(deserializedCat)) {
            System.out.println("Original and deserialized objects are equals");
        }
        else {
            System.out.println("Original and deserialized objects are not equals");
        }
    }
}
