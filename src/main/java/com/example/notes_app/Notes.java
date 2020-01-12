package com.example.notes_app;

public class Notes {
    private String title;
    private String description;
    private String ID;

    public Notes() {
        title="";
        description="";
        ID="";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Notes(String title, String description, String ID) {
        this.title = title;
        this.description = description;
        this.ID = ID;
    }
}