package com.example.contactapp;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Objects;

public class MyViewModel extends ViewModel {
    private AppDatabase appDatabase;
    private ContactDao contactDao;
    private MutableLiveData<ArrayList<Contact>> contacts;
    public LiveData<ArrayList<Contact>> getContacts() {
        if (contacts == null) {
            appDatabase = AppDatabase.getInstance(new MainActivity());
            contactDao = appDatabase.contactDao();
            ArrayList<Contact> contactArrayList = new ArrayList<>(contactDao.getAllContacts());
            contacts = new MutableLiveData<>(contactArrayList);
        }
        return contacts;
    }

    public void addContact(Contact contact) {
            contacts.getValue().add(Objects.requireNonNull(contact));
            contacts.setValue(contacts.getValue());
    }

}
