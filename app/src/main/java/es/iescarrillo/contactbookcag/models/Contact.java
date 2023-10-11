package es.iescarrillo.contactbookcag.models;

import java.util.Comparator;
import java.util.Objects;

/**
 * Clase objeto Contact
 */
public class Contact implements Comparable<Contact> {
    //Declaración de atributos
    private int id;
    private String name;
    private String surname;
    private String email;
    private String telephone;

    //Constructor vacío
    public Contact() {

    }
    //Constructor con todos los parámetros
    public Contact(int id, String name, String surname, String email, String telephone){
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
    }

    //Getters y setters
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


    //Equals por el número de telf
    public boolean equals(Contact c) {
        return this.getTelephone().equals(c.getTelephone());

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, telephone);
    }

    /**
     * Método compareto para ordenar por nombre y apellidos
     * @param c el objeto para comparar
     * @return
     */
    @Override
    public int compareTo(Contact c) {
        //Nosotros almacenamos el int para comparar nombre y apellidos en dos variables.
        int compareName = this.getName().compareTo(c.getName());
        if (compareName == 0) {
            int compareSurname = this.getSurname().compareTo(c.getSurname());
            if (compareSurname == 0) {
                //si el nombre y el apellido son iguales, comparamos por num de telefono
                return this.getTelephone().compareTo(c.getTelephone());
            }
            return compareSurname;
        }
        return compareName;
    }


}