package com.android.trobb.addressbook.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.trobb.addressbook.domain.Contact;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by trobb on 2014/08/19.
 */
public class DatasourceDAOImpl implements DatasourceDAO{

    private SQLiteDatabase db;
    private DatabaseHandler dbHelper;

    public DatasourceDAOImpl(Context context)
    {
        dbHelper = new DatabaseHandler(context);
    }

    public void open() throws SQLException{
        db = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    @Override
    public void addContact(Contact contact) {
        try
        {
            //dbHelper.CREATE_CONTACTS_TABLE;
            open();
            ContentValues values = new ContentValues();
            values.put(DatabaseHandler.KEY_FIRSTNAME, contact.getFirstName());
            values.put(DatabaseHandler.KEY_LASTNAME, contact.getLastName());
            values.put(DatabaseHandler.KEY_EMAIL, contact.getEmailAddress());
            values.put(DatabaseHandler.KEY_CELL, contact.getCellNumber());
            values.put(DatabaseHandler.KEY_HOME, contact.getHomeNumber());

            db.insert(DatabaseHandler.TABLE_CONTACTS, null, values);
            close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Contact getContact(int id) {
        try
        {
            open();
            Cursor curs = db.query(DatabaseHandler.TABLE_CONTACTS, new String []{
                    DatabaseHandler.KEY_ID, DatabaseHandler.KEY_FIRSTNAME, DatabaseHandler.KEY_LASTNAME,
                    DatabaseHandler.KEY_EMAIL, DatabaseHandler.KEY_CELL, DatabaseHandler.KEY_HOME},
                    DatabaseHandler.KEY_ID + " =? ", new String[]{String.valueOf(id)}, null, null, null, null);

            if(curs != null)
                curs.moveToFirst();

            Contact contact = new Contact();
            contact.setId(curs.getInt(0));
            contact.setFirstName(curs.getString(1));
            contact.setLastName(curs.getString(2));
            contact.setEmailAddress(curs.getString(3));
            contact.setCellNumber(curs.getString(4));
            contact.setHomeNumber(curs.getString(5));

            close();

            return contact;

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Contact> getAllContacts() {

        List<Contact> contactList = new ArrayList<Contact>();

        String selectALL = "SELECT * FROM " + DatabaseHandler.TABLE_CONTACTS;

        try
        {
            open();
            Cursor curs = db.rawQuery(selectALL, null);

            if(curs.moveToFirst())
            {
                do{
                    Contact contact = new Contact();
                    contact.setId(curs.getInt(0));
                    contact.setFirstName(curs.getString(1));
                    contact.setLastName(curs.getString(2));
                    contact.setEmailAddress(curs.getString(3));
                    contact.setCellNumber(curs.getString(4));
                    contact.setHomeNumber(curs.getString(5));

                    contactList.add(contact);
                }while(curs.moveToNext());
            }
            //return contactList;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            return contactList;
        }
        //return null;
    }
}
