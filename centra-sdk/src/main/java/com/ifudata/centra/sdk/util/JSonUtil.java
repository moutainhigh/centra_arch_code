package com.ifudata.centra.sdk.util;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSonUtil
{
  private static final transient Logger log = LoggerFactory.getLogger(JSonUtil.class);

  private static Gson gson = new Gson();

  public static String toJSon(Object obj)
  {
    String json = gson.toJson(obj);
    if (log.isInfoEnabled()) {
      log.info(obj + " trasform into json:" + json);
    }
    return json;
  }

  public static <T> T fromJSon(String json, Class<T> clazz) {
    Object t = gson.fromJson(json, clazz);
    if (log.isInfoEnabled()) {
      log.info(json + " trasform into class:" + clazz + ",object:" + t);
    }
    return (T) t;
  }
}