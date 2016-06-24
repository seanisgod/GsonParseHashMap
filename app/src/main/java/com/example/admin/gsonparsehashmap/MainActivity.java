package com.example.admin.gsonparsehashmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String content;
    private Gson gson = new Gson();
    private CityModel cityModel = new CityModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        content = "{\"data\":{\"苏州市\":\"320500000000\",\"徐州市\":\"320300000000\",\"盐城市\":\"320900000000\",\"扬州市\":\"321000000000\",\"南京市\":\"320100000000\"}}";
        cityModel = gson.fromJson(content, new TypeToken<CityModel>() {
        }.getType());
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap = cityModel.getData();
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            Log.d("xy", "key为" + key + " value为" + value);
        }
    }
}
