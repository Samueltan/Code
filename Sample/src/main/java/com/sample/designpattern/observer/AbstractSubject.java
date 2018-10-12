package com.sample.designpattern.observer;

import java.util.ArrayList;

public abstract class AbstractSubject implements Subject {

    private ArrayList<Observer> list = new ArrayList<>();
    @Override
    public void add(Observer observer) {
        list.add(observer);
    }

    @Override
    public void del(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : list){
            observer.update();
        }
    }
}