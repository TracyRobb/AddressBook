package com.android.trobb.addressbook.Repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by trobb on 2014/08/19.
 */
public class DatabaseHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "addressBook";
    public static final String TABLE_CONTACTS = "contacts";

    public static final String KEY_ID = "id";
    public static final String KEY_FIRSTNAME = "First_Name";
    public static final String KEY_LASTNAME = "Last_Name";
    public static final String KEY_EMAIL = "Email_Address";
    public static final String KEY_CELL = "Cell_Number";
    public static final String KEY_HOME = "Home_Number";

    public DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_CONTACTS + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_FIRSTNAME + " TEXT, "
                + KEY_LASTNAME + " TEXT, "
                + KEY_EMAIL + " TEXT, "
                + KEY_CELL + " TEXT, "
                + KEY_HOME + " TEXT); ";



        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        onCreate(db);
    }
}
