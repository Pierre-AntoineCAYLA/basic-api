package b.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest  extends TestCase
{
    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    public AppTest( String testName ){
        super( testName );
    }

   
    public void testSimple(){
        HttpGet httpGet = new HttpGet("http://localhost:9998/a/b/c");
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (response.getEntity() != null) {
                String content = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
                        .lines().collect(Collectors.joining("\n"));
                assertTrue(content.equals("Hello !"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
    
    public void testName(){
        HttpGet httpGet = new HttpGet("http://localhost:9998/a/b/you");
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (response.getEntity() != null) {
                String content = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
                        .lines().collect(Collectors.joining("\n"));
                assertTrue(content.equals("Hello you !"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
    
    public void testBye(){
        HttpGet httpGet = new HttpGet("http://localhost:9998/a/b/d?username=me");
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (response.getEntity() != null) {
                String content = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
                        .lines().collect(Collectors.joining("\n"));
                assertTrue(content.equals("Bye me !"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
