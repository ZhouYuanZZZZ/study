package com.zy.study.TypeAdapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class GsonStringTypeAdapter extends TypeAdapter<String> {
    @Override
    public void write(JsonWriter out, String value) throws IOException {
        if (value == null) {
            // 在这里处理null改为空字符串
            out.value("");
            return;
        }
        out.value(value);
    }

    @Override
    public String read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return "";
        }
        return in.nextString();
    }
}
