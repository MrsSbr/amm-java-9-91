package ru.arsentev.cat.rializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ru.arsentev.entities.Cat;

import java.io.IOException;

public class CatSerializer extends StdSerializer<Cat> {
    public CatSerializer() {
        this(null);
    }

    public CatSerializer(Class<Cat> t) {
        super(t);
    }

    @Override
    public void serialize(Cat cat, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeStartObject();

        if (cat.getName() != null) {
            jsonGenerator.writeStringField("name", cat.getName());
        } else {
            jsonGenerator.writeNullField("name");
        }

        jsonGenerator.writeStringField("age", String.valueOf(cat.getAge()));
        jsonGenerator.writeStringField("weight", String.valueOf(cat.getWeight()));

        jsonGenerator.writeBooleanField("isPleased", cat.getIsPleased());

        jsonGenerator.writeStringField("color", cat.getColor().toString());

        jsonGenerator.writeStringField("gender", cat.getGender().toString());

        jsonGenerator.writeEndObject();
        jsonGenerator.writeRaw('\n');
    }
}
