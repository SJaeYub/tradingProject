package cmn.callAPI;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.UUID;

public class GetMarketCodes {

    String accessKey;
    String secretKey;
    String serverUrl;
    Algorithm algorithm;
    String jwtToken;
    String authenticationToken;

    public GetMarketCodes(String acc, String sec) {
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
    }

    public String getMarketCodes(boolean isDetail) {

        String output = "";

        try {
//        GET        https://api.upbit.com/v1/market/all
            String channel_API = "/v1/market/all";
            String param = channel_API + "?" + "isDetail=" + isDetail;

            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(serverUrl + param);
            request.setHeader("Content-Type", "application/json");
            request.addHeader("Authorization", authenticationToken);

            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();

            output = EntityUtils.toString(entity, "UTF-8");
        }catch(IOException e) {
            e.printStackTrace();
        }

        return output;
    }
}
