package SDETSpringWithDB.SDETSpringWithDB.Service;

import SDETSpringWithDB.SDETSpringWithDB.Entity.Country;
import SDETSpringWithDB.SDETSpringWithDB.Repository.CountryRepository;
import org.assertj.core.internal.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CountryServiceTest {

    @Mock
    CountryRepository countryRepository;

    @InjectMocks
    CountryService countryService;

    @Test
    public void getAllCountriesTest(){

        List<Country> countries=buildCountries();
        when(countryRepository.findAll()).thenReturn(countries);
        assertEquals(3,countryService.getAllCountries().size(),"All the countries are not returned");
        assertEquals(countries,countryService.getAllCountries());
    }

    @Test
    public void getCountryByIdTest(){
        Country country=buildCountry();
        Optional<Country> countryOptional=Optional.of(country);
       when(countryRepository.findById(4)).thenReturn(countryOptional);
   //    when(countryOptional.get()).thenReturn(country);
        Country countryActual=countryService.getCountryById(4);
        assertEquals(country.getId(),countryActual.getId());
        assertEquals(country.getCountryCapital(),countryActual.getCountryCapital());
        assertEquals(country.getCountryname(),countryActual.getCountryname());
    }

    @Test
    public void getCountryByNameTest(){

        List<Country> countries=buildCountries();
        when(countryRepository.findAll()).thenReturn(countries);
        Country countryActual=countryService.getCountryByName("Japan");
        assertEquals("Japan",countryActual.getCountryname());
        assertEquals(3,countryActual.getId());
        assertEquals("Tokyo",countryActual.getCountryCapital());
    }

    @Test
    public void addNewCountryTest(){

        List<Country> countries=buildCountries();
        when(countryRepository.findAll()).thenReturn(countries);

        Country countryActual=countryService.addNewCountry(buildCountry());
        assertEquals(buildCountry().getCountryname(),countryActual.getCountryname());
        assertEquals(buildCountry().getId(),countryActual.getId());
        assertEquals(buildCountry().getCountryCapital(),countryActual.getCountryCapital());
    }

    @Test
    public void updateCountryTest(){

        Country countryActual=countryService.updateCountry(buildCountry());
        assertEquals(buildCountry(),countryActual);
    }

    @Test
    public void deleteCountryByIDTest(){
        String actualDeleteMessage=countryService.deleteCountryByID(5);
        assertEquals("Country Successfully Deleted",actualDeleteMessage);
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
