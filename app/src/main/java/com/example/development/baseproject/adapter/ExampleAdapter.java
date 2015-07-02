package com.example.development.baseproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.development.baseproject.R;
import com.example.development.baseproject.model.ExampleModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Sekhar on 4/6/15.
 */
public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ViewHolder> {
    private List<ExampleModel> mData = new ArrayList<>();

    public void setData(List<ExampleModel> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.example_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mData.get(position).getName());
    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v;
        }
    }
}