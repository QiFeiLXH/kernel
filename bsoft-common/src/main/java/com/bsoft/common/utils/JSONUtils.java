package com.bsoft.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.text.SimpleDateFormat;

/**
 * @Author: xucl
 * @DateTime: 2020/9/23 19:45
 * @Description:
 */
public class JSONUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public JSONUtils() {
    }

    public static <T> T parse(String value, Class<T> clz) {
        if (StringUtils.isEmpty(value)) {
            return null;
        } else {
            try {
                return mapper.readValue(value, clz);
            } catch (Exception var3) {
                throw new IllegalStateException(var3);
            }
        }
    }

    public static <T> T parse(byte[] bytes, Class<T> clz) {
        try {
            return mapper.readValue(bytes, clz);
        } catch (Exception var3) {
            throw new IllegalStateException(var3);
        }
    }

    public static <T> T parse(InputStream ins, Class<T> clz) {
        try {
            return mapper.readValue(ins, clz);
        } catch (Exception var3) {
            throw new IllegalStateException(var3);
        }
    }

    public static <T> T parse(Reader reader, Class<T> clz) {
        try {
            return mapper.readValue(reader, clz);
        } catch (Exception var3) {
            throw new IllegalStateException(var3);
        }
    }

    public static JavaType createCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    public static <T> T parse(String value, JavaType javaType) {
        if (StringUtils.isEmpty(value)) {
            return null;
        } else {
            try {
                return mapper.readValue(value, javaType);
            } catch (IOException var3) {
                throw new IllegalStateException(var3);
            }
        }
    }

    public static <T> T update(String value, T object) {
        try {
            return mapper.readerForUpdating(object).readValue(value);
        } catch (Exception var3) {
            throw new IllegalStateException(var3);
        }
    }

    public static String writeValueAsString(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (Exception var2) {
            throw new IllegalStateException(var2);
        }
    }

    public static void write(OutputStream outs, Object o) {
        try {
            mapper.writeValue(outs, o);
        } catch (Exception var3) {
            throw new IllegalStateException(var3);
        }
    }

    public static void write(Writer writer, Object o) {
        try {
            mapper.writeValue(writer, o);
        } catch (Exception var3) {
            throw new IllegalStateException(var3);
        }
    }

    public static String toString(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (Exception var2) {
            throw new IllegalStateException(var2);
        }
    }

    public static byte[] toBytes(Object o) {
        try {
            return mapper.writeValueAsBytes(o);
        } catch (Exception var2) {
            throw new IllegalStateException(var2);
        }
    }

    static {
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
