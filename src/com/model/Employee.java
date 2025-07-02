package com.model

public class Employee extends Person {

    private String position;
    private double salary;

    public Employee(String name, String cpf, String phone, Adress adress, String position, double salary){
        super(name, cpf, phone, adress);
        this.position = position;
        this.salary = salary;
    }

    @Override
    public void displayData(){
        super.displayData();
        System.out.println("Position" + position);
        System.out.println("Salary" + salary);
    }


}
