package pl.marcindev.demoTomTom.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Summary {
    private Integer lengthInMeters;
    private Integer travelTimeInSeconds;
    private Integer trafficDelayInSeconds;

    public Summary(Integer lengthInMeters,
                   Integer travelTimeInSeconds,
                   Integer trafficDelayInSeconds) {
        this.lengthInMeters = lengthInMeters;
        this.travelTimeInSeconds = travelTimeInSeconds;
        this.trafficDelayInSeconds = trafficDelayInSeconds;
    }
}
