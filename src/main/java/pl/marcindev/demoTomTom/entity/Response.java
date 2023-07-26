package pl.marcindev.demoTomTom.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    @JsonProperty("lat")
    private float lat;
    @JsonProperty("lon")
    private float lon;

    @Override
    public String toString() {
        return lat + ": " + lon;
    }
}
