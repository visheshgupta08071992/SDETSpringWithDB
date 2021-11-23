package SDETSpringWithDB.SDETSpringWithDB.Controller;

import SDETSpringWithDB.SDETSpringWithDB.Entity.Country;
import SDETSpringWithDB.SDETSpringWithDB.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/getcountries")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping
    //Get -> localhost:8080/getcountries
    public List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }

    @GetMapping(path="/{id}")
    //Get -> localhost:8080/getcountries/1
    public Country getCountryByCountryID(@PathVariable int id){
        return countryService.getCountryById(id);
    }

    @GetMapping("/countryname")
    //Get -> localhost:8080/getcountries/countryname?name=India
    public Country getCountryByCountryName(@RequestParam(value="name") String name){
        return countryService.getCountryByName(name);
    }

    @PostMapping("/addcountry")
    //Post -> localhost:8080/getcountries/addcountry
    /*{
        "countryname":"Singapore",
        "countryCapital":"Singapore"
    }*/
    public Country addNewCountry(@RequestBody Country country){
        return countryService.addNewCountry(country);
    }

    @PutMapping("/updatecountry")
    //
    public Country updateCountry(@RequestBody Country country){
        return  countryService.updateCountry(country);
    }

    @DeleteMapping(path="/deleteCountry/{id}")
    //Delete -> localhost:8080/getcountries/deleteCountry/4
    public String deleteCountryById(@PathVariable int id){
        return countryService.deleteCountryByID(id);
    }



}
