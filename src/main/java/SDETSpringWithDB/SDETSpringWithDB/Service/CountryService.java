package SDETSpringWithDB.SDETSpringWithDB.Service;

import SDETSpringWithDB.SDETSpringWithDB.Entity.Country;
import SDETSpringWithDB.SDETSpringWithDB.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Service
public class CountryService  {

    @Autowired
    CountryRepository countryRepository;


    //Method which would return all the countries
    public List<Country> getAllCountries(){
       return countryRepository.findAll();
    }

    //Method which would return country by Id
    public Country getCountryById(int id){
         return countryRepository.findById(id).get();
    }

    //Method which would return country by Name
    public Country getCountryByName(String countryName){
        List<Country> country=countryRepository.findAll();
        for(Country country1:country){
            if(country1.getCountryname().equals(countryName)){
                return country1;
            }
        }
        return null;
    }

    //Method to add a new country
    public Country addNewCountry(Country country){
        country.setId(getLatestCountryId() + 1);
        countryRepository.save(country);
        return country;
    }

    //Method to delete Country By ID
    public String deleteCountryByID(int id){
        countryRepository.deleteById(id);
        return "Country Successfully Deleted";
    }

    //Method to update Country By Sending all details
    public Country updateCountry(Country country){
        countryRepository.save(country);
        return country;
    }

    //Method to always get the new ID for Country
    public int getLatestCountryId(){
         return countryRepository.findAll().size();
    }
}
