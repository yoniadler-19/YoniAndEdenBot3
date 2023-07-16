package API;// מייבאים את ספריית Unirest, אשר מאפשרת שליחת בקשות HTTP.
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;

// מייבאים את ספריית JSON של Java, אשר מאפשרת לנו לפרסר וליצור מחרוזות JSON.
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiPath {
    // מגדירים קבוע שמייצג את הסטטוס של HTTP שנחשב לתקני.
    private static final int WORKING_STATUS = 200;

    public ApiPath() {
        // בנאי ריק.
    }

    // הפונקציה generateAPI מקבלת כתובת URL של API ומחרוזת שמציינת את השדה שאנחנו רוצים לקבל מהתגובה.
    public static String generateAPI(String requestAddress, String line) {
        String newString = "";

        try {
            // שולחים בקשת GET ל-API.
            GetRequest getRequest = Unirest.get(requestAddress);
            HttpResponse<String> response = getRequest.asString();

            // אם התגובה שקיבלנו היא תקנית...
            if (response.getStatus() == 200 || response.getStatus() == 201) {
                // מפרסרים את התגובה שקיבלנו מה-API.
                String json = (String)response.getBody();
                newString = parseFromJson(json, line);
                System.out.println(newString);
            }
        } catch (Exception var6) {
        }

        return newString;
    }

    // הפונקציה parseFromJson מקבלת מחרוזת של JSON ומחרוזת שמציינת את השדה שאנחנו רוצים לקבל.
    // היא מחזירה את הערך של השדה שמציין השדה שהתקבל.
    private static String parseFromJson(String jsonResponse, String line) {
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            if (line.equals("setup")) {
                if (jsonObject.has("joke")) {
                    return jsonObject.getString("joke");
                }

                if (jsonObject.has("setup")) {
                    String temp = jsonObject.getString("setup");
                    temp = temp + " " + jsonObject.getString("delivery");
                    return temp;
                }
            } else if (jsonObject.has(line)) {
                return jsonObject.getString(line);
            }
        } catch (JSONException var4) {
            var4.printStackTrace();
        }

        return null;
    }

    // generateTrivia דומה ל- generateAPI, אך היא מצפה לתגובה שמכילה מערך של תוצאות.
    // היא מחזירה את השאלה והתשובה לשאלה הראשונה במערך.
    public static String generateTrivia(String requestAddress, String line) {
        String joke = "";

        try {
            GetRequest getRequest = Unirest.get(requestAddress);
            HttpResponse<String> response = getRequest.asString();
            if (response.getStatus() == 200 || response.getStatus() == 201) {
                String json = (String)response.getBody();
                joke = parseTrivia(json, line);
                System.out.println(joke);
            }
        } catch (Exception var6) {
        }

        return joke;
    }

    // parseTrivia מקבלת מחרוזת של JSON ומחרוזת שמציינת את השדה שאנחנו רוצים לקבל.
    // היא מחזירה את השאלה והתשובה לשאלה הראשונה במערך של תוצאות.
    private static String parseTrivia(String jsonResponse, String line) {
        String temp = "";

        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONArray results = jsonObject.getJSONArray("results");
            if (results.length() > 0) {
                JSONObject triviaObject = results.getJSONObject(0);
                if (line.equals("question")) {
                    temp = triviaObject.getString("question") + "\n";
                    temp = temp + "The answer is: \n";
                    temp = temp + triviaObject.getString("correct_answer");
                } else {
                    System.out.println("No trivia question found in the response.");
                }

                return temp;
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return null;
    }

    // פונקציה שמקבלת כתובת של API ושולחת לה בקשת GET.
    // היא מחזירה את גוף התגובה שהיא מקבלת מה-API.
    public static String emptyAPI(String REQUEST_ADDRESS) {
        String tempString = "";

        try {
            GetRequest getRequest = Unirest.get(REQUEST_ADDRESS);
            HttpResponse<String> response = getRequest.asString();
            if (response.getStatus() == 200 || response.getStatus() == 201) {
                tempString = (String)response.getBody();
                System.out.println(tempString);
            }
        } catch (Exception var4) {
        }

        return tempString;
    }
}
