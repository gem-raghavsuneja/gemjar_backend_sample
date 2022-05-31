import com.fasterxml.jackson.core.JsonParser;
import com.gemini.apitest.ApiClientConnect;
import com.gemini.apitest.DeepSearch;
import com.gemini.apitest.ProjectApiUrl;

import com.gemini.dataProvider.QuanticDataProvider;
import com.gemini.generic.QuanticAPIBase;
import com.gemini.generic.QuanticHealthCheckBase;
import com.gemini.quartzReporting.GemTestReporter;
import com.gemini.quartzReporting.STATUS;
import com.github.dockerjava.api.model.HealthCheck;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;
import com.gemini.apitest.DeepSearch;

import java.io.FileNotFoundException;

public class getsuite extends QuanticHealthCheckBase
   {

       @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)

       public static void Healthchecktesting08(JsonObject inputElement) throws FileNotFoundException {


           {
               ApiClientConnect.healthCheck("C:\\Users\\ra.suneja\\Desktop\\Anshul API project\\Anshul API Project\\src\\main\\resources\\Healthcheck_sampleJson.json");


           }
       }

       /* GemTestReporter.addTestStep("Test Case", "Test to check the Get API", STATUS.INFO);
        String url = ProjectApiUrl.getUrl("Getsuite1");
        GemTestReporter.addTestStep("URL of the Get function", url, STATUS.INFO);
        JsonObject response = null;
        try {
            response = ApiClientConnect.getRequest(url);
            System.out.println(response);
            GemTestReporter.addTestStep("Test case to check the Execution of the Get Function", "Get Request Executed successful", STATUS.PASS);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Test case to check the Execution of the Get Function", "Get Request Did not Executed successful", STATUS.FAIL);

        }


        int status = response.get("status").getAsInt();

        System.out.print(status);
        GemTestReporter.addTestStep("Status", String.valueOf(status), STATUS.INFO);
        JsonObject rb = null;

        if (status >= 200 && status < 300) {
            rb = response.get("responseBody").getAsJsonObject();
        } else {
            rb = response.get("responseError").getAsJsonObject();
        }


        String me = String.valueOf(rb.get("message"));
        if (status == 200) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status: 200 ", STATUS.PASS);
            GemTestReporter.addTestStep("Response Body", String.valueOf(rb), STATUS.INFO);

        } else {
            GemTestReporter.addTestStep("Status Verification", "Expected Status: 200" , STATUS.FAIL);
            GemTestReporter.addTestStep("Response Body", String.valueOf(response), STATUS.INFO);

        }*/

    }



   // @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
   /* public void Getsuite_tcrunidnotpresent(JsonObject inputData) {
        GemTestReporter.addTestStep("Test Case", "Test to check the Get API", STATUS.INFO);
        String url = ProjectApiUrl.getUrl("Getsuite2");
        GemTestReporter.addTestStep("URL of the Get function", url, STATUS.INFO);
        JsonObject response = null;
        try {
            response = ApiClientConnect.getRequest(url);
            System.out.println(response);
            GemTestReporter.addTestStep("Test case to check the Execution of the Get Function", "Get Request Executed successful", STATUS.PASS);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Test case to check the Execution of the Get Function", "Get Request Did not Executed successful", STATUS.FAIL);

        }


        int status = response.get("status").getAsInt();

        System.out.print(status);
        GemTestReporter.addTestStep("Status", String.valueOf(status), STATUS.INFO);
        JsonObject rb = null;

        if (status >= 200 && status < 300) {
            rb = response.get("responseBody").getAsJsonObject();
        } else {
            rb = response.get("responseError").getAsJsonObject();
        }


        String me = String.valueOf(rb.get("message"));
        if (status == 200) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status: 200, Status we got " + status, STATUS.PASS);
            GemTestReporter.addTestStep("Response Body", String.valueOf(rb), STATUS.INFO);
            GemTestReporter.addTestStep("Response message", "EXpected message:Data fetched successfully message we got " + me, STATUS.PASS);

        } else {
            GemTestReporter.addTestStep("Status Verification", "Expected Status: 200" , STATUS.FAIL);
            JsonObject error=response.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(error), STATUS.INFO);

            String  errorr=error.get("message").getAsString();
            GemTestReporter.addTestStep("Error Message", errorr , STATUS.INFO);

        }
    }*/
