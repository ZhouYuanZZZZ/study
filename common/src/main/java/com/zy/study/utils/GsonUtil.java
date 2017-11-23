package com.zy.study.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zy.study.TypeAdapter.GsonBigDecimalTypeAdapter;
import com.zy.study.TypeAdapter.GsonIntegerTypeAdapter;
import com.zy.study.TypeAdapter.GsonStringTypeAdapter;

import java.math.BigDecimal;

public class GsonUtil {

    private static Gson generalGsonObject;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        gsonBuilder.registerTypeAdapter(String.class,new GsonStringTypeAdapter());
        gsonBuilder.registerTypeAdapter(BigDecimal.class,new GsonBigDecimalTypeAdapter());
        gsonBuilder.registerTypeAdapter(Integer.class,new GsonIntegerTypeAdapter());
        generalGsonObject = gsonBuilder.create();
    }

    public static String toGeneralJsonString(Object obj){
        return generalGsonObject.toJson(obj);
    }

    public static <T> T toGeneralObject(String json,Class<T> clazz){
        return generalGsonObject.fromJson(json,clazz);
    }
}
