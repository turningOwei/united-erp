package com.common.gsonutil;

import com.common.gsonutil.gsonadapter.DateDefaultAdaper;
import com.common.gsonutil.gsonadapter.DoubleDefaultAdaper;
import com.common.gsonutil.gsonadapter.IntegerDefaultAdaper;
import com.common.gsonutil.gsonadapter.LongDefaultAdaper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

public class GsonUtil {
    private static Gson gson = new GsonBuilder()
            .registerTypeAdapter(Date.class, new DateDefaultAdaper())
            .registerTypeAdapter(Double.class, new DoubleDefaultAdaper())
            .registerTypeAdapter(Long.class,new LongDefaultAdaper())
            .registerTypeAdapter(Integer.class,new IntegerDefaultAdaper())
            .create();

    public static Gson create() {
        return gson;
    }

    public static String beanToJSONString(Object bean) {
        return new Gson().toJson(bean);
    }
}
