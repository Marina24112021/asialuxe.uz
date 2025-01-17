package specs;

public class Endpoints {
    public static final String LOGIN = "/v1/user/sign-in";
    public static final String GET_TARIFF = "/v1/tickets/get-tariff?buy_id=";
    public static final String ORDER = "/v1/flight/order?sort=-id&page=1&include=passengers";
    public static final String CHECK = "/v1/flight/check?platform=web_b2c";
    public static final String BOOK = "/v1/flight/book?platform=web_b2c";
    public static final String SEARCH = "/v1/tickets/search?platform=web_b2c";
    public static final String GET_OFFERS = "/v1/tickets/get-offers?request_id=";
    public static final String PREBOOK_TOUR = "v1/umrah/prebook?platform=web_b2c";
    public static final String GET_OFFERS_CR = "&pagination=true&platform=web_b2c&sort=price&only_baggage=0&page=1";
    public static final String NEW_PASSENGER = "/mobile/user-document";
    public static final String LIST_PASSENGERS = "/mobile/user-document?sort=1";
    public static final String DELETE_UPDATE_PASSENGER = "/mobile/user-document/";

    public static final String BASE_URL_BOOK_TOUR = "https://asialuxe.uz/ru/custom-tours/booking?";

    public static final String SECRET_FILE_PATH_FOR_BROWSERSTACK = "secretdata/browserstackcredentionals";
    public static final String SECRET_FILE_PATH_FOR_SELENOID = "secretdata/selenoidcredentionals";
    public static final String SECRET_FILE_PATH_FOR_ASIALUXE = "secretdata/credentialsasialuxe";
    public static final String SECRET_FILE_PATH_FOR_AUTHORIZATION = "secretdata/requestspecforauthorisation";

}
