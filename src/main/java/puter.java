
import com.google.gson.JsonObject;

import org.testng.annotations.Test;
import com.gemini.apitest.ApiClientConnect;
import com.gemini.apitest.ProjectApiUrl;
import com.gemini.apitest.ProjectSampleJson;

import com.gemini.dataProvider.QuanticDataProvider;
import com.gemini.generic.QuanticAPIBase;
import com.gemini.quartzReporting.GemTestReporter;
import com.gemini.quartzReporting.STATUS;

public class puter extends QuanticAPIBase {
    @Test(dataProvider = "QuanticDataProvider", dataProviderClass = QuanticDataProvider.class)
    public void put_function(JsonObject inputElement)
    {
        String url=ProjectApiUrl.getUrl("puter");
        GemTestReporter.addTestStep("Test Case", "Test to check the Put Request", STATUS.INFO);
        GemTestReporter.addTestStep("URL for POST request", url, STATUS.INFO);
        JsonObject payload = ProjectSampleJson.getSampleData("NewJson_sampleJson").getAsJsonObject();
        GemTestReporter.addTestStep("Payload of the Post Request", String.valueOf(payload), STATUS.INFO);
        JsonObject response=null;
        try
        {
            GemTestReporter.addTestStep("PUT request Verification", "Put request executed successfully", STATUS.PASS);
        }
        catch(Exception e)
        {
            GemTestReporter.addTestStep("PUT request Verification", "Put request Did not executed successfully", STATUS.FAIL);
        }
        int status = response.get("status").getAsInt();
        if (status==200) {
            GemTestReporter.addTestStep("Status verification", "Expected Status:200 ,Status we are getting:"+status, STATUS.PASS);
            JsonObject body=response.get("responseBody").getAsJsonObject();
            GemTestReporter.addTestStep("response body", String.valueOf(body), STATUS.INFO);
            System.out.println(response);
            String responseMessage = response.get("responseMessage").getAsString();
            System.out.println(responseMessage);
            if(responseMessage.equalsIgnoreCase("OK"))
            {
                GemTestReporter.addTestStep("Checking response message", responseMessage, STATUS.PASS);
            }
            else
            {
                GemTestReporter.addTestStep("Checking response message", responseMessage, STATUS.FAIL);

            }

        }
        else
        {
            GemTestReporter.addTestStep("Status verification", "Expected Status:200 , Status we are getting :"+status, STATUS.FAIL);
        }


    }
}
