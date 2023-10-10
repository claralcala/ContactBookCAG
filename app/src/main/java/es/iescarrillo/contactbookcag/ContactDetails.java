package es.iescarrillo.contactbookcag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.SortedSet;
import java.util.TreeSet;

import es.iescarrillo.contactbookcag.data.Database;
import es.iescarrillo.contactbookcag.models.Contact;

public class ContactDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        SortedSet<Contact> contacts = Database.contactList;

        //Recuperar intent con los datos que nos traemos de la página principal
        Intent viewMainIntent = getIntent();

        //Recuperamos el nombre, apellido, email y telf
        TextView tvName = (TextView) findViewById(R.id.tvName);
        tvName.setText(viewMainIntent.getStringExtra("name"));

        TextView tvSurname = (TextView) findViewById(R.id.tvSurname);
        tvSurname.setText(viewMainIntent.getStringExtra("surname"));

        TextView tvMail = (TextView) findViewById(R.id.tvEmail);
        tvMail.setText(viewMainIntent.getStringExtra("email"));

        TextView tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvPhone.setText(viewMainIntent.getStringExtra("phone"));


        Button btnEdit = findViewById(R.id.btnEdit);

        //Cuando pulsamos el botón editar, nos llevamos toda la info a la siguiente pantalla
        btnEdit.setOnClickListener(v -> {
            //Llamar a la First Activity
            Intent viewEditIntent = new Intent(this, EditContactActivity.class);


            viewEditIntent.putExtra("name", tvName.getText().toString());
            viewEditIntent.putExtra("surname", tvSurname.getText().toString());
            viewEditIntent.putExtra("email", tvMail.getText().toString());
            viewEditIntent.putExtra("phone", tvPhone.getText().toString());

            //Iniciar la siguiente activity
            startActivity(viewEditIntent);



        });

        //Para el botón eliminar, buscamos en la lista un contacto que coincida con los datos que tenemos
        //Si encontramos ese contacto, lo borramos
        Button btnDelete = findViewById(R.id.btnDelete);


        btnDelete.setOnClickListener(v -> {
            //Recordemos que no podemos borrar Personas que se generan con el método populateDatabase
            //Copiamos el SortedSet en otro igual para iterar sobre él y que no nos den problemas las eliminaciones
            SortedSet<Contact> copyContacts = new TreeSet<>(contacts);
            for (Contact con: copyContacts){
                if(con.getName().equals(tvName.getText().toString()) && con.getSurname().equals(tvSurname.getText().toString()) && con.getEmail().equals(tvMail.getText().toString()) && con.getTelephone().equals(tvPhone.getText().toString())){
                   //Evidentemente la eliminación del contacto la hacemos sobre el SortedSet original, no la copia
                    contacts.remove(con);
                    break;
                }
            }

            //Luego volvemos a la vista principal
            Intent viewFirstIntent = new Intent(this, MainActivity.class);
            //Iniciar la siguiente activity
            startActivity(viewFirstIntent);



        });


        //Si pulsamos el botón de vuelta, volvemos a la vista principal
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            //Llamar a la First Activity
            Intent viewFirstIntent = new Intent(this, MainActivity.class);
            //Iniciar la siguiente activity
            startActivity(viewFirstIntent);

        });


    }
}