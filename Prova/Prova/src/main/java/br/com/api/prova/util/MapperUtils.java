package br.com.api.prova.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MapperUtils {

        public static <T> T mapperUtils(Object fromValue, Class<T> toValueType) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(fromValue, toValueType);
    }
}
