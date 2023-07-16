package API;

// המחלקה אינה מייבאת שום דבר כיוון שהיא משתמשת רק במחלקות שהוגדרו באותו החבילה.

public class ipAPI {
    // הגדרת קבועים עבור כתובת ה-URL של ה-API והשדה שאנחנו רוצים לקבל מהתגובה.
    private static final String REQUEST_ADRESS = "https://api.ipify.org/?format=json";
    private static final String JSON_OBJECT_STRING = "ip";

    public ipAPI() {
        // בנאי ריק.
    }

    // פונקציה סטטית שמחזירה את כתובת ה-IP של המשתמש.
    public static String ipAPI() {
        return ApiPath.generateAPI("https://api.ipify.org/?format=json", "ip");
    }
}

