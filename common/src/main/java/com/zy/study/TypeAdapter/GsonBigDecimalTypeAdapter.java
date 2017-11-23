package com.zy.study.TypeAdapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.math.BigDecimal;

public class GsonBigDecimalTypeAdapter extends TypeAdapter<BigDecimal> {
    @Override
    public void write(JsonWriter out, BigDecimal value) throws IOException {
        if (value == null) {
            // 在这里处理null改为空字符串
            out.value("");
            return;
        }
        out.value(value);
    }

    @Override
    public BigDecimal read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return new BigDecimal(-1);
        }

        BigDecimal bigDecimal = new BigDecimal(in.nextString());
        return bigDecimal;
    }
}
