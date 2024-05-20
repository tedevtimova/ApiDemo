package api.endpoints;

import Tests.CreateEmployee;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class DeleteRequests {

    private static String updateUrl = "https://dummy.restapiexample.com/api/v1/delete/";

    public static HttpResponse deleteEmployee() throws IOException {
        HttpDelete httpDelete = new HttpDelete(updateUrl + CreateEmployee.getId());
        httpDelete.setHeader("Content-type", "application/json");
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse httpResponse = httpClient.execute(httpDelete);

        return httpResponse;
    }

}
