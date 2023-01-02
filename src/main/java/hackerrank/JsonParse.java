package hackerrank;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JsonParse {
    public static void main(String[] args) {
        System.out.println(getRestResponseCount(Arrays.asList("username", "EQUAL", "Dharmadhar55")));
        System.out.println(getRestResponseCount(Arrays.asList("address.city", "IN", "Mumbai,Kolkata")));
        System.out.println(getRestResponseCount(Arrays.asList("address.geo.lng", "IN", "91.8006")));
    }

    private static List<Integer> getRestResponseCount(List<String> input) {
        List<Integer> output = new ArrayList<>();

        // Extract input and prepare simple values
        String[] tokenizedField = input.get(0).split("\\.");;
        String[] valueArray = input.get(2).split(",");

        try {
            // Call URL and get the response
            URL url = new URL("https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Accept", "application/json");

            String responseJson = "";
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                responseJson += scanner.next();
            }

            // Parse top Level JsonArray as List of JsonObjects
            Gson gson = new Gson();
            List<JsonObject> jsonObjectList = gson.fromJson(responseJson, new TypeToken<List<JsonObject>>() {
            }.getType());

            for (JsonObject object : jsonObjectList) {
                Map<String, JsonElement> objectMap = gson.fromJson(object, new TypeToken<Map<String, JsonElement>>() {
                }.getType());
                int id = Integer.parseInt(objectMap.get("id").toString());

                for (int j = 0; j < tokenizedField.length; j++) {
                    String jsonKey = tokenizedField[j];
                    JsonElement jsonKeyValue = objectMap.get(jsonKey);

                    if (jsonKeyValue == null) {
                        break; // break to check next document, goto uppermost FOR loop
                    } else if (j < (tokenizedField.length - 1)) {
                        // Not the leaf key, continue traversing, Get the objectMap updated
                        objectMap = gson.fromJson(jsonKeyValue.toString(), new TypeToken<Map<String, JsonElement>>() {}.getType());
                        continue;
                    }

                    if(Arrays.stream(valueArray).anyMatch(jsonKeyValue.getAsString()::equals)) {
                        output.add(id);
                    }
                }
            }
        } catch (Exception ioe) {
            System.out.println(ioe);
        }

        if(output.size() == 0) {
            output.add(-1);
        }
        return output;
    }
}
