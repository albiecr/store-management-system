package com.model;

public class Adress {
    private String street;
    private int number;
    private String cep;
    private String complement;
    private String state;
    private String city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Adress(String street, int number, String cep, String complement, String state, String city){

        if (!Validation.validatePostalCode(cep)){
            throw new IllegalArgumentException("Invalid postal code: " + cep);
        }

        this.street = street;
        this.number = number;
        this.complement = complement;
        this.state = state;
        this.city = city;
    }

    @Override
    public String toString() {
        return street + ", " + number + " - " + complement + ", " + city + " - " + state + ", Postal Code: " + cep;
    }
}
