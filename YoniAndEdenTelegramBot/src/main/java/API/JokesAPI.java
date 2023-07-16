package API;

// המחלקה אינה מייבאת שום דבר כיוון שהיא משתמשת רק במחלקות שהוגדרו באותו החבילה.

public class JokesAPI {
    // הגדרת קבועים עבור כתובת ה-URL של ה-API והשדה שאנחנו רוצים לקבל מהתגובה.
    private static final String REQUEST_ADRESS = "https://v2.jokeapi.dev/joke/any";
    private static final String JSON_OBJECT_STRING = "setup";

    public JokesAPI() {
        // בנאי ריק.
    }

    // פונקציה סטטית שמחזירה בדיחה אקראית.
    public static String jokeAPI() {
        return ApiPath.generateAPI("https://v2.jokeapi.dev/joke/any", "setup");
    }
}
