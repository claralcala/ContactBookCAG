package es.iescarrillo.contactbookcag.models;

import java.util.Comparator;
import java.util.Objects;

public class Contact implements Comparable<Contact> {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String telephone;


    public Contact() {

    }
    public Contact(int id, String name, String surname, String email, String telephone){
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public boolean equals(Contact c) {
        return this.getTelephone().equals(c.getTelephone());

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, telephone);
    }

    @Override
    public int compareTo(Contact c) {
        int result = 0;

        if (this.getName().compareTo(c.getName())== 0){
            result = this.getSurname().compareTo(c.getSurname());
        }else {
            result = this.getName().compareTo(c.getName());
        }
        return result;
    }


}