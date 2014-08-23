package com.android.trobb.addressbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.trobb.addressbook.Repository.DatasourceDAOImpl;
import com.android.trobb.addressbook.domain.Contact;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener{

    Button addButton;
    ListView myContacts;
    ContactAdapter adapt;

    DatasourceDAOImpl db = new DatasourceDAOImpl(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.main_button);
        addButton.setOnClickListener(this);

        myContacts = (ListView) findViewById(R.id.main_listview);

        List<Contact> contacts = db.getAllContacts();

        adapt = new ContactAdapter(this, contacts);

        myContacts.setAdapter(adapt);
        myContacts.setOnItemClickListener(this);
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
        //starts new activity
        Intent addIntent = new Intent(this, AddActivity.class);
        startActivity(addIntent);
        this.finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //Gets the object from the listView
        Contact cons = adapt.getItem(position);

        //Starts new activity and sends the objects id to the next activity
        Intent contactIntent = new Intent(this, ContactActivity.class);
        contactIntent.putExtra("contactId", cons.getId());
        startActivity(contactIntent);


    }

    @Override
    public void onRestart(){
        //Refreshes the listView
        super.onRestart();

        adapt.notifyDataSetChanged();
    }
}
