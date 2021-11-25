package SDETSpringWithDB.SDETSpringWithDB.Entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Country {
    int id;
    String countryname;
    String countryCapital;
}