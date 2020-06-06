package com.deng.communityprogram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.deng.communityprogram.R;
import com.deng.communityprogram.widget.Messages;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private ArrayList<Messages> messagesArrayList;

    public ChatAdapter(ArrayList<Messages> messages){
        this.messagesArrayList = messages;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Messages msg = messagesArrayList.get(position);
        if (msg.getType() == Messages.TYPE_OTHER) {
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);

            holder.name_other.setText(msg.getName());
            holder.message_other.setText(msg.getMessage());
            holder.date_other.setText(msg.getDate());
        } else if (msg.getType() == Messages.TYPE_MINE) {
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.leftLayout.setVisibility(View.GONE);

            holder.name_mine.setText(msg.getName());
            holder.message_mine.setText(msg.getMessage());
            holder.date_mine.setText(msg.getDate());
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return messagesArrayList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout leftLayout;
        ConstraintLayout rightLayout;
        TextView name_mine;
        TextView name_other;
        TextView date_mine;
        TextView date_other;
        TextView message_mine;
        TextView message_other;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            leftLayout =  itemView.findViewById(R.id.left_chat);
            rightLayout =  itemView.findViewById(R.id.right_chat);

            message_mine = (TextView) itemView.findViewById(R.id.message_mine);
            message_other = (TextView) itemView.findViewById(R.id.message_other);
            name_mine = (TextView) itemView.findViewById(R.id.name_mine);
            name_other = (TextView) itemView.findViewById(R.id.name_other);
            date_mine = (TextView) itemView.findViewById(R.id.time_mine);
            date_other = (TextView) itemView.findViewById(R.id.time_other);
        }
    }
}
