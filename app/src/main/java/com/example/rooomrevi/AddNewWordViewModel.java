package com.example.rooomrevi;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AddNewWordViewModel extends AndroidViewModel {
    WordsRepository wordsRepository ;
    public AddNewWordViewModel(@NonNull Application application) {
        super(application);
        wordsRepository=new WordsRepository(application);
    }
    void insert(Words words){
        wordsRepository.insert(words);
    }


    void update(Words words){
        wordsRepository.update(words);
    }


}
