package cmn.callAPI;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.UUID;


public class GetOrderBook {

    String accessKey;
    String secretKey;
    String serverUrl;
    Algorithm algorithm;
    String jwtToken;
    String authenticationToken;
//    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(callAPI.GetOrderBook.class);

    public GetOrderBook(String acc, String sec) {
        accessKey = acc;
        secretKey = sec;
        serverUrl = "https://api.upbit.com";
    }

    public void init() {
        algorithm = Algorithm.HMAC256(secretKey);
        jwtToken = JWT.create().withClaim("access_key", accessKey)
                .withClaim("nonce", UUID.randomUUID().toString())
                .sign(algorithm);
        authenticationToken = "Bearer " + jwtToken;

//        public void doSomething() {
//            LOGGER.debug("Debug log message");
//            LOGGER.info("Info log message");
//            LOGGER.warn("Warn log message");
//            LOGGER.error("Error log message");
//        }
    }

    public String getOrderBook(String market) {
        String output = "";

        String channel_API = "/v1/orderbook/";
        String param = channel_API + "?" + "markets=" + market;

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(serverUrl + param);
        CloseableHttpResponse httpResponse = null;

        try {
            httpResponse = httpClient.execute(httpGet);
//            System.out.println("[HTTP RES ENTITY] : " + EntityUtils.toString(httpResponse.getEntity()));

            Header[] allHeaders = httpResponse.getAllHeaders();
            for (Header allHeader : allHeaders) {
                System.out.println("[HTTP RES HEADER] : " + allHeader.toString());
//                LOGGER.info("[HTTP RES HEADER] : " + allHeader.toString());
            }

            output = EntityUtils.toString(httpResponse.getEntity());
            httpResponse.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }
}
