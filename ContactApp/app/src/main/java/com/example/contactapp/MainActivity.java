package com.example.contactapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.contactapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<Contact> contacts;
    private ContactsAdapter contactsAdapter;
    private MyViewModel model;

    private AppDatabase appDatabase;
    private ContactDao contactDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        appDatabase = AppDatabase.getInstance(this);
        contactDao = appDatabase.contactDao();
        //Get data from DB
        List<Contact> contactList1 = contactDao.getAllContacts();
        if(Objects.isNull(contactList1)){
            contactDao.insertAll(mockData());
        }
        contacts = new ArrayList<>(contactDao.getAllContacts());
        contactsAdapter = new ContactsAdapter(contacts);
        binding.rvContacts.setAdapter(contactsAdapter);
        binding.rvContacts.setLayoutManager(new LinearLayoutManager(this));
        model = new ViewModelProvider(this).get(MyViewModel.class);
        model.getContacts().observe(this, contactList -> {
                contacts.clear();
                contactList.forEach(x->contacts.add(x));
        });

        initSearchWidget();
        binding.addBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NewContactActivity.class);
            startActivityForResult(intent, 123);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123) {
            if (resultCode == Activity.RESULT_OK) {
                String[] result;
                result = data.getStringArrayExtra("data");
                if (result != null && result.length == 3) {
                            Contact contact = new Contact(result[0], result[1], result[2]);
                            model.addContact(contact);
                            contactDao.insert(contact);
                            contactsAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    private void initSearchWidget() {
        SearchView searchView = findViewById(R.id.sv_contacts);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<Contact> filteredContacts = contacts.stream()
                        .filter(x->x.getName().toLowerCase().contains(s))
                        .collect(Collectors.toCollection(ArrayList::new));
                contactsAdapter = new ContactsAdapter(filteredContacts);
                binding.rvContacts.setAdapter(contactsAdapter);
                return false;
            }
        });
    }

    private List<Contact> mockData() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Tran The Vu", "117", "tranthevu1309@gmail.com"));
        contacts.add(new Contact("Pham Minh Tuan", "119", "minhtuanpham0710@gmail.com"));
        contacts.add(new Contact("Ninh Khanh Duy", "114", "duykhanhninh1204@gmail.com"));
        contacts.add(new Contact("Bui Thi Thanh Thanh", "113", "thanhbuithithanh@gmail.com"));
        return contacts;
    }
}