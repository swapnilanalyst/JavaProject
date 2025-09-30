package utils;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class CaptchaSolver {

    private static final String API_KEY = "YOUR_2CAPTCHA_API_KEY";  // Replace with your API key
    private static final String API_URL = "http://2captcha.com/in.php";

    public static String solveCaptcha(File captchaImage) {
        try {
            // Convert CAPTCHA image to Base64 encoding
            String base64Image = encodeImageToBase64(captchaImage);
            
            // Send request to 2Captcha API
            String response = sendCaptchaRequest(base64Image);
            if (response.contains("OK|")) {
                String captchaId = response.split("\\|")[1];
                // Get the result after some delay
                return getCaptchaResult(captchaId);
            } else {
                System.err.println("Error in CAPTCHA request: " + response);
                return "";
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String encodeImageToBase64(File captchaImage) throws IOException {
        InputStream imageInputStream = new FileInputStream(captchaImage);
        byte[] bytes = imageInputStream.readAllBytes();
        return Base64.getEncoder().encodeToString(bytes);
    }

    private static String sendCaptchaRequest(String base64Image) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(API_URL);

        // Prepare POST request with CAPTCHA data
        String jsonPayload = "{\"key\":\"" + API_KEY + "\", \"body\":\"" + base64Image + "\", \"method\":\"base64\", \"json\":1}";

        StringEntity entity = new StringEntity(jsonPayload);
        post.setEntity(entity);
        post.setHeader("Content-Type", "application/json");

        HttpResponse response = client.execute(post);
        String responseString = EntityUtils.toString(response.getEntity());
        client.close();
        return responseString;
    }

    private static String getCaptchaResult(String captchaId) throws IOException {
        String resultUrl = "http://2captcha.com/res.php?key=" + API_KEY + "&action=get&id=" + captchaId + "&json=1";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(resultUrl);

        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity());
        client.close();

        if (result.contains("OK|")) {
            return result.split("\\|")[1]; // Captcha result
        } else {
            System.err.println("Captcha not solved yet. Waiting for 30 seconds...");
            try {
                Thread.sleep(30000);  // Wait for 30 seconds before retrying
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return getCaptchaResult(captchaId);  // Retry after wait
        }
    }
}
