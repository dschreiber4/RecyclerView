package edu.cvtc.dschreiber4.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    public WordListAdapter(Context context, LinkedList<String> mWordList) {
        // Adds and inflater for the wordlist
        mInflater = LayoutInflater.from(context);
        this.mWordList = mWordList;
    }

    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView wordItemView;
        final WordListAdapter mAdapter;

        public WordViewHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            //connect the onClickListener to the View
            itemView.setOnClickListener(this);
        }

        //Created to make the recyclerView interactive
        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // access the selected item in mWordList.
            String element = mWordList.get(mPosition);
            // Change the word in the mWordList.
            mWordList.set(mPosition, "Clicked! " + element);
            // Notify the adapter of the change and  update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
        }
    }


    //Inflates the item layout and returns a viewHolder
    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }
    //Connects data to the viewHolder
    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}
