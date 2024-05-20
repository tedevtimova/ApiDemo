package Tests;

import Helpers.ResponseReader;
import api.endpoints.PutRequests;
import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;

public class UpdateEmployee {

    @Test

    public static void testUpdateEmployee() throws IOException {
        HttpResponse httpResponse = PutRequests.updateEmployee();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is not 200");
        String responseBody = ResponseReader.convertStreamToString(httpResponse.getEntity().getContent());
        System.out.println("Response body: " + responseBody);
        Assert.assertTrue(responseBody.contains("Successfully! Record has been updated."));

    }
}
