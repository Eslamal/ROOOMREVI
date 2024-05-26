package com.example.rooomrevi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.viewHolder> {
    ArrayList<Words>arrayList=new ArrayList<>();
    @NonNull
    @Override
    public WordAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.word_item_list,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.viewHolder holder, int position) {
        Words words=arrayList.get(position);
holder.textView1.setText(words.getWordName());
holder.textView2.setText(words.getWordType());
holder.textView3.setText(words.getWordMeaning());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public void setList(ArrayList<Words>arrayList){
        this.arrayList=arrayList ;
        notifyDataSetChanged();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView textView1,textView2,textView3;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textView);
            textView2=itemView.findViewById(R.id.textView2);
            textView3=itemView.findViewById(R.id.textView3);

        }
    }
}
