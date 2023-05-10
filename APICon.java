import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class APICon {
    String key = "9517a5a1525a567ecbf9d4b2", convertFrom, url_str, convertTo;
    double amount;

    APICon(String convertFrom, String convertTo, double amount) {
        this.convertFrom = convertFrom;
        this.convertTo = convertTo;
        url_str = "https://v6.exchangerate-api.com/v6/" + key + "/latest/" + convertFrom;
        this.amount = amount;
    }

    public double makeConnection() throws IOException {
        double convertedAmount = 0;
        URL url = new URL(url_str);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            String responseData = response.toString();
            // System.out.println(responseData);

            JSONObject object = new JSONObject(responseData);
            Double exchangeRate = object.getJSONObject("conversion_rates").getDouble(convertTo);
            // System.out.println(object.getJSONObject("conversion_rates"));
            // System.out.println("\n\n" + exchangeRate);
            convertedAmount = amount * exchangeRate;

        } else {
            System.out.println("HTTP Request Failed: " + responseCode);
        }
        return convertedAmount;
    }

    public static void main(String[] args) throws IOException {
        double ans = new APICon("INR", "PKR", 10.0).makeConnection();
        System.out.println(ans);
    }
}
