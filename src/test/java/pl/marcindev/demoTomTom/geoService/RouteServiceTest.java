package pl.marcindev.demoTomTom.geoService;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import pl.marcindev.demoTomTom.entity.*;

import static org.junit.jupiter.api.Assertions.*;

class RouteServiceTest {

    private final String baseUrl = "https://api.tomtom.com";
    private WebClient webClient = WebClient.create(baseUrl);
    RouteService routeService = new RouteService(webClient);
    Locations startLocations = new Locations(49.70537f,19.23082f);
    Locations destinationLocations = new Locations(49.82226f,19.05514f);

    LocationsConverter locationsConverter = new LocationsConverter(startLocations, destinationLocations);
//"lat": 49.70537,
//        "lon": 19.23082

//    "lat": 49.82226,
//        "lon": 19.05514
    @Test
    void getRoute() {
        System.out.println(locationsConverter);
        System.out.println(startLocations);
        System.out.println(destinationLocations);
        APITomTomRouting apiTomTomRouting = new APITomTomRouting(TravelMode.car, RouteType.fastest, locationsConverter, 1, true);
        Route response = routeService.getRoute(apiTomTomRouting);

        int length = response.getSummary().getLengthInMeters();
        System.out.println(length);


        assertTrue(true);

    }
}