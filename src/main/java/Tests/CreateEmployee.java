package Tests;

import Helpers.ResponseReader;
import api.endpoints.PostRequests;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateEmployee {

    private static String id;

    @Test

    public static void testCreateEmployee() throws IOException {
        HttpResponse response = PostRequests.createEmployee();
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is not 200");
        String responseBody = ResponseReader.convertStreamToString(response.getEntity().getContent());
        System.out.println("Response body: " + responseBody);
        Pattern pattern = Pattern.compile("\"id\":(\\d+)");
        Matcher matcher = pattern.matcher(responseBody);
        if (matcher.find()) {
            id = matcher.group(1);
            System.out.println("ID = " + id);
        } else {
            System.out.println("ID not found");
        }
    }

    public static String getId() {
        return id;
    }
}
