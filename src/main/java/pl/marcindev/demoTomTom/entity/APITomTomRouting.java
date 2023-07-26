package pl.marcindev.demoTomTom.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APITomTomRouting {
//   base url=  https://api.tomtom.com
//    /routing/1/calculateRoute/52.50931%2C13.42936%3A52.50274%2C13.43872/json?maxAlternatives=3&routeType=shortest&traffic=true&travelMode=car&key=*****
    //        /routing/1/calculateRoute/{routePlanningLocations}/json?maxAlternatives={alternativeRoutes}&routeType={routeType}&traffic={boolean}&travelMode={travelMode}&key={Your_API_Key}

    private TravelMode travelMode;
    private RouteType routeType;
    private LocationsConverter locations;
    private Integer alternativeRoutes;
    private boolean traffic;



}
