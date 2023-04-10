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


public class GetMinCandle {

    String accessKey;
    String secretKey;
    String serverUrl;
    Algorithm algorithm;
    String jwtToken;
    String authenticationToken;

    public GetMinCandle(String acc, String sec) {
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

    public String getMinCandle(String market, String to, String count, String unit) {
        String output = "";

        try {
//          GET  https://api.upbit.com/v1/candles/minutes/{unit};
            String channel_API = "/v1/candles/minutes/";
            String param = channel_API + unit + "?" + "market=" + market + "&" + "count=" + count;

            HttpClient client = HttpClientBuilder.create().build();
//            HttpGet request = new HttpGet(serverUrl + "/v1/candles/minutes/30?market=KRW-BTC&count=1");
            HttpGet request = new HttpGet(serverUrl + param);
            request.setHeader("Content-Type", "application/json");
            request.addHeader("Authorization", authenticationToken);

            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();

            output = EntityUtils.toString(entity, "UTF-8");
//            System.out.println(EntityUtils.toString(entity, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }

//    public static void main(String[] args) {
//        PersonnelKey pk = new PersonnelKey();
//
//        String accessKey = pk.getAccKey();
//        String secretKey = pk.getSecKey();
//        String serverUrl = "https://api.upbit.com";
//
//        Algorithm algorithm = Algorithm.HMAC256(secretKey);
//        String jwtToken = JWT.create()
//                .withClaim("access_key", accessKey)
//                .withClaim("nonce", UUID.randomUUID().toString())
//                .sign(algorithm);
//
//        String authenticationToken = "Bearer " + jwtToken;
//
//        try {
//            HttpClient client = HttpClientBuilder.create().build();
//            HttpGet request = new HttpGet(serverUrl + "/v1/candles/minutes/30?market=KRW-BTC&count=1");
//            request.setHeader("Content-Type", "application/json");
//            request.addHeader("Authorization", authenticationToken);
//
//            HttpResponse response = client.execute(request);
//            HttpEntity entity = response.getEntity();
//
//            System.out.println(EntityUtils.toString(entity, "UTF-8"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}

