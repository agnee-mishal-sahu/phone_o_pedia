package com.phoneopedia.common.utilites;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.phoneopedia.common.constants.MessageConstants;
import com.phoneopedia.logging.interceptor.LoggingObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public final class JsonUtils {

	private static Gson gson;

	/**
	 * initialize the Gson object
	 */
	static {
		gson = new GsonBuilder().setDateFormat(MessageConstants.DATE_FORMAT).create();
	}

	private JsonUtils() {

	}

	/**
	 * convert Object to Json String
	 */
	public static String toJson(Object srcObject) {
		return gson.toJson(srcObject);
	}

	/**
	 * convert Json String to Object
	 */
	public static <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
		return gson.fromJson(json, classOfT);
	}

	public static String getAsJson(Object request) {

		try {
			ObjectMapper mapper = new LoggingObjectMapper().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
					.disable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS)
					.registerModule(new JavaTimeModule());
			return mapper.writeValueAsString(request);
		} catch (JsonProcessingException ignored) {
			log.error("Failed to getJson from {}", request.getClass().getSimpleName(), ignored);
			return "";
		}
	}

	public static String getAsPrettyJson(Object request) {

		try {
			ObjectMapper mapper = new LoggingObjectMapper().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
					.disable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS)
					.registerModule(new JavaTimeModule());
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
		} catch (JsonProcessingException ignored) {
			log.error("Failed to getJson from {}", request.getClass().getSimpleName(), ignored);
			return "";
		}
	}

}
