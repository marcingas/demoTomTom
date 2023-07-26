package pl.marcindev.demoTomTom.entity;

import lombok.Getter;
import lombok.Setter;
import pl.marcindev.demoTomTom.geoService.Locations;
@Getter
@Setter
public class LocationsConverter {
    Locations locations1;
    Locations locations2;

    @Override
    public String toString() {
        return locations1 + "%" + locations2;
    }
}
