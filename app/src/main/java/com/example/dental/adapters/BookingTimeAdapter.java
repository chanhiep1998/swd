package com.example.dental.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.activities.BookingDetailActivity;
import com.example.dental.activities.BookingSummary;
import com.example.dental.models.BookingTimeModel;

import java.util.ArrayList;

public class BookingTimeAdapter extends RecyclerView.Adapter<BookingTimeAdapter.RecyclerViewHolder> {
    private ArrayList<BookingTimeModel> bookingTimeModels;
    private Context context;

    public BookingTimeAdapter(Context context, ArrayList<BookingTimeModel> productModels) {
        this.bookingTimeModels = productModels;
        this.context = context;
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
        int count = bookingTimeModels.get(position).getPeople();
        if (count == 0) {
            holder.people.setTextColor(Color.GRAY);
        } else if (count < 4) {
            holder.people.setTextColor(Color.parseColor("#68bb6c"));
        } else if (count < 8) {
            holder.people.setTextColor(Color.parseColor("#cc7832"));
        } else if (count < 12) {
            holder.people.setTextColor(Color.RED);
        }
        holder.people.setText(bookingTimeModels.get(position).getPeople() + " đã hẹn");

    }

    @Override
    public int getItemCount() {
        return bookingTimeModels.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView bookingTime;
        TextView bookingPrice;
        TextView people;
        CardView bookingTimeContainer;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            bookingTime = itemView.findViewById(R.id.bookingTimeTextView);
            bookingPrice = itemView.findViewById(R.id.bookingPriceTextView);
            people = itemView.findViewById(R.id.peopleCountTextView);
            bookingTimeContainer = itemView.findViewById(R.id.bookingTimeContainer);
            bookingTimeContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BookingSummary.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    context.startActivity(intent);
                }
            });
        }
    }
}
