package SDETSpringWithDB.SDETSpringWithDB.Controller;

import SDETSpringWithDB.SDETSpringWithDB.Entity.Country;
import SDETSpringWithDB.SDETSpringWithDB.Service.CountryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CountryControllerTest {

    @Mock
    CountryService countryService;

    @InjectMocks
    CountryController countryController;

    @Test
    public void getAllCountriesTest(){
        when(countryService.getAllCountries()).thenReturn(buildCountries());
        List<Country> actualCountries=countryController.getAllCountries();
        assertEquals(buildCountries().size(),actualCountries.size());
    }

    @Test
    public void getCountryByCountryIDTest(){
        when(countryService.getCountryById(4)).thenReturn(buildCountry());
        Country actualCountry=countryController.getCountryByCountryID(4);
        assertEquals(buildCountry(),actualCountry);
    }

    @Test
    public void getCountryByCountryNameTest(){
        when(countryService.getCountryByName("Nepal")).thenReturn(buildCountry());
        Country actualCountry=countryController.getCountryByCountryName("Nepal");
        assertEquals(buildCountry(),actualCountry);
    }

    @Test
    public void addNewCountryTest(){
        when(countryService.addNewCountry(buildCountry())).thenReturn(buildCountry());
        Country actualCountry=countryController.addNewCountry(buildCountry());
        assertEquals(buildCountry(),actualCountry);
    }

    @Test
    public void updateCountryTest(){
        when(countryService.updateCountry(buildCountry())).thenReturn(buildCountry());
        Country actualCountry=countryController.updateCountry(buildCountry());
        assertEquals(buildCountry(),actualCountry);
    }

    @Test
    public void deleteCountryByIdTest(){
        when(countryService.deleteCountryByID(6)).thenReturn("Country Successfully Deleted");
        String message=countryController.deleteCountryById(6);
        assertEquals("Country Successfully Deleted",message);
    }

    public Country buildCountry(){
        return new Country(4,"Nepal","Kathmandu");
    }

    public List<Country> buildCountries(){
        List<Country> countries=new ArrayList<Country>();
        countries.add(new Country(1,"America","Washington"));
        countries.add(new Country(2,"China","Bejjing"));
        countries.add(new Country(3,"Japan","Tokyo"));
        return countries;
    }
}
