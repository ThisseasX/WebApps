import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        try {
            String urlString = "http://localhost:8082/SpringTest_war_exploded/all";
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");

            if (con.getResponseCode() != 200) {
                throw new RuntimeException("Failed - HTTP ERROR CODE = " + con.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String output;
            System.out.println("Output from Server...\n");
//            while ((output = br.readLine()) != null) {
//                result.append(output);
//            }

//            System.out.println(result.toString());

            Gson gson = new Gson();

//            JsonElement jelement = new JsonParser().parse(result.toString());
//            JsonArray entries = (JsonArray) new JsonParser().parse(br);
//            gson.fromJson(br, User.class);
//            jsonArray.get

//            jsonArray = jsonArray.getAsJsonObject("horoscope");
//            JsonArray jarray = jobject.getAsJsonArray("translations");
//            jobject = jarray.get(0).getAsJsonObject();
//            String res = jsonArray.get("translatedText").getAsString();


//            User[] uu = gson.fromJson(br, User[].class);


//            List<JsonElement> list = new ArrayList<>();
            JsonArray array = (JsonArray) new JsonParser().parse(br);

            for (JsonElement jsonElement : array) {
                for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    System.out.printf("%s: %s%n", entry.getKey(), entry.getValue());
                }
            }

//            for (JsonElement jsonElement : list) {
//                Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
//                for (Map.Entry<String, JsonElement> entry : entries) {
//                    System.out.printf("%s: %s%n", entry.getKey(), entry.getValue());
//                }
//            }


//            System.out.println(list);
//            for (User user : uu) {
//                System.out.printf("User #%s, Name: %s, Surname: %s%n", user.getId(), user.getName(), user.getSurname());
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
