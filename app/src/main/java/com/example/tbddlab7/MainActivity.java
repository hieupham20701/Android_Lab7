package com.example.tbddlab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.tbddlab7.adapter.ContactAdapter;
import com.example.tbddlab7.db.DatabaseHandler;
import com.example.tbddlab7.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnRm = (Button) findViewById(R.id.btnRm);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        EditText txtName = (EditText) findViewById(R.id.txtName);

//        Log.d("Insert", "Inserting... ");
//        db.addContact(new Contact("Hieu"));
//        db.addContact(new Contact("Hoc"));
//        db.addContact(new Contact("Lam"));
//        db.addContact(new Contact("Toan"));
//        db.addContact(new Contact("Tin"));
//
//        Log.d("Reading: ", "Reading all contacts ...");
        this.contacts = db.getContacts();
        this.listView = (ListView) findViewById(R.id.listView);

        for(Contact contact: contacts) {
            String log = "Id: " + contact.getId() + " ,Name: " + contact.getName();
            Log.d("Name", log);
        }

        ContactAdapter contactAdapter = new ContactAdapter(this, R.layout.listview_layout, contacts);
        listView.setAdapter(contactAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addContact(new Contact(txtName.getText().toString()));
                contacts = db.getContacts();
                dataChange();
            }
        });


    }

    public void dataChange() {
        ContactAdapter contactAdapter = new ContactAdapter(this, R.layout.listview_layout, contacts);
        listView.setAdapter(contactAdapter);
    }
}