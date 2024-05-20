package Tests;

import Helpers.ResponseReader;
import api.endpoints.GetRequests;
import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetEmployees {

    @Test
    public static void testGetEmployees() throws IOException {

        HttpResponse httpResponse = GetRequests.getEmployees();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is not 200");
        String responseBody = ResponseReader.convertStreamToString(httpResponse.getEntity().getContent());
        Assert.assertTrue(responseBody.contains("success"));
        System.out.println("Response body: " + responseBody);
    }
}
