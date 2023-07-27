package pl.marcindev.demoTomTom.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.marcindev.demoTomTom.geoService.Locations;
@Getter
@Setter
@AllArgsConstructor
public class LocationsConverter {
    Locations locationsStart;
    Locations locationsDest;

    @Override
    public String toString() {
        return locationsStart + ":" + locationsDest;
    }
}
