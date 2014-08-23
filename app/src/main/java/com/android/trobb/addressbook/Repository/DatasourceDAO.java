package com.android.trobb.addressbook.Repository;

import com.android.trobb.addressbook.domain.Contact;

import java.util.List;

/**
 * Created by trobb on 2014/08/19.
 */
public interface DatasourceDAO {

    public void addContact(Contact contact);
    public Contact getContact(int id);
    public List<Contact> getAllContacts();

    /* public void updateStudent(Contact contact);
    public Contact findStudentById(int id);
    public void deleteContact(Contact contact); */


}
