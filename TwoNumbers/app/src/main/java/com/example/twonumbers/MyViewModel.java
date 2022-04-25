package com.example.twonumbers;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;


public class MyViewModel extends ViewModel {
    private MutableLiveData<ArrayList<String>> strings;
    public LiveData<ArrayList<String>> getStrings(){
        if(strings == null){
            ArrayList<String> arrayList =  new ArrayList<>();
//          arrayList.add("");
            strings = new MutableLiveData<ArrayList<String>>(arrayList);
        }
        return strings;
    }
    public void addString(String str){
        strings.getValue().add(str);
        strings.setValue(strings.getValue());
    }

}
