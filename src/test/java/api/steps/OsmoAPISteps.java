package api.steps;

import api.ApiClient;
import com.appium.util.Constants;
import com.appium.util.GmailOTPReader;
import com.appium.util.URLS;
import io.appium.java_client.clipboard.HasClipboard;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OsmoAPISteps {

    ApiClient apiClient = new ApiClient("https://stg.api.osmowallet.com");


    public Map<String, BigDecimal> getWallets() throws Exception {
        String loginPayload = "{\n" +
                "  \"input\": \"alara@singularagency.co\",\n" +
                "  \"grantType\": \"password\",\n" +
                "  \"clientId\": \"" + Constants.CLIENT_ID + "\",\n" +
                "  \"clientSecret\": \"" + Constants.CLIENT_SECRET + "\"\n" +
                "}";
        Response postResponse = apiClient.post(URLS.USER_AUTH_URL, loginPayload);
        Thread.sleep(10000);
        GmailOTPReader reader = new GmailOTPReader();
        String otp = reader.getLatestOTP();
        Assert.assertNotNull("OTP was not found in the email inbox.", otp);
        String authPayload = "{\n" +
                "  \"input\": \"alara@singularagency.co\",\n" +
                "  \"otp\": \"" + otp + "\",\n" +
                "  \"clientId\": \"" + Constants.CLIENT_ID + "\",\n" +
                "  \"clientSecret\": \"" + Constants.CLIENT_SECRET + "\"\n" +
                "}";
        Response authResponse = apiClient.post(URLS.OTP_AUTH_URL,authPayload);
        Assert.assertEquals(authResponse.getStatusCode(), 201);
        String token = authResponse.jsonPath().getString("accessToken");
        String bearerToken = "Bearer " + token;
        Response walletResponse = apiClient.get(URLS.WALLET_URL, token);
        Assert.assertEquals(walletResponse.getStatusCode(),200);
        JsonPath jsonPath = walletResponse.jsonPath();
        List<String> coinNames = jsonPath.getList("coin.name");
        List<Number> balances = jsonPath.getList("balance"); // Use Number instead of Float
        // Store in a Map <CoinName, Double>
        Map<String, BigDecimal> balanceMap = new HashMap<>();
        for (int i = 0; i < coinNames.size(); i++) {
            balanceMap.put(coinNames.get(i), new BigDecimal(balances.get(i).toString()));
        }
        return balanceMap;
    }
}
