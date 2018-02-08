package com.miu360.annwalk.model.http.analysis;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.miu360.annwalk.base.BaseEntity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Murphy on 2018/2/2.
 * 参照GsonResponseBodyConverter，重写主要为了解密数据
 */

public class JsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final TypeAdapter<T> adapter;

    JsonResponseBodyConverter (TypeAdapter<T> adapter) {
        this.adapter = adapter;
    }

    @Override public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        //String strResult = new String(CompressUtil.unGZip(Base64.decodeResultToBytes("returnjson",response)));解密数据方法
        try{
            return adapter.fromJson(response);
        } catch (Exception e) {
            e.printStackTrace();
            return (T) analysis(response);
        } finally {
            value.close();
        }
    }

    /**
     * 这个方法主要是解决，Gson解析不了的(如data不是retrofit请求的类)，自己自定义空data的BaseEntity,这样方便暴漏问题到前端
     */
    private BaseEntity<String> analysis(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            BaseEntity<String> entity = new BaseEntity<>();
            entity.setError(jsonObject.optInt("error"));
            entity.setErrormsg(jsonObject.optString("errormsg"));
            entity.setData("");
            return entity;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
