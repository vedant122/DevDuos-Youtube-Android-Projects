package com.devduos.bmicalculator;

import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
//

public class ageRCadapter extends RecyclerView.Adapter<ageRCadapter.AgeViewHolder> {
    private List<Integer> ageList;
    private int selectedItem = -1;

    private int centeredPosition = RecyclerView.NO_POSITION;

    // Method to set the centered position
    public void setCenteredPosition(int position) {
        centeredPosition = position;
    }

    // Method to get the centered position
    public int getCenteredPosition() {
        return centeredPosition;
    }

    public void clearCenteredPosition() {
        centeredPosition = RecyclerView.NO_POSITION;
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private static OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    public ageRCadapter(List<Integer> ageList) {
        this.ageList = ageList;
    }
    @NonNull
    @Override
    public AgeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.agescroll, parent, false);
        return new AgeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AgeViewHolder holder, int position) {
        Integer age=ageList.get(position);
        holder.textAge.setText(String.valueOf(age));
        if(age!=null){
            if(position==selectedItem){
                holder.textAge.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
                holder.textAge.setBackgroundColor(Color.BLACK);

            }else{
                holder.textAge.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                holder.textAge.setTextColor(Color.WHITE);
            }}else{
            holder.textAge.setText("") ;
        }
    }

    @Override
    public int getItemCount() {
        return ageList.size();
    }

    public void setSelectedItem(int position){
        selectedItem=position;
        notifyDataSetChanged();
    }
    static class AgeViewHolder extends RecyclerView.ViewHolder {
        TextView textAge;
        public AgeViewHolder(@NonNull View itemView) {
            super(itemView);
            textAge=itemView.findViewById(R.id.textAge);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener!=null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
