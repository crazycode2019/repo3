package com.hwua.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DTest {
    public static void main(String[] args) {
        JSONObject jo1 = new JSONObject();
        Map<String, String> map1 = new HashMap<String, String>();
        Map<String, String> map2 = new HashMap<String, String>();
        map1.put("location", "(1636, 467, 1685, 530)");
        map2.put("location", "(1631, 472, 1702, 541)");

        Object[] location1 = {map1, map2};
        jo1.put("alertObjects", location1);
        jo1.put("pid", "192.168.1.160|1573546069889|17");
        System.out.println(location1);


        JSONObject jo2 = new JSONObject();
        String[] location2 = {};
        jo2.put("alertObjects", location2);
        jo2.put("pid", "192.168.1.160|1573546069889|18");


        JSONArray ja = new JSONArray();
        ja.add(jo1);
        ja.add(jo2);

        String s = ja.toString();
        System.out.println(s);

        List<Map<String, Object>> listObjectFir = (List<Map<String, Object>>) JSONArray.parse(s);
        System.out.println(listObjectFir);
        ;
        for (Map<String, Object> mapList : listObjectFir) {
            String pidkey="pid";
            String alertObjectskey="alertObjects";
            String pidValue=(String)mapList.get(pidkey);
            if(pidValue.equals("192.168.1.160|1573546069889|17")){
                //根据key得到json数组
                JSONArray jsonArray=(JSONArray)mapList.get(alertObjectskey);
                //遍历json数组
                for(int i=0;i<jsonArray.size();i++){
                    //取出一个个json对象
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    System.out.println(jsonObject.get("location"));
                }

            }


            /*for (Map.Entry entry : mapList.entrySet()) {
//                System.out.println(entry.getKey() + ":1:" + entry.getValue());
                if (entry.getKey().equals("pid") && entry.getValue().equals("192.168.1.160|1573546069889|17")) {
                    for (Map.Entry entry1 : mapList.entrySet()) {
                        if (entry1.getKey().equals("alertObjects")) {
                            System.out.println(entry1.getValue());


                        }

                    }


                }
            }*/
        }

    }
}

/* {
      "alertObjects": [],
      "picId": "192.168.1.160|1573546069889|17"
    },
    {
      "alertObjects": [
        {
          "location": "(1636, 467, 1685, 530)"
        },
        {
          "location": "(1631, 472, 1702, 541)"
        }
      ],
      "picId": "192.168.1.160|1573546078735|17"
    },*/