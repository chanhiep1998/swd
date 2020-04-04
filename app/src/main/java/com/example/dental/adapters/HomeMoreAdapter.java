package com.example.dental.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.activities.DetailedActivity;
import com.example.dental.models.ClinicModel;
import com.example.dental.models.ServiceModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class HomeMoreAdapter extends RecyclerView.Adapter<HomeMoreAdapter.RecyclerViewHolder> {


    private ArrayList<ClinicModel> clinicList;
    private Context mContext;
    private ServiceModel model;

    public HomeMoreAdapter(Context mContext, ArrayList<ClinicModel> productModels) {
        this.clinicList = productModels;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_clinic_more_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    public float generateRating(float min, float max) {
        Random rd = new Random();
        return rd.nextFloat() * (max - min) + min;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        float star = generateRating(3, 5);
        holder.clinicId.setText(clinicList.get(position).getId() + "");
        holder.clinicName.setText(clinicList.get(position).getName());
//        holder.clinicOldPrice.setText(String.format("%,d", clinicList.get(position).getOldPrice()) + " đ");
//        holder.clinicRating.setText(clinicList.get(position).getServiceRating() + "");

//        holder.clinicRating.setText(Math.round(star * 10) / 10.0 + "");
//        holder.clinicRatingBar.setRating(star);
//        holder.clinicPrice.setText(String.format("%,d", clinicList.get(position).getPrice()) + " đ");
        holder.clinicDescription.setText(clinicList.get(position).getDescription());
        holder.clinicAddress.setText(clinicList.get(position).getAddress());
//        holder.clinicDiscount.setText(clinicList.get(position).getDiscountPercent() + "%");
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
        TextView clinicAddress;
        ImageView clinicImage;
        TextView clinicId;
        TextView clinicRating;
        RatingBar clinicRatingBar;
        LinearLayout serviceLinearLayout;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            clinicId = itemView.findViewById(R.id.itemId);
            clinicName = itemView.findViewById(R.id.itemNameTextView);
            clinicOldPrice = itemView.findViewById(R.id.itemOldPriceTextView);
            clinicPrice = itemView.findViewById(R.id.itemPriceTextView);
            clinicDiscount = itemView.findViewById(R.id.itemDiscountTextView);
            clinicRating = itemView.findViewById(R.id.itemRating);
            clinicRatingBar = itemView.findViewById(R.id.clinicRatingBar);
            clinicDescription = itemView.findViewById(R.id.itemDescriptionTextView);
            clinicAddress = itemView.findViewById(R.id.itemAddress);
            clinicImage = itemView.findViewById(R.id.itemImage);
            serviceLinearLayout = itemView.findViewById(R.id.serviceLinearLayout);
            serviceLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, DetailedActivity.class);
                    model = new ServiceModel();
                    for (ClinicModel service : clinicList) {
                        if (service.getId() == Integer.parseInt(clinicId.getText().toString().trim())) {
                            model.setClinic(service);
                        }
                    }
                    intent.putExtra("serviceObj", model);
                    intent.putExtra("isClinic", "clinic");
                    mContext.startActivity(intent);
                }
            });
        }
    }


}
