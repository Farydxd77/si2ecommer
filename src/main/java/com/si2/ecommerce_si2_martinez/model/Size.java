package com.si2.ecommerce_si2_martinez.model;

import jakarta.persistence.Embeddable;

import java.util.Objects;
@Embeddable
public class Size {

    private String name;
    private int quantity;


    public Size() {
        // TODO Auto-generated constructor stub
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Sobrescribir equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size size = (Size) o;
        return quantity == size.quantity && Objects.equals(name, size.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity);
    }
}
