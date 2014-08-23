package com.android.trobb.addressbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.trobb.addressbook.Repository.DatabaseHandler;
import com.android.trobb.addressbook.Repository.DatasourceDAOImpl;
import com.android.trobb.addressbook.domain.Contact;

import java.util.List;

/**
 * Created by trobb on 2014/08/19.
 */
public class AddActivity extends Activity implements View.OnClickListener{

    Button addButton;
    EditText firstText;
    EditText lastText;
    EditText emailText;
    EditText cellText;
    EditText homeText;

    String first;
    String last;
    String email;
    String cell;
    String home;

    DatasourceDAOImpl db = new DatasourceDAOImpl(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        addButton = (Button)findViewById(R.id.add_button);
        addButton.setOnClickListener(this);

        firstText = (EditText)findViewById(R.id.first_edittext);
        lastText = (EditText)findViewById(R.id.last_edittext);
        emailText = (EditText)findViewById(R.id.email_edittext);
        cellText = (EditText)findViewById(R.id.cell_edittext);
        homeText = (EditText)findViewById(R.id.home_edittext);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        //Log.d("CREATE:  ", dbs.CREATE_CONTACTS_TABLE);
        //Add to db
        first = firstText.getText().toString();
        last = lastText.getText().toString();
        email = emailText.getText().toString();
        cell = cellText.getText().toString();
        home = homeText.getText().toString();

        Log.d("Inserting", "Inserting");
        db.addContact(new Contact(first, last, email, cell, home));
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "ID: "+cn.getId()+", Name: " + cn.getFirstName() + ", Number: " + cn.getCellNumber();
            Log.d("log   ", log);
        }

        firstText.setText("");
        lastText.setText("");
        emailText.setText("");
        cellText.setText("");
        homeText.setText("");

        Toast.makeText(this, "Added Successfully!", Toast.LENGTH_LONG).show();

        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
        this.finish();
    }
}
