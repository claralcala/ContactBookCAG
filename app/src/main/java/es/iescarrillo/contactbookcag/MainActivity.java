package es.iescarrillo.contactbookcag;


import static es.iescarrillo.contactbookcag.data.Database.contactList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import es.iescarrillo.contactbookcag.adapters.ContactAdapter;
import es.iescarrillo.contactbookcag.models.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvContacts = findViewById(R.id.lvContacts);
        Button btnAddContact = findViewById(R.id.btnAddContact);

        //¿No necesito crear la lista aquí?
        //Métodos de la lista
        ContactAdapter adapter = new ContactAdapter((Context) this, contactList);

        lvContacts.setAdapter(adapter);

        lvContacts.setOnItemClickListener((parent, view, position, id) ->{

            Contact contact = (Contact) parent.getItemAtPosition(position);
            Intent intent = new Intent(this, ContactDetails.class);
            intent.putExtra("name", contact.getName());
            intent.putExtra("surname", contact.getSurname());
            intent.putExtra("email", contact.getEmail());
            intent.putExtra("phone", contact.getTelephone());

            startActivity(intent);

        });

        btnAddContact.setOnClickListener(v -> {

            Intent AddContactActivity = new Intent(this, es.iescarrillo.contactbookcag.AddContactActivity.class);



            startActivity(AddContactActivity);



        });

    }
}