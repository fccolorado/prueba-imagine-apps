package com.prueba.pruebaimagineapps.model;

import java.util.Date;

public class Order {

    private Integer Id;
    private String number;
    private Date creationDate;
    private Date dateReceived;
    private double total;

    public Order() {
    }

    public Order(Integer id, String number, Date creationDate, Date dateReceived, double total) {
        Id = id;
        this.number = number;
        this.creationDate = creationDate;
        this.dateReceived = dateReceived;
        this.total = total;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Id=" + Id +
                ", number='" + number + '\'' +
                ", creationDate=" + creationDate +
                ", dateReceived=" + dateReceived +
                ", total=" + total +
                '}';
    }
}
