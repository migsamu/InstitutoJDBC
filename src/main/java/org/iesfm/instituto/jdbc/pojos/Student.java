package org.iesfm.instituto.jdbc.pojos;

import java.util.Objects;

public class Student {

    private String nif;
    private String name;
    private String surname;
    private Integer zipCode;
    private String address;
    private String email;

    public Student(String nif, String name, String surname, Integer zipCode, String address, String email) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.zipCode = zipCode;
        this.address = address;
        this.email = email;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(nif, student.nif) && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(zipCode, student.zipCode) && Objects.equals(address, student.address) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, name, surname, zipCode, address, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", zipCode=" + zipCode +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
