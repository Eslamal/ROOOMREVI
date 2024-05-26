package com.example.rooomrevi;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    WordsRepository wordsRepository ;
    private LiveData<List<Words>> getAllWords ;
    public WordViewModel(@NonNull Application application) {
        super(application);
        wordsRepository=new WordsRepository(application);
        getAllWords=wordsRepository.getAllWords();
    }
    void insert(Words words){
        wordsRepository.insert(words);
    }


    void update(Words words){
        wordsRepository.update(words);
    }


    void delete(Words words){
        wordsRepository.delete(words);

    }


    void deleteAllWords(){
       wordsRepository.deleteAllWords();
    }


    LiveData<List<Words>> getAllWords(){
        return getAllWords ;
    }
}
