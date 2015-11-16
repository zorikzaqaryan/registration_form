package com.springapp.mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "address")

public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long address_id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address(){

    }

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
