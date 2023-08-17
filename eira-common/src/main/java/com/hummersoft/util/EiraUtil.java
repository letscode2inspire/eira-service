package com.hummersoft.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Slf4j
@Component
public class EiraUtil {

    @SneakyThrows
    public String encodeObject(Object object){
        log.debug("Inside encodeObject in EiraUtil");
        String temp = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).writeValueAsString(object);
        return Base64.getEncoder().encodeToString(temp.getBytes());
    }

    public String decodeObject(String encoded){
        log.debug("Inside decodeObject in EiraUtil");
        return new String(Base64.getUrlDecoder().decode(encoded));
    }
}
