package API;
import API.ApiPath;
// המחלקה אינה מייבאת שום דבר כיוון שהיא משתמשת רק במחלקות שהוגדרו באותו החבילה.

public class CatFactAPI {
    // הגדרת קבועים עבור כתובת ה-URL של ה-API והשדה שאנחנו רוצים לקבל מהתגובה.
    private static final String REQUEST_ADRESS = "https://catfact.ninja/fact?max_length=140";
    private static final String JSON_OBJECT_STRING = "fact";

    public CatFactAPI() {
        // בנאי ריק.
    }

    // פונקציה סטטית שמחזירה עובדה אקראית על חתול מה-API.
    public static String catFactAPI() {
        return ApiPath.generateAPI("https://catfact.ninja/fact?max_length=140", "fact");


    }
}
