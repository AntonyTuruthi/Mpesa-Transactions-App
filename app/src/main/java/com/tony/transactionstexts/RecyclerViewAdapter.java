package com.tony.transactionstexts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tony.transactionstexts.logic.Transaction;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<Transaction> transactionList;
    Context context;

    public RecyclerViewAdapter(Context context, List<Transaction> transactionList){
        this.transactionList = transactionList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String entityName = transactionList.get(position).getEntity();
        String amount = transactionList.get(position).getAmount();
        String date = transactionList.get(position).getDate();

        holder.txtEntity.setText(entityName);
        holder.txtAmount.setText(amount);
        holder.txtDate.setText(date);
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView txtEntity, txtAmount, txtDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtEntity = itemView.findViewById(R.id.txtEntity);
            txtAmount = itemView.findViewById(R.id.txtAmount);
            txtDate = itemView.findViewById(R.id.txtDate);

        }
    }
}
