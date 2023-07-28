package pl.marcindev.demoTomTom.geoService;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import pl.marcindev.demoTomTom.entity.tomtomgeocoding.model.AddressData;
import pl.marcindev.demoTomTom.entity.tomtomrouting.model.RouteType;
import pl.marcindev.demoTomTom.entity.tomtomrouting.model.TravelMode;

import static org.junit.jupiter.api.Assertions.*;

class GeoSerwisTest {
    GeoSerwis geoSerwis = new GeoSerwis();

    @Test
    void countDistanceBetweenClients() throws Exception {
        AddressData addressDataStart = new AddressData("34-300","Żywiec","Baczyńskiego",12);
        AddressData addressDataEnd = new AddressData("43-300","Bielsko-Biała","Wyzwolenia",1);
        int dist = geoSerwis.countDistanceBetweenClients(addressDataStart,
                addressDataEnd, TravelMode.car, RouteType.shortest,2,true);
        System.out.println(dist);

    }
}