package com.example.dental.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.activities.OrderActivity;
import com.example.dental.R;
import com.example.dental.models.BookingTimeModel;

import java.util.ArrayList;

public class BookingTimeAdapter extends RecyclerView.Adapter<BookingTimeAdapter.RecyclerViewHolder> {
    private ArrayList<BookingTimeModel> bookingTimeModels;
    private Context mContext;

    public BookingTimeAdapter(Context mContext, ArrayList<BookingTimeModel> productModels) {
        this.bookingTimeModels = productModels;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_booking_time_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.bookingTime.setText(bookingTimeModels.get(position).getTime());
        holder.bookingPrice.setText(bookingTimeModels.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return bookingTimeModels.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView bookingTime;
        TextView bookingPrice;
        CardView bookingTimeContainer;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            bookingTime = (TextView) itemView.findViewById(R.id.bookingTimeTextView);
            bookingPrice = (TextView) itemView.findViewById(R.id.bookingPriceTextView);
            bookingTimeContainer = (CardView) itemView.findViewById(R.id.bookingTimeContainer);
            bookingTimeContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, OrderActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
