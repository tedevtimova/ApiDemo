package api.endpoints;

import Tests.CreateEmployee;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
public class PutRequests {

    private static String updateUrl = "https://dummy.restapiexample.com/api/v1/update/";

    public static HttpResponse updateEmployee() throws IOException {
        HttpPut httpPut = new HttpPut(updateUrl+ CreateEmployee.getId());
        httpPut.setHeader("Content-type", "text/html; charset=UTF-8");
        HttpClient httpClient = HttpClients.createDefault();
        String postBody = "{\"name\":\"Teodora\",\"salary\":\"4123\",\"age\":\"33\"}";
        StringEntity entity = new StringEntity(postBody);
        httpPut.setEntity(entity);
        HttpResponse response = httpClient.execute(httpPut);
        return response;

    }
}
