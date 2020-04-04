package com.example.dental.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.activities.DetailedActivity;
import com.example.dental.models.ClinicModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeRecommendedAdapter extends RecyclerView.Adapter<HomeRecommendedAdapter.RecyclerViewHolder> {


    private ArrayList<ClinicModel> clinicList;
    private Context mContext;

    public HomeRecommendedAdapter(Context mContext, ArrayList<ClinicModel> productModels) {
        this.clinicList = productModels;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_clinic_highly_recommend_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.clinicId.setText(clinicList.get(position).getId() + "");
//        holder.userName.setText(clinicList.get(position).getComments().get(position).getUserName());
//        holder.comment.setText(clinicList.get(position).getComments().get(position).getComment());
//        holder.serviceRatingBar.setRating(clinicList.get(position).getComments().get(position).getServiceRating());
//        holder.clinicRatingBar.setRating(clinicList.get(position).getServiceRating());
//        Picasso.get().load(clinicList.get(position).getComments().get(position).getUserImage()).into(holder.userImage);
//        holder.clinicName.setText(clinicList.get(position).getName());
//        holder.clinicOldPrice.setText(String.format("%,d", clinicList.get(position).getOldPrice()) + " đ");
//        holder.clinicRating.setText(clinicList.get(position).getServiceRating() + "");
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
        TextView clinicRating;
        TextView clinicDescription;
        TextView clinicId;
        ImageView clinicImage;

        TextView userName;
        TextView comment;
        RatingBar clinicRatingBar;
        RatingBar serviceRatingBar;
        ImageView userImage;
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
            clinicImage = (ImageView) itemView.findViewById(R.id.itemImage);
            userName = itemView.findViewById(R.id.userNameTextView);
            comment = itemView.findViewById(R.id.commentTextView);
            clinicRatingBar = (RatingBar) itemView.findViewById(R.id.clinicRatingBar);
            serviceRatingBar = (RatingBar) itemView.findViewById(R.id.serviceRateRatingBar);
            userImage = (ImageView) itemView.findViewById(R.id.userImageImageView);
            serviceRatingBar = (RatingBar) itemView.findViewById(R.id.serviceRateRatingBar);
            userImage = (ImageView) itemView.findViewById(R.id.userImageImageView);
            clinicCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, DetailedActivity.class);
                    intent.putExtra("id", clinicId.getText());
                    intent.putExtra("isClinic", "service");
                    mContext.startActivity(intent);
                }
            });
        }
    }


}
