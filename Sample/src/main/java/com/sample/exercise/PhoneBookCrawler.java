package com.sample.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class PhoneBook {
//    private static final long serialVersionUID = 1L;

    private static final HashMap<String, String> PHONE_NUMBERS = new HashMap<String, String>() {
        {
            put("Samuel", "016-161616");
            put("Nicole", "016-161617");
            put("Kate", "016-161618");
        }
    };

    private HashMap<String, String> phoneBookEntries = PHONE_NUMBERS;

    PhoneBook() { }

    public HashMap<String, String> getPhoneBookEntries() {
        return phoneBookEntries;
    }

    public Optional<String> findPhoneNumberByName(String name){
        Optional<String> possiblePhoneNumber = Optional.ofNullable(phoneBookEntries.get(name));
        return possiblePhoneNumber;
    }

    public Optional<String> findNameByPhoneNumber(String phoneNumber){
        Optional<String> possibleName = Optional.empty();
        for (Map.Entry<String, String> e : phoneBookEntries.entrySet()) {
            if (e.getValue().equals(phoneNumber)) {
                return Optional.of(e.getKey());
            }
        }
        return possibleName;
    }

    @Override
    public String toString() {
        System.out.println("Hello from PhoneBook's toString method");
        return "PhoneBook{" +
                "phoneBookEntries=" + phoneBookEntries +
                '}';
    }
}

public class PhoneBookCrawler {
    private PhoneBook phoneBook;

    public static void main(String[] args) {
        PhoneBookCrawler pbc = new PhoneBookCrawler(new PhoneBook());
        String name = "Nicole";
        String s = pbc.findPhoneNumberByNameAndPunishIfNothingFound(name);
        System.out.println(name + "'s number is: " + s);
    }
    public PhoneBookCrawler(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public String findPhoneNumberByNameAndPunishIfNothingFound(String name){
        Optional<String> phoneNumber  = phoneBook.findPhoneNumberByName(name);
        if (phoneNumber.isPresent()) {
            return phoneNumber.get();
        } else {
            throw new IllegalArgumentException("No phone number found");
        }
    }

    public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(String name){
        return null;
    }

    public String findPhoneNumberByNameOrNameByPhoneNumber(String name, String phoneNumber){
        return null;
    }

    public PhoneBook getPhoneBook(){
        return phoneBook;
    }

}