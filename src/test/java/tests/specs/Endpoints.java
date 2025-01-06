package tests.specs;

public class Endpoints {
    public static final String LOGIN = "/v1/user/sign-in";
    public static final String GET_TARIFF = "/v1/tickets/get-tariff?buy_id=";
    public static final String ORDER = "/v1/flight/order?sort=-id&page=1&include=passengers";
    public static final String CHECK = "/v1/flight/check?platform=web_b2c";
    public static final String BOOK = "/v1/flight/book?platform=web_b2c";
    public static final String SEARCH = "/v1/tickets/search?platform=web_b2c";
    public static final String GET_OFFERS = "/v1/tickets/get-offers?request_id=";
    public static final String GET_OFFERS_CR = "&pagination=true&platform=web_b2c&sort=price&only_baggage=0&page=1";
    public static final String SEARCH_ROOM = "/v1/hotel/rooms?platform=web_b2c";
}
