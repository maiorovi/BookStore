package hibernate.chapter4.domain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "passport")
public class Passport {

    @EmbeddedId
    private PassportData passportData;

    @OneToOne(mappedBy = "passport")
    private Customer customer;

    public Passport() {}

    public Passport(String series, String number) {
        passportData = new PassportData(series, number);
    }

    public PassportData getPassportData() {
        return passportData;
    }

    public void setPassportData(PassportData passportData) {
        this.passportData = passportData;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Embeddable
    public class PassportData implements Serializable {

        @Column(name = "series")
        private String series;
        @Column(name = "number")
        private String number;

        public  PassportData() {}

        public PassportData(String series, String number) {
            this.series = series;
            this.number = number;
        }

        public String getSeries() {
            return series;
        }

        public void setSeries(String series) {
            this.series = series;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }
}
