package api.endpoints;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class PostRequests {

    private static String createEmployeeUrl = "https://dummy.restapiexample.com/api/v1/create";

    public static HttpResponse createEmployee() throws IOException {
        HttpPost postEmployees = new HttpPost(createEmployeeUrl);
        postEmployees.setHeader("Content-type", "text/html; charset=UTF-8");
        HttpClient httpClient = HttpClients.createDefault();
        String postBody = "{\"name\":\"Teddy\",\"salary\":\"4123\",\"age\":\"33\"}";
        try {
            StringEntity entity = new StringEntity(postBody);
            postEmployees.setEntity(entity);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpResponse response = httpClient.execute(postEmployees);
        return response;
    }
}
