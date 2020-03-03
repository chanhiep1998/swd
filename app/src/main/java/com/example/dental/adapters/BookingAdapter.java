package com.example.dental.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.activities.BookingDetailActivity;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.BookingViewHolder> {
    String data1[], data2[];
    int images[];
    Context context;

    public BookingAdapter(Context context, String[] s1, String[] s2, int[] images) {
        this.context = context;
        data1 = s1;
        data2 = s2;
        this.images = images;
    }

    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.booking_item, parent, false);
        return new BookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, final int position) {
        holder.text1.setText(HtmlCompat.fromHtml(data1[position], HtmlCompat.FROM_HTML_MODE_LEGACY));
        holder.text2.setText(HtmlCompat.fromHtml(data2[position], HtmlCompat.FROM_HTML_MODE_LEGACY));
        holder.image.setImageResource(images[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BookingDetailActivity.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                intent.putExtra("myImage", images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class BookingViewHolder extends RecyclerView.ViewHolder {
        TextView text1, text2;
        ImageView image;
        ConstraintLayout mainLayout;

        public BookingViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.programming_text);
            text2 = itemView.findViewById(R.id.description_text);
            image = itemView.findViewById(R.id.booking_image);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
