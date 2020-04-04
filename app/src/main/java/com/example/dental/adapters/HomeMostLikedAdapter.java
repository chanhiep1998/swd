package com.example.dental.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.activities.DetailedActivity;
import com.example.dental.models.ServiceModel;

import java.util.ArrayList;

public class HomeMostLikedAdapter extends RecyclerView.Adapter<HomeMostLikedAdapter.RecyclerViewHolder> {
    private ArrayList<ServiceModel> clinicList;
    private Context mContext;
    private ServiceModel model;


    public HomeMostLikedAdapter(Context mContext, ArrayList<ServiceModel> productModels) {
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
        holder.clinicName.setText(clinicList.get(position).getName());
        holder.clinicId.setText(clinicList.get(position).getId() + "");
//        holder.clinicOldPrice.setText(String.format("%,d", clinicList.get(position).getOldPrice()) + " đ");
//        holder.clinicRating.setText(clinicList.get(position).getServiceRating() + "");
//        holder.clinicPrice.setText(String.format("%,d", clinicList.get(position).getPrice()) + " đ");
        holder.clinicPrice.setText(String.format("%,d", clinicList.get(position).getPrice()) + " đ");
        holder.clinicDescription.setText(clinicList.get(position).getClinic().getName() + "");
//        holder.clinicDiscount.setText(clinicList.get(position).getDiscountPercent() + "%");
//        Picasso.get().load(clinicList.get(position).getImage()).into(holder.clinicImage);
    }

    @Override
    public int getItemCount() {
        return clinicList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView clinicId;
        TextView clinicName;
        TextView clinicPrice;
        TextView clinicOldPrice;
        TextView clinicDiscount;
        TextView clinicRating;
        TextView clinicDescription;
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
                    for (ServiceModel service : clinicList) {
                        if (service.getId().trim().equalsIgnoreCase(clinicId.getText().toString().trim())) {
                            model = service;
                        }
                    }
                    intent.putExtra("serviceObj", model);
                    intent.putExtra("isClinic", "service");
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
