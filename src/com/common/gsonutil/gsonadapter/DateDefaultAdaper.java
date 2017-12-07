package com.common.gsonutil.gsonadapter;

import com.common.dateutil.DateUtil;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;

/**
 *
 * 描述:gson转换 空字符串转日期处理
 *
 * @author 002465
 * @created 2017年4月12日 下午4:37:37
 * @since v1.0.0
 */
public class DateDefaultAdaper implements JsonDeserializer<Date> {

    /**
     * 转换器同时支持字符串(绝大多数任意格式)的日期,时间戳 转Date
     */
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        try {
            if (json.getAsString().equals("") || json.getAsString().equals("null")) {
                return null;
            }
            if (json.getAsLong() > 0) {// 给的时间戳
                return DateUtil.getDateByTimeStamp(json.getAsLong());
            }
        } catch (Exception ignore) {
        }
        return DateUtil.StringToDate(json.getAsString());

    }

}
