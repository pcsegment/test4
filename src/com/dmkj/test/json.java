package com.dmkj.test;

import java.util.ArrayList;
import java.util.List;

import org.json.*;
//************
///
////
public class json {
	public static void main(String[] args)  throws JSONException{
        StringCreateJson();
    }
    
	
	
    static void StringCreateJson() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","王尼玛");
        
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name","王");
        jsonObject1.put("age",7);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("name","王尼玛");
        jsonObject2.put("age",10);

        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        jsonObjects.add(jsonObject1);
        jsonObjects.add(jsonObject2);
        jsonObject.put("fans", jsonObjects);

        System.out.println("json:" + format(jsonObject.toString()));
    }
    
    public static String format(String jsonStr) {
        int level = 0;
        StringBuffer jsonForMatStr = new StringBuffer();
        for(int i=0;i<jsonStr.length();i++){
            char c = jsonStr.charAt(i);
            if(level>0&&'\n'==jsonForMatStr.charAt(jsonForMatStr.length()-1)){
                jsonForMatStr.append(getLevelStr(level));
            }
            switch (c) {
            case '{':
            case '[':
                jsonForMatStr.append(c+"\n");
                level++;
                break;
            case ',':
                jsonForMatStr.append(c+"\n");
                break;
            case '}':
            case ']':
                jsonForMatStr.append("\n");
                level--;
                jsonForMatStr.append(getLevelStr(level));
                jsonForMatStr.append(c);
                break;
            default:
                jsonForMatStr.append(c);
                break;
            }
        }
         
        return jsonForMatStr.toString();
 
    }
    private static String getLevelStr(int level){
        StringBuffer levelStr = new StringBuffer();
        for(int levelI = 0;levelI<level ; levelI++){
            levelStr.append("\t");
        }
        return levelStr.toString();
    }
}
