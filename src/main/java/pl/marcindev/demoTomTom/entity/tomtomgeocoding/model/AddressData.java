package pl.marcindev.demoTomTom.entity.tomtomgeocoding.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressData {

    private String postCode;
    private String town;
    private String street;
    private Integer number;

}
