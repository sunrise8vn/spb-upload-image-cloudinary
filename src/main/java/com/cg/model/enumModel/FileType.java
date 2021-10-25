package com.cg.model.enumModel;

public enum FileType {
    IMAGE("image"),
    VIDEO("video"),
    SIZE("250");


    private final String value;

    FileType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
