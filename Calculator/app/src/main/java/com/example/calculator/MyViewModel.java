package com.example.calculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<String> operation;
    private MutableLiveData<String> operations;
    public LiveData<String> getString() {
        if (operation == null) {
            operation = new MutableLiveData<String>("");
        }
        return operation;
    }

    public LiveData<String> getOperations() {
        if (operations == null) {
            operations = new MutableLiveData<String>("");
        }
        return operations;
    }


    public void removeAll() {
        operation.setValue("");
        operations.setValue("");
    }

    public void remove() {
        operation.setValue(operation.getValue().substring(0, operation.getValue().length()-1));
    }

    public void opposite() {
        Integer a = null;
        try {
            a = Integer.parseInt(operation.getValue());
            if(a>0){
                operation.setValue("" + -a);
            }
            else{
                operation.setValue("" + a);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addText(String op) {
        operation.setValue(operation.getValue().concat(op));
    }

    public void makeResult() {
        operations.setValue(operations.getValue().concat(operation.getValue() + "=" + getResult(operation.getValue())+ " "));
        if(operations.getValue().length() == 20){
            operations.setValue("");
        }

        operation.setValue("result");
    }

    private float getResult(String value) {
        float res = 0f;
        for(int i = 0; i<value.length(); i++){
            if(Character.isDigit(value.charAt(i))) continue;
            if(value.charAt(i) )
        }
        return res;
    }
}

