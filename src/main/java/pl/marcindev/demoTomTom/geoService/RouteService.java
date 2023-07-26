package pl.marcindev.demoTomTom.geoService;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import pl.marcindev.demoTomTom.entity.APITomTomRouting;

import static pl.marcindev.demoTomTom.constants.RouteSearchConstants.*;
import static pl.marcindev.demoTomTom.constants.RouteSearchConstants.KEY;

public class RouteService {
    private WebClient webClient;

    public RouteService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String getRoute(APITomTomRouting apiTomTomRouting) {

        String uri = UriComponentsBuilder.fromUriString(FIND_ROUTE)
                .buildAndExpand(apiTomTomRouting.getLocations(), apiTomTomRouting.getAlternativeRoutes(),
                        apiTomTomRouting.getRouteType(), apiTomTomRouting.isTraffic(), apiTomTomRouting.getTravelMode())
                .toUriString();
        uri += "&key=" + KEY;

        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }
}
