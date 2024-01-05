package com.hsf.javagather;



import org.json.JSONArray;
import org.json.JSONObject;

public class JavaFacadeTest {
    public static void main(String[] args) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("page", "pagefirst");
        jsonObj.put("code", 6);

        JSONObject jsonObjInner = new JSONObject();
        jsonObjInner.put("weight", 50.5);

        JSONArray jsonArrayInner = new JSONArray();
        jsonArrayInner.put("hsf");
        JSONObject jsonArrayInnerObj = new JSONObject();
        jsonArrayInnerObj.put("name", "hwt");
        jsonArrayInnerObj.put("nickname", JSONObject.NULL);
        jsonArrayInner.put(jsonArrayInnerObj);

        jsonObjInner.put("person", jsonArrayInner);

        jsonObj.put("data", jsonObjInner);

        System.out.println(jsonObj);
    }
}
