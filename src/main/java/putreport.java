
import com.google.gson.JsonArray;
import com.gemini.apitest.ApiClientConnect;
import com.gemini.apitest.ProjectApiUrl;
import com.gemini.apitest.ProjectSampleJson;

import com.gemini.dataProvider.QuanticDataProvider;
import com.gemini.generic.QuanticAPIBase;
import com.gemini.quartzReporting.GemTestReporter;
import com.gemini.quartzReporting.STATUS;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import jdk.jshell.Snippet;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import org.testng.annotations.Test;

public class putreport extends QuanticAPIBase {
    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void Putgemreport(JsonObject inputData) {

        GemTestReporter.addTestStep("Test Case", "Test to check the Put function ", STATUS.INFO);
        String url = ProjectApiUrl.getUrl("put");
        GemTestReporter.addTestStep("Url for Put Request", url, STATUS.INFO);

        JsonObject payload = ProjectSampleJson.getSampleData("NewJson_sampleJson").getAsJsonObject();
        GemTestReporter.addTestStep("Payload ", String.valueOf(payload), STATUS.INFO);

        JsonObject res = null;

        try {
            res = ApiClientConnect.putRequestWithReporting("url of the put request ", url, String.valueOf(payload), "json");

        } catch (Exception e) {
            GemTestReporter.addTestStep(" Put Request Verification ", "Put Request Did not Executed Successfully", STATUS.FAIL);
        }
        System.out.println(res);


    }
}