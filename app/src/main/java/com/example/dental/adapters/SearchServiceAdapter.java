package com.example.dental.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.activities.PopActivity;
import com.example.dental.models.ServiceModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class SearchServiceAdapter extends RecyclerView.Adapter<SearchServiceAdapter.RecyclerViewHolder> implements Filterable {


    private ArrayList<ServiceModel> clinicList;
    private ArrayList<ServiceModel> clinicListAll;
    private Context mContext;
    private ServiceModel model;


    public SearchServiceAdapter(Context mContext, ArrayList<ServiceModel> productModels) {
        this.clinicList = productModels;
        this.mContext = mContext;
        this.clinicListAll = new ArrayList<>(clinicList);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_clinic_service_item, parent, false);
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
        holder.clinicName.setText(clinicList.get(position).getName() + "");
//        holder.clinicOldPrice.setText(String.format("%,d", clinicList.get(position).getOldPrice()) + " đ");
//        holder.clinicRating.setText(clinicList.get(position).getServiceRating() + "");
//        holder.clinicRating.setText(Math.round(star * 10) / 10.0 + "");
        holder.clinicPrice.setText(String.format("%,d", clinicList.get(position).getPrice()) + " đ");
//        holder.clinicRatingBar.setRating(star);
        holder.clinicDescription.setText(clinicList.get(position).getDescription());
//        holder.clinicDiscount.setText(clinicList.get(position).getDiscountPercent() + "%");
//        Picasso.get().load(clinicList.get(position).getImage()).into(holder.clinicImage);
    }

    @Override
    public int getItemCount() {
        return clinicList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ServiceModel> filterList = new ArrayList<>();

            if (constraint.toString().isEmpty()) {
                filterList.addAll(clinicListAll);
            } else {
                for (ServiceModel clinic : clinicListAll) {
                    if (clinic.getName().toLowerCase().trim().contains(constraint.toString().trim().toLowerCase())) {
                        filterList.add(clinic);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clinicList.clear();
            clinicList.addAll((Collection<? extends ServiceModel>) results.values);
            notifyDataSetChanged();
        }
    };

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView clinicId;
        TextView clinicName;
        TextView clinicPrice;
        TextView clinicOldPrice;

        TextView clinicDiscount;
        TextView clinicDescription;
        ImageView clinicImage;
        TextView clinicRating;
        RatingBar clinicRatingBar;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            clinicId = itemView.findViewById(R.id.itemId);
            clinicName = itemView.findViewById(R.id.itemNameTextView);
            clinicOldPrice = itemView.findViewById(R.id.itemOldPriceTextView);
            clinicRating = itemView.findViewById(R.id.itemRating);
            clinicPrice = itemView.findViewById(R.id.itemPriceTextView);
            clinicRatingBar = itemView.findViewById(R.id.clinicRatingBar);
            clinicDiscount = itemView.findViewById(R.id.itemDiscountTextView);
            clinicDescription = itemView.findViewById(R.id.itemDescriptionTextView);
            clinicImage = itemView.findViewById(R.id.itemImage);
            clinicName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, PopActivity.class);
                    for (ServiceModel service : clinicList) {
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
