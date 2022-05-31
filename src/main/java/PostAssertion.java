

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.gemini.apitest.ApiClientConnect;
import com.gemini.apitest.ProjectApiUrl;
import com.gemini.apitest.ProjectSampleJson;

import com.gemini.dataProvider.QuanticDataProvider;
import com.gemini.generic.QuanticAPIBase;
import com.gemini.quartzReporting.GemTestReporter;
import com.gemini.quartzReporting.STATUS;
public class PostAssertion {
    public static void postAssertion(JsonElement responseBody, String assertionQuery) {
        boolean flag = true;
        JsonElement temp = responseBody;

        String[] queryArray = assertionQuery.split("#");

        try {
            if (queryArray.length != 3) {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            System.out.println("Assertion Query is not valid");
        }

        String query = queryArray[0];
        String operator = queryArray[1].toUpperCase();
        String target = queryArray[2];

        System.out.println("left_query ---> " + query);
        System.out.println("operator ---> " + operator);
        System.out.println("left_query ---> " + target);


        while (flag) {
            int startIndex = query.indexOf("(");
            int endIndex = query.indexOf(")");
            String key = query.substring(startIndex + 1, endIndex);

            temp = PostAssertion.getLeftQuery(temp, key);
            // System.out.println("------------->"+ temp.toString());

//            boolean isNumeric = key.chars().allMatch( Character::isDigit);
//
//            if(isNumeric){
//                if(responseBody.get(Integer.parseInt(key)) instanceof JsonArray){
//                    isJsonArray = true;
//
//                }else{
//                    isJsonArray = false;
//                }
//
//                if(isJsonArray){
//                    responseBodyLeft = ((JsonArray) responseBody.get(Integer.parseInt(key))).toString();
//                }
//            }else{
//
//            }
//
            query = query.substring(endIndex + 1);
//            System.out.println("left_query ->  "+ query);

            if (
                    query.length() <= 0) {
                flag = false;
            }
        }

        try {
            switch (operator) {
                case "TO": {
                    if (temp!=null && temp.getAsString().equalsIgnoreCase(target)) {
                        System.out.println("PASS");
                    } else {
                        System.out.println("FAIL");
                    }
                    break;
                }

                case "IN": {
                    JsonArray targetArray = JsonParser.parseString(target).getAsJsonArray();
                    System.out.println("JSONARRAY------>" + targetArray);
                    if (targetArray.contains(temp)) {
                        System.out.println("PASS");
                    } else {
                        System.out.println("FAIL");
                    }
                    break;
                }

                case "CONTAINS": {
                    if (temp!=null && temp.getAsString().toUpperCase().contains(target.toUpperCase())) {
                        System.out.println("PASS");
                    } else {
                        System.out.println("FAIL");
                    }
                    break;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static JsonElement getLeftQuery(JsonElement request, String key){
        boolean isNumeric = key.chars().allMatch( Character::isDigit);
        if(request instanceof JsonArray && isNumeric){
            return request.getAsJsonArray().get(Integer.parseInt(key));
        }
        if(request instanceof JsonObject && !isNumeric){
            return request.getAsJsonObject().get(key);
        }
        return null;
    }
}


