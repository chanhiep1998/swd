package com.example.dental.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.activities.ClinicDetailActivity;
import com.example.dental.R;
import com.example.dental.models.ClinicModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeDiscountAdapter extends RecyclerView.Adapter<HomeDiscountAdapter.RecyclerViewHolder> {
    private ArrayList<ClinicModel> clinicList;
    private Context mContext;

    public HomeDiscountAdapter(Context mContext, ArrayList<ClinicModel> productModels) {
        this.clinicList = productModels;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_clinic_most_discout_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.clinicName.setText(clinicList.get(position).getName());
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
        ImageView clinicImage;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            clinicName = (TextView) itemView.findViewById(R.id.itemNameTextView);
            clinicOldPrice = (TextView) itemView.findViewById(R.id.itemOldPriceTextView);
            clinicPrice = (TextView) itemView.findViewById(R.id.itemPriceTextView);
            clinicDiscount = (TextView) itemView.findViewById(R.id.itemDiscountTextView);
            clinicDescription = (TextView) itemView.findViewById(R.id.itemDescriptionTextView);
            clinicImage = (ImageView) itemView.findViewById(R.id.itemImage);
            clinicName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, ClinicDetailActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
