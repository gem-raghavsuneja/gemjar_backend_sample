import com.gemini.apitest.ProjectSampleJson;
import com.gemini.dataProvider.QuanticDataProvider;
import com.gemini.generic.QuanticAPIBase;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.path.json.config.JsonPathConfig;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Location extends QuanticAPIBase {

    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)

    public static void Healthchecktesting08(JsonObject inputElement) throws FileNotFoundException {


        Iterator<?> keys;
        String nextkey;
        //JsonArray payload = ProjectSampleJson.getSampleData("pope_sampleJson").getAsJsonArray();
        JsonObject payload2 = ProjectSampleJson.getSampleData("new2_sampleJson").getAsJsonObject();

        getkey(payload2, "dose");
        System.out.println("----------------------------------------");
        // deepSearch(payload2,"strength");
    /*  if (p==0)
      {
          System.out.println("No such element found");
      }*/
        System.out.println("--------------------------------------------------------------");
        // p= getkey(payload,"TOTAL");

    }


    public static int getkey(JsonObject obj, String Key) {

        String pather = "Body";
        int f = 0;

        Set<?> listt = obj.keySet();
        if (obj.has(Key)) {

            System.out.println(obj.get(Key));
            System.out.println(pather + "." + Key);


        } else {

            Iterator<?> i = listt.iterator();
            do {
                String value = i.next().toString();
                try {
                    if (obj.get(value) instanceof JsonObject) {
                        JsonObject ok = (JsonObject) obj.get(value);
                        //pather = pather + "." + value;
                        String p = getkey(ok, Key, pather + "." + value);
                        if (p != null) {

                            System.out.println(p + "." + Key);


                        } else {

                        }

                    } else if (obj.get(value) instanceof JsonArray) {

                        JsonArray jaa = obj.getAsJsonArray(value);
                        for (int l = 0; l < jaa.size(); l++) {
                            JsonObject poll = (JsonObject) jaa.get(l);


                            String lo = getkey(poll, Key, pather + "." + value + "." + l);
                            //     lo+=("."+l);
                            if (lo != null) {
                                //  lo+=("."+l+"."+Key);
                                System.out.println(lo + "." + Key);
                            } else {

                            }
                        }

                    }

                } catch (Exception e) {

                }
            } while (i.hasNext());

        }
        return f;
    }

    public static String getkey(JsonObject obj, String Key, String popo) {

        int f = 0;

        Set<?> listt = obj.keySet();
        if (obj.has(Key)) {
            f = 1;
            // System.out.println(popo);

            System.out.println(obj.get(Key));

            return popo;
        } else {

            Iterator<?> i = listt.iterator();
            do {
                String value = i.next().toString();
                try {
                    if (obj.get(value) instanceof JsonObject) {
                        JsonObject ok = (JsonObject) obj.get(value);
                        //  popo = popo + "." + value;
                        String po = getkey(ok, Key, popo + "." + value);
                        if (po != null) {
                            return po;
                        }

                    } else if (obj.get(value) instanceof JsonArray) {

                        JsonArray jaa = obj.getAsJsonArray(value);
                        for (int l = 0; l < jaa.size(); l++) {
                            JsonObject poll = (JsonObject) jaa.get(l);

                            //  popo=popo+"."+value;
                            // getkey(poll, Key);
                            String lo = getkey(poll, Key, popo + "." + value + "." + l);
                            //    value+=("."+l);
                            if (lo != null) {
                                System.out.println(lo + "." + Key);
                            } else {

                            }
                        }

                    }

                } catch (Exception e) {

                }
            } while (i.hasNext());

        }
        return null;
    }

    public static int getkey(JsonArray arr, String Key) {
        for (int k = 0; k < arr.size(); k++) {
            JsonObject po = (JsonObject) arr.get(k);
            int l = getkey(po, Key);
            if (l == 1) {
                int t = k + 1;
                System.out.println("Number of the Json Object in which the element is found" + t);
            }
        }

        return 0;
    }
}
