package com.model;

public class Person {
     
    private String name;
    private String cpf;
    private String phone;
    private Adress adress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Person (String name, String cpf, String phone, Adress adress) {
        if(!Validation.validateCPF(cpf)) {
            throw new IllegalArgumentException("Invalid CPF" + cpf);
        }

        if(!Validation.validatePhone(phone)){
            throw new IllegalArgumentException("Invalid phone number: " + phone);
        }

        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.adress = adress;
    }

    public void displayData(){
        System.out.println("Name: " + name);
        System.out.println("CPF: " + cpf);
        System.out.println("Phone: " + phone);
        System.out.println("Adress: " + adress);
    }
}
