package es.iescarrillo.contactbookcag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.SortedSet;

import es.iescarrillo.contactbookcag.data.Database;
import es.iescarrillo.contactbookcag.models.Contact;

public class EditContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        SortedSet<Contact> contacts = Database.contactList;

        //Recuperar intent
        Intent intentEdit = getIntent();

        //Recuperamos el nombre

        EditText etName = findViewById(R.id.etNameC);
        etName.setText(intentEdit.getStringExtra("name"));

        EditText etSurname = findViewById(R.id.etSurnameC);
        etSurname.setText(intentEdit.getStringExtra("surname"));

        EditText etMail = findViewById(R.id.etMailC);
        etMail.setText(intentEdit.getStringExtra("email"));

        EditText etPhone = findViewById(R.id.etPhoneC);
        etPhone.setText(intentEdit.getStringExtra("phone"));


        Button btnSave = findViewById(R.id.btnSaveC);
        btnSave.setOnClickListener(v -> {



            
            //Llamar a la First Activity
            Intent viewFirstIntent = new Intent(this, MainActivity.class);
            //Iniciar la siguiente activity
            startActivity(viewFirstIntent);

        });

        Button btnBack = findViewById(R.id.btnBackM);
        btnBack.setOnClickListener(v -> {
            //Llamar a la First Activity
            Intent viewFirstIntent = new Intent(this, MainActivity.class);
            //Iniciar la siguiente activity
            startActivity(viewFirstIntent);

        });
    }
}