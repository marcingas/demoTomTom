package pl.marcindev.demoTomTom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressConverterData {

    private String postCode;
    private String town;
    private String street;
    private Integer number;

}
