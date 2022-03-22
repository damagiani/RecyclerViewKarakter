package com.example.aplikasirecyclerview;

public class Karakter {
    private final String name;
    private final String type;
    private final int image;

    public Karakter(String name, String type, int image) {
        this.name = name;
        this.type = type;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getImage() {
        return image;
    }
}
