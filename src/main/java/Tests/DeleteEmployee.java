package Tests;

import Helpers.ResponseReader;
import api.endpoints.DeleteRequests;
import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteEmployee {

    @Test
    public static void testDeleteEmployee() throws IOException {
        HttpResponse httpResponse = DeleteRequests.deleteEmployee();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is not 200");
        String responseBody = ResponseReader.convertStreamToString(httpResponse.getEntity().getContent());
        Assert.assertTrue(responseBody.contains("Successfully! Record has been deleted"));
    }
}
