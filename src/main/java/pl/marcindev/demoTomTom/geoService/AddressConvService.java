package pl.marcindev.demoTomTom.geoService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import pl.marcindev.demoTomTom.entity.AddressConverterData;
import pl.marcindev.demoTomTom.entity.Response;
import reactor.core.publisher.Mono;

import static pl.marcindev.demoTomTom.constants.RouteSearchConstants.*;

@Slf4j
public class AddressConvService {
    private WebClient webClient;

    public AddressConvService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Response getAnswer(AddressConverterData addressData) {
        //    https://{baseURL}/search/{versionNumber}/geocode/{query}.{ext}?key={Your_API_Key}
        String query = addressData.getPostCode() + " " + addressData.getTown() + ", "
                + addressData.getStreet() + " " + addressData.getNumber();

        String uri = UriComponentsBuilder.fromUriString(GET_LAT_LONG)
                .buildAndExpand(VERSION_NUMBER, query, EXT)
                .toUriString();
        uri += "?key=" + KEY;

        Mono<ResponseEntity<Response>> responseMono = webClient.get()
                .uri(uri)
                .retrieve()
                .toEntity(Response.class);
        ResponseEntity<Response>response = responseMono.block();
        Response response1 = new Response();
        if(response != null && response.getStatusCode().is2xxSuccessful()){
            response1 = response.getBody();
        }else{
            System.out.println("null problem, or status code not equal 200");
        }
        System.out.println(response1.getLat());




return response1;
    }
}
