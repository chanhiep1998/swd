package com.example.dental.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.activities.DetailedActivity;
import com.example.dental.models.ClinicModel;
import com.example.dental.models.ClinicModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeNearbyAdapter extends RecyclerView.Adapter<HomeNearbyAdapter.RecyclerViewHolder> {


    private ArrayList<ClinicModel> clinicList;
    private Context mContext;

    public HomeNearbyAdapter(Context mContext, ArrayList<ClinicModel> productModels) {
        this.clinicList = productModels;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_clinic_nearby_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.clinicId.setText(clinicList.get(position).getId() + "");
        holder.clinicName.setText(clinicList.get(position).getName());
//        holder.clinicRating.setText(clinicList.get(position).getServiceRating() + "");
        holder.clinicOldPrice.setText(String.format("%,d", clinicList.get(position).getOldPrice()) + " đ");
        holder.clinicPrice.setText(String.format("%,d", clinicList.get(position).getPrice()) + " đ");
        holder.clinicDescription.setText(clinicList.get(position).getDescription());
        holder.clinicDiscount.setText(clinicList.get(position).getDiscountPercent() + "%");
        Picasso.get().load(clinicList.get(position).getImage()).into(holder.clinicImage);
    }

    @Override
    public int getItemCount() {
        return clinicList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView clinicName;
        TextView clinicPrice;
        TextView clinicOldPrice;
        TextView clinicDiscount;
        TextView clinicDescription;
        TextView clinicRating;
        TextView clinicId;
        ImageView clinicImage;
        CardView clinicCardView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            clinicCardView = itemView.findViewById(R.id.clinicCardView);
            clinicId = itemView.findViewById(R.id.itemId);
            clinicName = itemView.findViewById(R.id.itemNameTextView);
            clinicOldPrice = itemView.findViewById(R.id.itemOldPriceTextView);
            clinicPrice = itemView.findViewById(R.id.itemPriceTextView);
            clinicDiscount = itemView.findViewById(R.id.itemDiscountTextView);
            clinicRating = itemView.findViewById(R.id.itemRating);
            clinicDescription = itemView.findViewById(R.id.itemDescriptionTextView);
            clinicImage = itemView.findViewById(R.id.itemImage);
            clinicCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, DetailedActivity.class);
                    intent.putExtra("id", clinicId.getText());
                    intent.putExtra("isClinic", "service");
                    Toast.makeText(mContext, clinicId.getText().toString(), Toast.LENGTH_SHORT).show();
                    mContext.startActivity(intent);
                }
            });
        }
    }


}
