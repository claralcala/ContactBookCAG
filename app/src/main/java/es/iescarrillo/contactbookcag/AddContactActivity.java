package es.iescarrillo.contactbookcag;

import static data.Database.contactList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import models.Contact;

public class AddContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        EditText etName = findViewById(R.id.etName);
        EditText etSurname = findViewById(R.id.etSurname);
        EditText etMail = findViewById(R.id.etMail);
        EditText etPhone = findViewById(R.id.etPhone);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            Contact contact = new Contact(etName.getText().toString(), etSurname.getText().toString(), etMail.getText().toString(), etPhone.getText().toString());

            contactList.add(contact);


        });

        //Volver a la página principal
        Button btnHome = findViewById(R.id.btnBackMain);
        btnHome.setOnClickListener(v -> {
            //Llamar a la First Activity
            Intent viewFirstIntent = new Intent(this, MainActivity.class);
            //Iniciar la siguiente activity
            startActivity(viewFirstIntent);

        });
    }
}