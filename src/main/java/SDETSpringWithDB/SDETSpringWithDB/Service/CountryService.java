package SDETSpringWithDB.SDETSpringWithDB.Service;

import SDETSpringWithDB.SDETSpringWithDB.Entity.Country;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CountryService  {

    Map<Integer, Country> countryIdMap;
    CountryService(){
        countryIdMap=new HashMap<Integer,Country>();
        countryIdMap.put(1,new Country(1,"India","Delhi"));
        countryIdMap.put(2,new Country(2,"USA","Washington"));
        countryIdMap.put(3,new Country(3,"UK","London"));
    }

    //Method which would return all the countries
    public List<Country> getAllCountries(){
        List<Country> country=new ArrayList<>(countryIdMap.values());
        return country;
    }

    //Method which would return country by Id
    public Country getCountryById(int id){
        for(Map.Entry<Integer,Country> entry: countryIdMap.entrySet()){
            if(entry.getValue().getId()==id){
                return entry.getValue();
            }
        }
        return null;
    }

    //Method which would return country by Name
    public Country getCountryByName(String countryName){
        for(Map.Entry<Integer,Country> entry: countryIdMap.entrySet()){
            if(entry.getValue().getCountryname().equals(countryName)){
                return entry.getValue();
            }
            System.out.println(entry.getValue().getCountryname());
        }
        return null;
    }

    //Method to add a new country
    public Country addNewCountry(Country country){
        country.setId(getLatestCountryId());
        countryIdMap.put(getLatestCountryId(),country);
        return country;
    }


    //Method to delete Country By ID
    public String deleteCountryByID(int id){
        for(Map.Entry<Integer,Country> entry: countryIdMap.entrySet()){
            if(entry.getValue().getId()==id){
                countryIdMap.remove(id);
                return "Country deleted";
            }
        }
        return null;
    }

    //Method to update Country By Sending all details
    public Country updateCountry(Country country){
        countryIdMap.put(country.getId(),country);
        return country;
    }

    //Method to always get the new ID for Country
    public int getLatestCountryId(){
        int id=0;
        for(int i:countryIdMap.keySet()){
           id=i;
        }
        return id+1;
    }
}
