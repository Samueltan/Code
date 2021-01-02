package com.springboot.ch3.conditional;

public class MacListService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
