package SDETSpringWithDB.SDETSpringWithDB.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Country {

    int id;
    String countryname;
    String countryCapital;
}
