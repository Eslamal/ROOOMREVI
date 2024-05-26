package com.example.rooomrevi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddNewWord extends AppCompatActivity {
EditText WordName,WordMeaning,WordType;
AddNewWordViewModel addNewWordViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_word);
        WordName=findViewById(R.id.editTextName);
        WordMeaning=findViewById(R.id.editTextMeaning);
        WordType=findViewById(R.id.editTextType);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_exit_24);
        setTitle("Add New Word");
            addNewWordViewModel=new ViewModelProvider(this).get(AddNewWordViewModel.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_word:
                saveWord();
                return true ;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public void saveWord(){
        String word=WordName.getText().toString().trim();
        String meaning=WordMeaning.getText().toString().trim();
        String type=WordType.getText().toString().trim();
        if(word.isEmpty() || meaning.isEmpty() || type.isEmpty()){
            Toast.makeText(getApplicationContext(),"please fill all fields",Toast.LENGTH_LONG).show();
            return;
        }
        addNewWordViewModel.insert(new Words(word,meaning,type));
        finish();

    }
}