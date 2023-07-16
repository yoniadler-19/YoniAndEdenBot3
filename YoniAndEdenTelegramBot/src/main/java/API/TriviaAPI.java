package API;

// המחלקה אינה מייבאת שום דבר כיוון שהיא משתמשת רק במחלקות שהוגדרו באותו החבילה.

public class TriviaAPI {
    // הגדרת קבועים עבור כתובת ה-URL של ה-API והשדה שאנחנו רוצים לקבל מהתגובה.
    private static final String REQUEST_ADRESS = "https://opentdb.com/api.php?amount=1";
    private static final String JSON_OBJECT_STRING = "question";

    public TriviaAPI() {
        // בנאי ריק.
    }

    // פונקציה סטטית שמחזירה שאלת טריוויה אקראית.
    public static String TriviaAPI() {
        return ApiPath.generateTrivia("https://opentdb.com/api.php?amount=1", "question");
    }
}

