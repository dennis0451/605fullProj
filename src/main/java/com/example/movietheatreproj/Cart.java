package com.example.movietheatreproj;

import com.example.movietheatreproj.Concession;

import java.util.ArrayList;
import java.util.List;
//cart class to hold concession objects.
//TODO look up/research singleton to only have one instance of cart
public class Cart {
    private static Cart instance = null;
    private List<Concession> items;

    private Cart() {
        items = new ArrayList<>();
    }

    //checks for singleton
    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }
    public List<Concession> getItems() {
        return items;
    }

    public void addConcession(Concession concession) {
        items.add(concession);
    }

    public void removeConcession(Concession concession) {
        items.remove(concession);
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(Concession::getConcessionPrice).sum();
    }

}

