package com.thoughtworks.capability.gtb.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.thoughtworks.capability.gtb.vo.PersonVo;
import java.io.IOException;

public class PersonVoSerializer extends StdSerializer<PersonVo> {

    public PersonVoSerializer() {
        this(null);
    }

    public PersonVoSerializer(Class<PersonVo> t) {
        super(t);
    }

    @Override
    public void serialize(PersonVo value, JsonGenerator gen, SerializerProvider provider)
        throws IOException {

        gen.writeStartObject();
        gen.writeStringField("id", value.getId());
        gen.writeNumberField("age", value.getAge() == null ? 0 : value.getAge());
        gen.writeStringField("name", value.getName());
        if (value.getHobby() != null) {
            gen.writeStringField("hobby", value.getHobby());
        }
        gen.writeEndObject();
    }


}
