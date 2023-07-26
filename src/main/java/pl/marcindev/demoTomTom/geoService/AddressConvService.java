package pl.marcindev.demoTomTom.geoService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import pl.marcindev.demoTomTom.entity.AddressConverterData;
import pl.marcindev.demoTomTom.entity.Response;
import reactor.core.publisher.Mono;

import static pl.marcindev.demoTomTom.constants.AddressConvConstatnts.*;

@Slf4j
public class AddressConvService {
    private WebClient webClient;

    public AddressConvService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Response getLatLongFromAddress(AddressConverterData addressData) {
        //    https://{baseURL}/search/{versionNumber}/geocode/{query}.{ext}?key={Your_API_Key}
        String query = addressData.getPostCode() + " " + addressData.getTown() + ", "
                + addressData.getStreet() + " " + addressData.getNumber();

        String uri = UriComponentsBuilder.fromUriString(GET_LAT_LONG)
                .buildAndExpand(VERSION_NUMBER, query, EXT)
                .toUriString();
        uri += "?key=" + KEY;

       return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(Response.class)
                .block();




    }
}
