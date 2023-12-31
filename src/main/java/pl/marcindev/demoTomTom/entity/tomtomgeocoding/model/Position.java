package pl.marcindev.demoTomTom.entity.tomtomgeocoding.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    float lat;
    float lon;

    @Override
    public String toString() {
        return lat + "," + lon;
    }
}

