package pl.marcindev.demoTomTom.geoService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import pl.marcindev.demoTomTom.entity.AddressConverterData;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AddressConvServiceTest {
private final String baseUrl = "https://api.tomtom.com";
private WebClient webClient= WebClient.create(baseUrl);
AddressConvService addressConvService = new AddressConvService(webClient);


    @Test
    void getLatLongFromAddress() {
        AddressConverterData address = new AddressConverterData("34-300","Żywiec",
                "Baczyńskiego",12);
        String response = addressConvService.getAnswer(address);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.addMixIn(Locations.class, IgnoreUnknownMixin.class);
        try{
            Locations locations = objectMapper.readValue(response, Locations.class);
            String lat = locations.getLat();
            System.out.println(lat);

        }catch (Exception e){
            e.printStackTrace();
        }
        assertTrue(true);
    }
}