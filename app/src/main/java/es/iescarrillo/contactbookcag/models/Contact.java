package es.iescarrillo.contactbookcag.models;

import java.util.Objects;

public class Contact {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String telephone;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id && name.equals(contact.name) && surname.equals(contact.surname) && Objects.equals(email, contact.email) && Objects.equals(telephone, contact.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, telephone);
    }
}