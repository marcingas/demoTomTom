package pl.marcindev.demoTomTom.geoService;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import pl.marcindev.demoTomTom.entity.APITomTomRouting;
import pl.marcindev.demoTomTom.entity.Route;

import java.util.List;

import static pl.marcindev.demoTomTom.constants.RouteSearchConstants.*;
import static pl.marcindev.demoTomTom.constants.RouteSearchConstants.KEY;

public class RouteService {
    private WebClient webClient;

    public RouteService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Route getRoute(APITomTomRouting apiTomTomRouting) {

        String uri = UriComponentsBuilder.fromUriString(FIND_ROUTE)
                .buildAndExpand(apiTomTomRouting.getLocations(), apiTomTomRouting.getAlternativeRoutes(),
                        apiTomTomRouting.getRouteType(), apiTomTomRouting.isTraffic(), apiTomTomRouting.getTravelMode())
                .toUriString();
        uri += "&key=" + KEY;

        List<Route> response = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Route.class)
                .collectList()
                .block();
        System.out.println(response);

           Route route = response.get(0);
            return route;

    }
}
