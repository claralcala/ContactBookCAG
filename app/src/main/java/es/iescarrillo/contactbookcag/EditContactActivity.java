package es.iescarrillo.contactbookcag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import es.iescarrillo.contactbookcag.datasources.ContactDataSource;

public class EditContactActivity extends AppCompatActivity {

    private ContactDataSource contactDataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        contactDataSource = new ContactDataSource(this);

        //Recuperar intent
        Intent intentEdit = getIntent();

        //Recuperamos el nombre, apellidos, email y teléfono

        EditText etName = findViewById(R.id.etNameC);
        etName.setText(intentEdit.getStringExtra("name"));

        EditText etSurname = findViewById(R.id.etSurnameC);
        etSurname.setText(intentEdit.getStringExtra("surname"));

        EditText etMail = findViewById(R.id.etMailC);
        etMail.setText(intentEdit.getStringExtra("email"));

        EditText etPhone = findViewById(R.id.etPhoneC);
        etPhone.setText(intentEdit.getStringExtra("phone"));


        //Si pulsamos el botón de guardar
        Button btnSave = findViewById(R.id.btnSaveC);
        btnSave.setOnClickListener(v -> {


            contactDataSource.updateContact(intentEdit.getIntExtra("id", 0), etName.getText().toString(), etSurname.getText().toString(), etMail.getText().toString(), etPhone.getText().toString());

            
            //Llamar a la First Activity
            Intent viewFirstIntent = new Intent(this, MainActivity.class);
            //Iniciar la siguiente activity
            startActivity(viewFirstIntent);

        });

        //Botón  para volver
        Button btnBack = findViewById(R.id.btnBackM);
        btnBack.setOnClickListener(v -> {
            //Llamar a la First Activity
            Intent viewFirstIntent = new Intent(this, MainActivity.class);
            //Iniciar la siguiente activity
            startActivity(viewFirstIntent);

        });
    }
}