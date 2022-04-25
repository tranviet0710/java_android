package com.example.HelloWord19Nh15;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> number;
    private MutableLiveData<ArrayList<String>> strings;
    public LiveData<Integer> getNumber() {
        if (number == null) {
            number = new MutableLiveData<Integer>();
            number.setValue(0);
        }
        return number;
    }

    public  MutableLiveData<ArrayList<String>> getStrings() {
        if (strings == null) {
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add("1");
            strings = new MutableLiveData<ArrayList<String>>(arrayList);
        }
        return strings;
    }

    public void increaseNumber() {
        number.setValue(number.getValue() + 1);
    }

    public void increaseStrings() {
        strings.getValue().add("" + (number.getValue() + 1));
        strings.setValue(strings.getValue());
    }

    public void decreaseStrings(int i) {
        strings.getValue().remove(i);
        strings.setValue(strings.getValue());
    }

    public void decreaseNumber() {
        number.setValue(number.getValue() - 1);
    }

    public void changeStrings(int index, String newValue) {
        strings.getValue().set(index, newValue);
        strings.setValue(strings.getValue());
    }
}
