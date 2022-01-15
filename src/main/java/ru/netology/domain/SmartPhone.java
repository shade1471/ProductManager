package ru.netology.domain;

public class SmartPhone extends Product{
    private String company;

    public SmartPhone(int id, String name, int price, String company) {
        super(id, name, price);
        this.company = company;
    }

    public SmartPhone(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
