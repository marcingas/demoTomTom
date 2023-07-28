package pl.marcindev.demoTomTom.entity.tomtomrouting.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class RouteAnswer {
    private List<Route> routes;
}
