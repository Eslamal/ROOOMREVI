package com.example.rooomrevi;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Words.class}, version = 1, exportSchema = false)
public abstract class WordRoomDb extends RoomDatabase {

    public abstract WordsDao wordDao();

    private static volatile WordRoomDb INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static WordRoomDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    WordRoomDb.class, "word_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
new PopulateDataAsyncTask(INSTANCE).execute();

            }

    };
    private static class PopulateDataAsyncTask extends AsyncTask<Void,Void,Void>{
        private WordsDao wordsDao ;
        PopulateDataAsyncTask(WordRoomDb wordRoomDb){
         this.wordsDao=wordRoomDb.wordDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            wordsDao.insert(new Words("eslam","ali","atta"));
            return null;
        }
    }
}
