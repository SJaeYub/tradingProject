package cmn.parsing;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class ParseJsonString {

//    샘플 실행 코드
//    public static void main(String[] args) {
//        String jsonString = "{\"name\":\"John\", \"age\":30, \"city\":\"New York\"}";
//
//        JsonObject jsonObject = parseJsonString(jsonString);
//        System.out.println(jsonObject.get("name").getAsString());
//        System.out.println(jsonObject.get("age").getAsInt());
//        System.out.println(jsonObject.get("city").getAsString());
//    }

    public JsonObject parseJsonString(String jsonString) {
        JsonObject jsonObject = null;
        Gson gson = new Gson();

        try {
            jsonObject = gson.fromJson(jsonString, JsonObject.class);
        } catch (JsonParseException e) {
            System.out.println("Failed to parse JSON: " + e.getMessage());
        }

        return jsonObject;
    }
}
