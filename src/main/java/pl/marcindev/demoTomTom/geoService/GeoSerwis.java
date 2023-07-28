package pl.marcindev.demoTomTom.geoService;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.reactive.function.client.WebClient;
import pl.marcindev.demoTomTom.entity.tomtomrouting.model.TravelMode;
import pl.marcindev.demoTomTom.entity.tomtomgeocoding.model.AddressData;
import pl.marcindev.demoTomTom.entity.tomtomgeocoding.model.GeocodingAnswer;
import pl.marcindev.demoTomTom.entity.tomtomgeocoding.model.Position;
import pl.marcindev.demoTomTom.entity.tomtomgeocoding.model.PositionsConverter;
import pl.marcindev.demoTomTom.geoService.geocodingservice.AddressConvService;
import pl.marcindev.demoTomTom.entity.tomtomrouting.model.RouteAnswer;
import pl.marcindev.demoTomTom.entity.tomtomrouting.model.RouteData;
import pl.marcindev.demoTomTom.entity.tomtomrouting.model.RouteType;
import pl.marcindev.demoTomTom.geoService.routingservice.RouteService;

public class GeoSerwis {
    private final String baseUrl = "https://api.tomtom.com";
    private WebClient webClient = WebClient.create(baseUrl);
    AddressConvService addressConvService = new AddressConvService(webClient);
    RouteService routeService = new RouteService(webClient);
    ObjectMapperConverter objectMapperConverter = new ObjectMapperConverter();

    public GeocodingAnswer getLocationFromAddress(AddressData addressData) throws Exception {
        String coordinates = addressConvService.getCoordinates(addressData).block();
        JsonNode node = objectMapperConverter.parser(coordinates);
        return objectMapperConverter.convertFromJsonToObject(node, GeocodingAnswer.class);

    }

    public RouteAnswer findRoute(RouteData routeData) throws Exception {
        String jSonString = routeService.getRoute(routeData).block();
        JsonNode node = objectMapperConverter.parser(jSonString);
        return objectMapperConverter.convertFromJsonToObject(node, RouteAnswer.class);
    }

    public int countDistanceBetweenClients(AddressData addressDataStart, AddressData addressDataEnd,
                                           TravelMode travelMode, RouteType routeType,
                                           int maxAlternativeRoutes, boolean traffic) throws Exception {

        Position positionStart = getLocationFromAddress(addressDataStart).getResults().get(0).getPosition();
        Position endPosition = getLocationFromAddress(addressDataEnd).getResults().get(0).getPosition();

        PositionsConverter positionsConverter = new PositionsConverter(positionStart, endPosition);

        RouteData routeData = new RouteData(travelMode, routeType,positionsConverter,maxAlternativeRoutes,traffic);
        RouteAnswer routeAnswer = findRoute(routeData);
        return routeAnswer.getRoutes().get(0).getSummary().getLengthInMeters();
    }

}
