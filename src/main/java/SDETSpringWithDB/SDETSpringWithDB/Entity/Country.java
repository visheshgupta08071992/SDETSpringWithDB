package SDETSpringWithDB.SDETSpringWithDB.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Country")
public class Country {

    @Id
    @Column(name="id")
    int id;

    @Column(name="countryname")
    String countryname;

    @Column(name="countryCapital")
    String countryCapital;

    public Country(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }


    public Country(int id, String countryname, String countryCapital) {
        this.id = id;
        this.countryname = countryname;
        this.countryCapital = countryCapital;
    }


}
