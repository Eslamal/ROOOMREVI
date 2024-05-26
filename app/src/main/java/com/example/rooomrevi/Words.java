package com.example.rooomrevi;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "wordTable")
public class Words {
    @PrimaryKey(autoGenerate = true)
    private int id ;
    private String wordName ;
    private String wordMeaning ;
    @ColumnInfo(name = "Type")
    private String WordType ;

    public Words(String wordName, String wordMeaning, String wordType) {
        this.wordName = wordName;
        this.wordMeaning = wordMeaning;
        WordType = wordType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public String getWordMeaning() {
        return wordMeaning;
    }

    public void setWordMeaning(String wordMeaning) {
        this.wordMeaning = wordMeaning;
    }

    public String getWordType() {
        return WordType;
    }

    public void setWordType(String wordType) {
        WordType = wordType;
    }
}
