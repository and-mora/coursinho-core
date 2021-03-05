package it.bit.academy.corsopiu.entities;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "street_address")
    private String streetAddress;

    private String city;
    private String province;
    private Region region;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Address(String streetAddress, String city, String province, Region region) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.region = region;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
