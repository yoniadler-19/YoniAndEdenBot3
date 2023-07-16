package API;

// המחלקה אינה מייבאת שום דבר כיוון שהיא משתמשת רק במחלקות שהוגדרו באותו החבילה.

public class NumbersFactAPI {
    // הגדרת קבועים עבור כתובת ה-URL של ה-API.
    private static final String REQUEST_ADRESS = "http://numbersapi.com/random";

    public NumbersFactAPI() {
        // בנאי ריק.
    }

    // פונקציה סטטית שמחזירה עובדה אקראית על מספר.
    public static String NumbersFactAPI() {
        return ApiPath.emptyAPI("http://numbersapi.com/random");
    }
}
