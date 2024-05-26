package com.example.rooomrevi;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordsRepository {
    WordsDao wordsDao;
    LiveData<List<Words>>getAllWords ;

    public WordsRepository(Application application) {
        WordRoomDb wordRoomDb=WordRoomDb.getDatabase(application);
       wordsDao= wordRoomDb.wordDao();
       getAllWords= wordsDao.getAllWords();
    }

    void insert(Words words){
   new insertAsyncTask(wordsDao).execute(words);
    }


    void update(Words words){
  new updateAsyncTask(wordsDao).execute(words);
    }


    void delete(Words words){
        new deleteAsyncTask(wordsDao).execute(words);

    }


    void deleteAllWords(){
   new deleteAllWordsAsyncTask(wordsDao).execute();
    }


    LiveData<List<Words>> getAllWords(){
        return getAllWords ;
    }
    public static class insertAsyncTask extends AsyncTask<Words,Void,Void>{
      WordsDao wordsDao ;

        public insertAsyncTask(WordsDao wordsDao) {
            this.wordsDao = wordsDao;
        }

        @Override
        protected Void doInBackground(Words... words) {
            wordsDao.insert(words[0]);
            return null;
        }
    }
    public static class updateAsyncTask extends AsyncTask<Words,Void,Void>{
        WordsDao wordsDao ;

        public updateAsyncTask(WordsDao wordsDao) {
            this.wordsDao = wordsDao;
        }

        @Override
        protected Void doInBackground(Words... words) {
            wordsDao.update(words[0]);
            return null;
        }
    }
    public static class deleteAsyncTask extends AsyncTask<Words,Void,Void>{
        WordsDao wordsDao ;

        public deleteAsyncTask(WordsDao wordsDao) {
            this.wordsDao = wordsDao;
        }

        @Override
        protected Void doInBackground(Words... words) {
            wordsDao.delete(words[0]);
            return null;
        }
    }
    public static class deleteAllWordsAsyncTask extends AsyncTask<Void,Void,Void>{
        WordsDao wordsDao ;

        public deleteAllWordsAsyncTask(WordsDao wordsDao) {
            this.wordsDao = wordsDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            wordsDao.deleteAllWords();
            return null;
        }
    }
}
