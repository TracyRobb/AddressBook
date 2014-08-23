package com.android.trobb.addressbook;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.android.trobb.addressbook.Repository.DatasourceDAOImpl;
import com.android.trobb.addressbook.domain.Contact;

/**
 * Created by trobb on 2014/08/20.
 */
public class ContactActivity extends Activity {

    TextView firstname;
    TextView lastname;
    TextView email;
    TextView cell;
    TextView home;

    DatasourceDAOImpl db = new DatasourceDAOImpl(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        int ID = this.getIntent().getExtras().getInt("contactId");

        Contact cons = db.getContact(ID);

        firstname = (TextView) findViewById(R.id.first_textview);
        lastname = (TextView) findViewById(R.id.last_textview);
        email = (TextView) findViewById(R.id.email_textview);
        cell = (TextView) findViewById(R.id.cell_textview);
        home = (TextView) findViewById(R.id.home_textview);

        firstname.setText(cons.getFirstName().toUpperCase());
        lastname.setText(cons.getLastName().toUpperCase());
        email.setText(cons.getEmailAddress().toUpperCase());
        cell.setText(cons.getCellNumber().toUpperCase());
        home.setText(cons.getHomeNumber().toUpperCase());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
