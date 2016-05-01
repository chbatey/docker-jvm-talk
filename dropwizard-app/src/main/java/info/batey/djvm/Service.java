package info.batey.djvm;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;

@Path("/")
public class Service {

    private final HttpClient httpClient;

    public Service(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @GET
    @Path("/callout")
    public String callout() throws IOException {
        HttpGet httpGet = new HttpGet("http://wiremock:7070/name");
        return EntityUtils.toString(httpClient.execute(httpGet).getEntity());
    }
}
