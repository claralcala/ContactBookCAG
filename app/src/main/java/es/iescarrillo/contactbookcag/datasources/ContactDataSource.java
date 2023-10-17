package es.iescarrillo.contactbookcag.datasources;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.SortedSet;
import java.util.TreeSet;

import es.iescarrillo.contactbookcag.data.DatabaseHelper;
import es.iescarrillo.contactbookcag.models.Contact;

public class ContactDataSource {

    private SQLiteDatabase database;

    private DatabaseHelper dbHelper;

    public ContactDataSource(Context context){

        dbHelper = new DatabaseHelper(context);

    }

    public void openWritableDatabase() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }

    public void openReadableDatabase() throws SQLException{
        database = dbHelper.getReadableDatabase();
    }


    public void close() {
        dbHelper.close();
    }

    public void insertContact(String name, String surname, String email, String telephone){
        openWritableDatabase();

        ContentValues values = new ContentValues();

        if (name == null)
            values.put("name", "Nombre desconocido");
        else
            values.put("name", name);

        if (surname == null)
            values.put("surname", "Apellidos desconocidos");
        else
            values.put("surname", surname);

        values.put("email", email);
        values.put("telephone", telephone);

        database.insert("Contact", null, values);

        close();


    }

    public void updateContact(int id, String name, String surname, String email, String telephone){
        openWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("surname", surname);
        values.put("email", email);
        values.put("telephone", telephone);

        String [] arguments= new String[]{String.valueOf(id)};
        database.update("Contact", values, "_id=?", arguments);

        close();

    }

    public void deleteContact (int id){
        openWritableDatabase();

        String[] arguments = new String[]{String.valueOf(id)};
        database.delete("Contact", "_id=?", arguments);

        close();

    }

    public SortedSet<Contact> getAllContacts(){
        SortedSet<Contact> contacts = new TreeSet<Contact>();
            openReadableDatabase();

            String[] columns = {"_id", "name", "surname", "email", "telephone"};

            Cursor contactCursor= database.query("Contact", columns, null, null, null, null, null);

            if (contactCursor != null && contactCursor.moveToFirst()){
                do{
                    int idIndex = contactCursor.getColumnIndex("_id");
                    int nameIndex = contactCursor.getColumnIndex("name");
                    int surnameIndex= contactCursor.getColumnIndex("surname");
                    int emailIndex = contactCursor.getColumnIndex("email");
                    int phoneIndex = contactCursor.getColumnIndex("telephone");

                    int id = contactCursor.getInt(idIndex);
                    String name = contactCursor.getString(nameIndex);
                    String surname = contactCursor.getString(surnameIndex);
                    String email = contactCursor.getString(emailIndex);
                    String telephone = contactCursor.getString(phoneIndex);

                    Contact c = new Contact();
                    c.setId(id);
                    c.setName(name);
                    c.setSurname(surname);
                    c.setEmail(email);
                    c.setTelephone(telephone);

                    contacts.add(c);

                }while (contactCursor.moveToNext());
            }


        close();

        return contacts;
    }

}
