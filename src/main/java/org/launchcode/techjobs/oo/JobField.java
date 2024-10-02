package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    // Fields
    private int id;
    private static int nextId = 1;
    private String value;

    // Constructors
    public JobField(){
        id = nextId;
        nextId++;
    }

    public JobField(String value){
        this();
        this.value = value;
    }

    // getters and setters


    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField jobField)) return false;
        return getId() == jobField.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
