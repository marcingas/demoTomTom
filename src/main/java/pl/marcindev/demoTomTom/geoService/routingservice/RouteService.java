package pl.marcindev.demoTomTom.geoService.routingservice;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import pl.marcindev.demoTomTom.entity.tomtomrouting.model.RouteData;
import reactor.core.publisher.Mono;

import static pl.marcindev.demoTomTom.constants.RouteSearchConstants.*;
import static pl.marcindev.demoTomTom.constants.RouteSearchConstants.KEY;

public class RouteService {
    private WebClient webClient;



    public RouteService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> getRoute(RouteData routeData) {

        String uri = UriComponentsBuilder.fromUriString(FIND_ROUTE)
                .buildAndExpand(routeData.getPositions(), routeData.getAlternativeRoutes(),
                        routeData.getRouteType(), routeData.isTraffic(), routeData.getTravelMode())
                .toUriString();
        uri += "&key=" + KEY;

        Mono<String> response = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(String.class);

        return response;

    }

}
