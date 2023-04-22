package cmn.callAPI;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import personnelPack.PersonnelKey;

import java.io.IOException;
import java.util.UUID;

public class GetTicker {

    String accessKey;
    String secretKey;
    String serverUrl;
    Algorithm algorithm;
    String jwtToken;
    String authenticationToken;

    public GetTicker(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.serverUrl = "https://api.upbit.com";
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

    public String getTicker(String markets) {
        String output = "";

        String channel_API = "/v1/ticker";
        String param = channel_API + "?markets=" + markets;

        System.out.println(serverUrl + param);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(serverUrl + param);
        CloseableHttpResponse httpResponse = null;

        try {
            httpResponse = httpClient.execute(httpGet);
            Header[] allHeaders = httpResponse.getAllHeaders();
            for (Header allHeader : allHeaders) {
                System.out.println("[HTTP RES HEADER] : " + allHeader.toString());
            }

            output = EntityUtils.toString(httpResponse.getEntity());
            httpResponse.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static void main(String[] args) {
        PersonnelKey key = new PersonnelKey();

        GetTicker getTicker = new GetTicker(key.getAccKey(), key.getSecKey());
        getTicker.init();
        String ticker = getTicker.getTicker("KRW-BTC");

        System.out.println(ticker);
    }
}
