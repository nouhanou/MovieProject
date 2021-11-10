package com.example.movie.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName ="film_table" )
public class Film {
    @PrimaryKey(autoGenerate = true)
    private int id ;
    @ColumnInfo(name = "title")
    private String title ;
    @ColumnInfo(name = "type")
    private String type ;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "annee")
    private String annee;
    @ColumnInfo(name = "flagt")
    private boolean flag;

    public Film() {
    }


    public Film(int id, String title, String type, String description, String annee) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.description = description;
        this.annee = annee;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", annee='" + annee + '\'' +
                '}';
    }
}
