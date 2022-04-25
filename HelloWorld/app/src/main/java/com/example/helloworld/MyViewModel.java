package com.example.helloworld;

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

    public LiveData<ArrayList<String>> getStrings() {
        if (strings == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("0");
            strings = new MutableLiveData<ArrayList<String>>(arrayList);
        }
        return strings;
    }

    public void increaseNumber() {
        number.setValue(number.getValue() + 1);
        strings.getValue().add("" + (number.getValue()));
        strings.setValue(strings.getValue());
    }

    public void decreaseNumber() {
        number.setValue(number.getValue() - 1);
        strings.getValue().add("" + (number.getValue()));
        strings.setValue(strings.getValue());

    }

    public void removeItem(int i) {
        strings.getValue().remove(i);
        strings.setValue(strings.getValue());

    }

    public void changeValue(int i, String x) {
        strings.getValue().set(i, x);
        strings.setValue(strings.getValue());
    }
}
