package pl.marcindev.demoTomTom.geoService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import pl.marcindev.demoTomTom.entity.AddressConverterData;
import pl.marcindev.demoTomTom.entity.Response;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AddressConvServiceTest {
private final String baseUrl = "https://api.tomtom.com";
private WebClient webClient= WebClient.create(baseUrl);
AddressConvService addressConvService = new AddressConvService(webClient);


    @Test
    void getLatLongFromAddress() {
        AddressConverterData address = new AddressConverterData("34-300","Żywiec",
                "Baczyńskiego",12);
        Response response = addressConvService.getAnswer(address);
        System.out.println(response);


        assertTrue(true);
    }
}