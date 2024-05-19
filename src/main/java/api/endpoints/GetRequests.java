package api.endpoints;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;

public class GetRequests {

    private static String viewEmployeesUrl = "https://dummy.restapiexample.com/api/v1/employees";

    public static HttpResponse getEmployees() throws IOException {
        HttpGet getEmployees = new HttpGet(viewEmployeesUrl);
        getEmployees.setHeader("Content-type", "application/json");
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse httpResponse = httpClient.execute(getEmployees);

     return httpResponse;
    }
}


