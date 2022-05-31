
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import jdk.jshell.Snippet;
import com.gemini.apitest.ApiClientConnect;
import com.gemini.apitest.ProjectApiUrl;
import com.gemini.apitest.ProjectSampleJson;

import com.gemini.dataProvider.QuanticDataProvider;
import com.gemini.generic.QuanticAPIBase;
import com.gemini.quartzReporting.GemTestReporter;
import com.gemini.quartzReporting.STATUS;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import org.testng.annotations.Test;

public class Postgem extends QuanticAPIBase {
    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Postgem(JsonObject inputData) {

        GemTestReporter.addTestStep("Test Case", "Test to check the Post function ", STATUS.INFO);
        String url = ProjectApiUrl.getUrl("posters");
        GemTestReporter.addTestStep("Url for Post Request", url, STATUS.INFO);

        JsonObject payload = ProjectSampleJson.getSampleData("NewJson5_sampleJson").getAsJsonObject();
        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        JsonObject res = null;

        try {
            res = ApiClientConnect.postRequest(url, String.valueOf(payload), "json");
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Executed Successfully", STATUS.PASS);
        } catch (Exception e) {
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Did not Executed Successfully", STATUS.FAIL);
        }
        System.out.println(res);

        int status = res.get("status").getAsInt();
        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);
        if (status == 201) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.PASS);
            JsonObject body = res.get("responseBody").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            String message = body.get("message").toString();
            GemTestReporter.addTestStep("Final Message", message, STATUS.PASS);

        } else {
            JsonObject body = res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.FAIL);
            String me = body.get("message").toString();
            GemTestReporter.addTestStep("Reason of rejection", me, STATUS.INFO);
            String l = body.get("operation").toString();
            GemTestReporter.addTestStep("Final Message", l, STATUS.FAIL);


        }

    }


    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Postgem_alreadypresent(JsonObject inputData) {

        GemTestReporter.addTestStep("Test Case", "Test to check the Post function ", STATUS.INFO);
        String url = ProjectApiUrl.getUrl("posters");
        GemTestReporter.addTestStep("Url for Post Request", url, STATUS.INFO);

        JsonObject payload = ProjectSampleJson.getSampleData("NewJson_sampleJson").getAsJsonObject();
        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        JsonObject res = null;

        try {
            res = ApiClientConnect.postRequest(url, String.valueOf(payload), "json");
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Executed Successfully", STATUS.PASS);
        } catch (Exception e) {
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Did not Executed Successfully", STATUS.FAIL);
        }
        System.out.println(res);

        int status = res.get("status").getAsInt();
        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);
        if (status == 201) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.PASS);
            JsonObject body = res.get("responseBody").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            String message = body.get("message").toString();
            GemTestReporter.addTestStep("Final Message", message, STATUS.PASS);

        } else {
            JsonObject body = res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.FAIL);
            String me = body.get("message").toString();
            GemTestReporter.addTestStep("Reason of rejection", me, STATUS.INFO);
            String l = body.get("operation").toString();
            GemTestReporter.addTestStep("Final Message", l, STATUS.FAIL);


        }

    }

    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Postgem_sid_notpresent(JsonObject inputData) {

        GemTestReporter.addTestStep("Test Case", "Test to check the Post function ", STATUS.INFO);
        String url = ProjectApiUrl.getUrl("posters");
        GemTestReporter.addTestStep("Url for Post Request", url, STATUS.INFO);

        JsonObject payload = ProjectSampleJson.getSampleData("NewJson3_sampleJson").getAsJsonObject();
        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        JsonObject res = null;

        try {
            res = ApiClientConnect.postRequest(url, String.valueOf(payload), "json");
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Executed Successfully", STATUS.PASS);
        } catch (Exception e) {
            GemTestReporter.addTestStep(" Post Request Verification ", "Post Request Did not Executed Successfully", STATUS.FAIL);
        }
        System.out.println(res);

        int status = res.get("status").getAsInt();
        GemTestReporter.addTestStep("Status ", String.valueOf(status), STATUS.INFO);
        if (status == 201) {
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.PASS);
            JsonObject body = res.get("responseBody").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            String message = body.get("message").toString();
            GemTestReporter.addTestStep("Final Message", message, STATUS.PASS);

        } else {
            JsonObject body = res.get("responseError").getAsJsonObject();
            GemTestReporter.addTestStep("Response Body", String.valueOf(body), STATUS.INFO);
            GemTestReporter.addTestStep("Status Verification", "Expected Status : 201", STATUS.FAIL);
            String me = body.get("message").toString();
            GemTestReporter.addTestStep("Reason of rejection", me, STATUS.INFO);
            String l = body.get("operation").toString();
            GemTestReporter.addTestStep("Final Message", l, STATUS.FAIL);


        }

    }
}
