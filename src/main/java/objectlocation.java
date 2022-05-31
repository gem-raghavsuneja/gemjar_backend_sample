import com.gemini.apitest.ProjectSampleJson;
import com.gemini.dataProvider.QuanticDataProvider;
import com.gemini.generic.QuanticAPIBase;
import com.google.gson.JsonArray;
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

public class objectlocation extends QuanticAPIBase {

    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)

    public static void Healthchecktesting08(JsonObject inputElement) throws FileNotFoundException {

///////////////////Sample////////////////////////////////////////////////////////////
        /*JsonObject object = new JsonObject();
        JsonObject obj2 = new JsonObject();
        obj2.addProperty("Name 1", "anmol");
        obj2.addProperty("Name 2", "sanyam");


        object.add("Name", obj2);
        object.addProperty("Address", "rohtak");
        object.addProperty("phone", "9999999");
        object.addProperty("Company", "Gemini Solutions");
        object.addProperty("Gender", "Male");


        JsonObject obj3 = new JsonObject();
        obj3.addProperty("Name", "Raghav");
        obj3.addProperty("Age", 22);
        obj3.addProperty("Address", "Delhi");
        obj3.addProperty("Status", "Unmrried");
        obj3.addProperty("Value", "Infinite");

        JsonObject obj4 = new JsonObject();
        obj4.addProperty("Names", "anmolarora");
        obj4.addProperty("Names2", "sanyamchugh");
        JsonArray arr2 = new JsonArray();

        JsonObject let = new JsonObject();
        let.addProperty("Hello", "lets");

        JsonObject let2 = new JsonObject();
        let2.addProperty("Pro", "geminiii");

        arr2.add(let);
        arr2.add(let2);

        obj3.add("values", obj4);
        obj3.add("val", arr2);
      //  System.out.println(obj3);
        JsonArray ar = new JsonArray();
        ar.add(object);
        ar.add(obj3);
        System.out.println(object);*/
//////////////////////////////////////////Sample///////////////////////////////////////////////////////////////

        Iterator<?> keys;
        String nextkey;
        //JsonArray payload = ProjectSampleJson.getSampleData("pope_sampleJson").getAsJsonArray();
        JsonObject payload2=ProjectSampleJson.getSampleData("new2_sampleJson").getAsJsonObject();

        int p= getkey(payload2,"koka");
    /*  if (p==0)
      {
          System.out.println("No such element found");
      }*/
        System.out.println("--------------------------------------------------------------");
        // p= getkey(payload,"TOTAL");

    }


    public static int getkey(JsonObject obj,String Key )
    {

        String pather=" ";
        int f=0;

        Set<?> listt = obj.keySet();
        if (obj.has(Key))
        {

            System.out.println(obj.get(Key));
            System.out.println();


            f=1;
        }
        else
        {

            Iterator<?> i = listt.iterator();
            do {
                String value = i.next().toString();
                try {
                    if (obj.get(value) instanceof JsonObject) {
                        JsonObject ok = (JsonObject) obj.get(value);
                        pather=pather+"."+value;
                        int p=  getkey(ok, Key,pather);
                        if (p==1)
                        {

                            System.out.println(pather);
                        }
                        else if(p==0)
                        {
                            pather="";
                        }

                    } else if (obj.get(value) instanceof JsonArray) {

                        JsonArray jaa = obj.getAsJsonArray(value);
                        for (int l = 0; l < jaa.size(); l++) {
                            JsonObject poll = (JsonObject) jaa.get(l);
                            getkey(poll, Key);
                        }

                    }

                } catch (Exception e) {

                }
            } while (i.hasNext());

        }
        return f;
    }
    public static int getkey(JsonObject obj,String Key,String popo )
    {

        int f=0;

        Set<?> listt = obj.keySet();
        if (obj.has(Key))
        {
            f=1;
            System.out.println(popo);
            System.out.println(obj.get(Key));
            System.out.println();

        }
        else
        {

            Iterator<?> i = listt.iterator();
            do {
                String value = i.next().toString();
                try {
                    if (obj.get(value) instanceof JsonObject) {
                        JsonObject ok = (JsonObject) obj.get(value);
                        popo=popo+"."+value;
                        int po= getkey(ok, Key,popo);

                    } else if (obj.get(value) instanceof JsonArray) {

                        JsonArray jaa = obj.getAsJsonArray(value);
                        for (int l = 0; l < jaa.size(); l++) {
                            JsonObject poll = (JsonObject) jaa.get(l);
                            getkey(poll, Key);
                        }

                    }

                } catch (Exception e) {

                }
            } while (i.hasNext());

        }
        return f;
    }
    public static int getkey(JsonArray arr, String Key)
    {
        for (int k=0;k<arr.size();k++)
        {
            JsonObject po= (JsonObject) arr.get(k);
            int l=  getkey(po,Key);
            if (l==1)
            {
                int t=k+1;
                System.out.println("Number of the Json Object in which the element is found"+t);
            }
        }

        return 0;
    }








//////////////////////////////////////////////////////




//////////////////////////////////////////////////







}
