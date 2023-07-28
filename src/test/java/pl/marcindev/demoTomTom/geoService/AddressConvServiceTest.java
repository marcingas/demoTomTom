package pl.marcindev.demoTomTom.geoService;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import pl.marcindev.demoTomTom.entity.tomtomgeocoding.model.AddressData;
import pl.marcindev.demoTomTom.entity.tomtomgeocoding.model.GeocodingAnswer;
import pl.marcindev.demoTomTom.geoService.geocodingservice.AddressConvService;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AddressConvServiceTest {
private final String baseUrl = "https://api.tomtom.com";
private WebClient webClient= WebClient.create(baseUrl);
AddressConvService addressConvService = new AddressConvService(webClient);
ObjectMapperConverter objectMapperConverter = new ObjectMapperConverter();

    @Test
    void getLatLongFromAddress() throws Exception {
        //given
        AddressData address = new AddressData("34-300","Żywiec",
                "Baczyńskiego",12);

        String coordinatesJson = addressConvService.getCoordinates(address).block();
        System.out.println(coordinatesJson);
        JsonNode node = objectMapperConverter.parser(coordinatesJson);
        GeocodingAnswer answer = objectMapperConverter.convertFromJsonToObject(node, GeocodingAnswer.class);
        float lat = answer.getResults().get(0).getPosition().getLat();
        System.out.println(lat);




        assertTrue(true);
    }
}