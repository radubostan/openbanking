package com.radub.openbanking.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.threeten.bp.OffsetDateTime;
import java.io.IOException;

@Configuration
public class JacksonConfig {

	@Bean
	@Primary
	public ObjectMapper serializingObjectMapper() {
	    ObjectMapper objectMapper = new ObjectMapper();
	    JavaTimeModule javaTimeModule = new JavaTimeModule();
	    javaTimeModule.addSerializer(OffsetDateTime.class, new OffsetDateTimeSerializer());
	    javaTimeModule.addDeserializer(OffsetDateTime.class, new OffsetDateTimeDeserializer());	  
	    objectMapper.registerModule(javaTimeModule);
	    return objectMapper;
	}

	public static class OffsetDateTimeSerializer extends JsonSerializer<OffsetDateTime> {
	    @Override
	    public void serialize(OffsetDateTime arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException {
	        arg1.writeString(arg0.toString());
	    }
	}

	public static class OffsetDateTimeDeserializer extends JsonDeserializer<OffsetDateTime> {
	 
		@Override
		public OffsetDateTime deserialize(JsonParser p, DeserializationContext ctxt)
				throws IOException, JsonProcessingException {
			return OffsetDateTime.parse(p.getText());
		}
	}
	
}
