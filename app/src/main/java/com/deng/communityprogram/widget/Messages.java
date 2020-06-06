package com.deng.communityprogram.widget;

public class Messages {

    public static final int TYPE_OTHER = 0;
    public static final int TYPE_MINE = 1;
    private String name;
    private String message;
    private String date;
    private int type;

    public Messages(String name, String message, String date, int type) {
        this.name = name;
        this.message = message;
        this.date = date;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }
}
