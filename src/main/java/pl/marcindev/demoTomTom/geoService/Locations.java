package pl.marcindev.demoTomTom.geoService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Locations {

    float lattitude;
    float longitude;

    @Override
    public String toString() {
        return lattitude + "," + longitude;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class IgnoreUnknownMixin {

}
