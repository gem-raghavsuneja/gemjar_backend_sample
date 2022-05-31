
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import com.gemini.apitest.ApiClientConnect;
import com.gemini.apitest.ProjectApiUrl;
import com.gemini.apitest.ProjectSampleJson;

import com.gemini.dataProvider.QuanticDataProvider;
import com.gemini.generic.QuanticAPIBase;
import com.gemini.quartzReporting.GemTestReporter;
import com.gemini.quartzReporting.STATUS;

import jdk.jshell.Snippet;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.HashMap;
public class Anshul1 extends QuanticAPIBase {
    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Geting(JsonObject inputData) {
        GemTestReporter.addTestStep("Test Case", "Test to check the Get API", STATUS.INFO);
        String url = ProjectApiUrl.getUrl("Get");
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
            GemTestReporter.addTestStep("Status Verification", "Expected Status: 200" + status, STATUS.PASS);
            GemTestReporter.addTestStep("Response Body", String.valueOf(response), STATUS.INFO);

        }
    }



    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Geting_sidnotpresent(JsonObject inputData) {
        GemTestReporter.addTestStep("Test Case", "Test to check the Get API", STATUS.INFO);
        String url = ProjectApiUrl.getUrl("Get1");
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
            GemTestReporter.addTestStep("Response Body", String.valueOf(response), STATUS.INFO);
JsonObject error=response.get("responseError").getAsJsonObject();
String  errorr=error.get("message").getAsString();
            GemTestReporter.addTestStep("Error Message", errorr , STATUS.INFO);

        }
    }
}