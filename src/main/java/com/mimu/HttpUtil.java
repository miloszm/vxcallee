package com.mimu;

import org.vertx.java.core.MultiMap;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.core.http.HttpServerResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by miloszmuszynski on 10/11/2014.
 *
 *
 * TODO this class is duplicated
 *
 */
public class HttpUtil {

    public static void sendHeaders(HttpServerResponse response, MultiMap headers){
        List<String> headerList = sliceMultiMap(headers);
        for (String headerStr: headerList) {
            response.write(headerStr);
        }
    }

    private static List<String> sliceMultiMap(MultiMap headers){
        List<String> list = new ArrayList<>();
        for (Map.Entry<String,String> e: headers.entries()){
            list.add("<li>" + e.getKey() + ": " + e.getValue() + "</li>\n");
        }
        return list;
    }

}
