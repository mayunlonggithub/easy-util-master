package zju.edu.als.handler;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Ma
 * @create 2019-09-13 19:48
 */
@FunctionalInterface
public interface Handler<T> {
    T handle(String text);
}
