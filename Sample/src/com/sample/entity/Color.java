package com.sample.entity;

public enum Color {
    PINK("粉红色的"),
    RED("红色的"),
    WHITE("白色的"),
    YELLOW("黄色的"),
    BLACK("黑色的");

    private String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Color{" +
                "value='" + value + '\'' +
                '}';
    }
}
