package jpa.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class City {

    @Column(name="city_name")
    private String cityName;

    public City(){}

    public City(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
