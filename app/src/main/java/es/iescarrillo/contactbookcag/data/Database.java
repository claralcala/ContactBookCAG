package es.iescarrillo.contactbookcag.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import es.iescarrillo.contactbookcag.models.Contact;

public class Database {

    public static SortedSet<Contact> contactList = new TreeSet<Contact>() ;


    public static int getId(){
        int result = 0;

        for (Contact c:contactList){
            if(result < c.getId()){
                result=c.getId();
            }
        }

        return result;
    }
    public static void populateDatabase(){
        for (int i=1; i<8; i++){
           int  id = getId();
            Contact c = new Contact();
            c.setId(id);
            c.setName("Persona " + i);
            c.setSurname("Apellidos " + i);
            c.setEmail("Persona " +i + "@iescarrillo.es");
            c.setTelephone("546466556");
            contactList.add(c);

        }
    }





}
