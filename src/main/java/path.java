
import com.gemini.apitest.ProjectSampleJson;
import com.gemini.dataProvider.QuanticDataProvider;
import com.gemini.generic.QuanticAPIBase;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.tomcat.util.json.JSONParser;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
@Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)

public class path extends QuanticAPIBase {
    public static void Healthchecktesting08(JsonObject inputElement) throws FileNotFoundException {

         JsonObject object = new JsonObject();
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
        System.out.println(object);
        List<String> listt=new ArrayList<>();
       //System.out.println(object.keySet());

       String[] ap=object.keySet().toArray(new String[0]);
       for (int i=0;i<ap.length;i++) {
           System.out.println(ap[i]);


           if (ap[i].equalsIgnoreCase("name"))
           {
               System.out.println("json objct-->"+ap[i]);
           }
       }
    }

    }
