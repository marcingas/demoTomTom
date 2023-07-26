package pl.marcindev.demoTomTom.geoService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Locations {
    String lat;
    String lon;

    @Override
    public String toString() {
        return lat+"%"+lon;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class IgnoreUnknownMixin {

}
