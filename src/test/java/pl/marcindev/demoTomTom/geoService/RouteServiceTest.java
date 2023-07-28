package pl.marcindev.demoTomTom.geoService;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import pl.marcindev.demoTomTom.entity.tomtomgeocoding.model.Position;
import pl.marcindev.demoTomTom.entity.tomtomgeocoding.model.PositionsConverter;
import pl.marcindev.demoTomTom.entity.tomtomrouting.model.RouteData;
import pl.marcindev.demoTomTom.entity.tomtomrouting.model.RouteType;
import pl.marcindev.demoTomTom.entity.tomtomrouting.model.RouteAnswer;
import pl.marcindev.demoTomTom.entity.tomtomrouting.model.TravelMode;
import pl.marcindev.demoTomTom.geoService.routingservice.RouteService;

import static org.junit.jupiter.api.Assertions.*;

class RouteServiceTest {

    private final String baseUrl = "https://api.tomtom.com";

    private WebClient webClient = WebClient.create(baseUrl);
    private ObjectMapperConverter objectMapperConverter = new ObjectMapperConverter();
    RouteService routeService = new RouteService(webClient);
    Position startLocations = new Position(49.70537f, 19.23082f);
    Position destinationLocations = new Position(49.82226f, 19.05514f);

    PositionsConverter positionsConverter = new PositionsConverter(startLocations, destinationLocations);
//"lat": 49.70537,
//        "lon": 19.23082

    //    "lat": 49.82226,
//        "lon": 19.05514
    @Test
    void getRoute() throws Exception {
        //given
        System.out.println(positionsConverter);
        System.out.println(startLocations);
        System.out.println(destinationLocations);
        RouteData routeData = new RouteData(TravelMode.car, RouteType.fastest, positionsConverter, 1, true);
        String response = routeService.getRoute(routeData).block();

        JsonNode node = objectMapperConverter.parser(response);
        RouteAnswer ans = objectMapperConverter.convertFromJsonToObject(node, RouteAnswer.class);
        System.out.println(ans.getRoutes().get(0).getSummary().getLengthInMeters());
        System.out.println(ans.getRoutes().get(0).getSummary().getTrafficDelayInSeconds());


        assertTrue(true);

    }
}