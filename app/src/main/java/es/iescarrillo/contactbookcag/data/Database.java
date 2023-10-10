package es.iescarrillo.contactbookcag.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import es.iescarrillo.contactbookcag.models.Contact;

/**
 * Clase Database que en nuestro caso contendrá una lista estática que usaremos en las actividades
 */
public class Database {

    public static SortedSet<Contact> contactList = new TreeSet<Contact>() ;

    /**
     * Este método es usado para crear automáticamente el id. Se trata de
     * recorrer la lista y si el id que vamos recogiendo es mayor que la variable que hemos creado,
     * almacenamos ese id en la variable y lo devolvemos
     * @return number
     */
    public static int getId(){
        int number = 0;

        for (Contact c:contactList){
            if(number < c.getId()){
                number=c.getId();
            }
        }

        return number;
    }

    /**
     * Método populateDatabase para llenar la lista con algunos elementos
     * Debe tenerse en cuenta que no es posible eliminar elementos de esta lista porque
     * cada vez que volvemos a la MainActivity llamamos a este método y la lista se llena. Sin embargo,
     *
     */
    public static void populateDatabase(){
        for (int i=1; i<8; i++){
           int  id = getId()+1;
            Contact c = new Contact();
            c.setId(id);
            c.setName("Persona " + i);
            c.setSurname("Apellidos " + i);
            c.setEmail("Persona " +i + "@gmail.com");
            c.setTelephone("57657567");
            contactList.add(c);

        }
    }





}
