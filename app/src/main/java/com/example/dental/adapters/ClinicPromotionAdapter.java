package com.example.dental.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.activities.PopActivity;
import com.example.dental.models.ServiceModel;

import java.util.ArrayList;

public class ClinicPromotionAdapter extends RecyclerView.Adapter<ClinicPromotionAdapter.RecyclerViewHolder> {
    private ArrayList<ServiceModel> serviceList;
    private Context mContext;
    private ServiceModel model;

    public ClinicPromotionAdapter(Context mContext, ArrayList<ServiceModel> productModels) {
        this.serviceList = productModels;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_clinic_service_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.clinicId.setText(serviceList.get(position).getId() + "");
        holder.clinicName.setText(serviceList.get(position).getName());
//        holder.clinicOldPrice.setText(String.format("%,d", serviceList.get(position).getOldPrice()) + " đ");
        holder.clinicPrice.setText(String.format("%,d", serviceList.get(position).getPrice()) + " đ");
        holder.clinicDescription.setText(serviceList.get(position).getDescription());
//        holder.clinicDiscount.setText(serviceList.get(position).getDiscountPercent() + "%");
//        Picasso.get().load(serviceList.get(position).getImage()).into(holder.clinicImage);
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView clinicName;
        TextView clinicId;
        TextView clinicPrice;
        TextView clinicOldPrice;
        TextView clinicDiscount;
        TextView clinicDescription;
        ImageView clinicImage;
        LinearLayout serviceLayout;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            serviceLayout = itemView.findViewById(R.id.serviceLinearLayout);
            clinicId = itemView.findViewById(R.id.itemId);
            clinicName = itemView.findViewById(R.id.itemNameTextView);
            clinicOldPrice = itemView.findViewById(R.id.itemOldPriceTextView);
            clinicPrice = itemView.findViewById(R.id.itemPriceTextView);
            clinicDiscount = itemView.findViewById(R.id.itemDiscountTextView);
            clinicDescription = itemView.findViewById(R.id.itemDescriptionTextView);
            clinicImage = itemView.findViewById(R.id.itemImage);
            serviceLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, PopActivity.class);
                    for (ServiceModel service : serviceList) {
                        if (service.getId().equalsIgnoreCase(clinicId.getText().toString().trim())) {
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
