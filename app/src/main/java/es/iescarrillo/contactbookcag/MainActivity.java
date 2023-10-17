package es.iescarrillo.contactbookcag;




import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.SortedSet;

import es.iescarrillo.contactbookcag.adapters.ContactAdapter;

import es.iescarrillo.contactbookcag.datasources.ContactDataSource;
import es.iescarrillo.contactbookcag.models.Contact;

/**
 * Esta es la clase principal desde la que parte nuestra app
 *
 */
public class MainActivity extends AppCompatActivity {
    private ContactDataSource contactDataSource;
    ContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos la listview, el botón de agregar contactos y el sortedset
        ListView lvContacts = findViewById(R.id.lvContacts);
        Button btnAddContact = findViewById(R.id.btnAddContact);

        contactDataSource = new ContactDataSource(this);
        contactDataSource.getAllContacts();

        contactDataSource.openWritableDatabase();
        contactDataSource.close();


        SortedSet<Contact> contacts = contactDataSource.getAllContacts();

        adapter = new ContactAdapter((Context) this, contacts);


        lvContacts.setAdapter(adapter);


        //Nos llevamos los datos de los contactos a la pantalla de visualización
        lvContacts.setOnItemClickListener((parent, view, position, id) ->{

            Contact contact = (Contact) parent.getItemAtPosition(position);
            Intent intent = new Intent(this, ContactDetails.class);
            intent.putExtra("id", contact.getId());
            intent.putExtra("name", contact.getName());
            intent.putExtra("surname", contact.getSurname());
            intent.putExtra("email", contact.getEmail());
            intent.putExtra("phone", contact.getTelephone());

            startActivity(intent);

        });

        //Listener para el botón de agregar contacto
        btnAddContact.setOnClickListener(v -> {

            Intent AddContactActivity = new Intent(this, es.iescarrillo.contactbookcag.AddContactActivity.class);



            startActivity(AddContactActivity);



        });

    }
}