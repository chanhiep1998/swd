package com.example.dental.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dental.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private Context context;
    private int mCount;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public void setCount(int count) {
        this.mCount = count;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.auto_slide_item, null);
        return new SliderAdapterVH(inflate);
    }

    public
    int slide = 0;

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        if (slide == 0) {
            switch (position) {
                case 0:
                    viewHolder.imageViewBackground.setBackgroundResource(R.drawable.banner1);
                    break;

                case 1:
                    viewHolder.imageViewBackground.setBackgroundResource(R.drawable.banner2);

                    break;
                case 2:
                    viewHolder.imageViewBackground.setBackgroundResource(R.drawable.banner3);

                case 3:
                    viewHolder.imageViewBackground.setBackgroundResource(R.drawable.banner4);

                    break;

            }
        } else if (slide == 1) {
            switch (position) {
                case 0:
                    viewHolder.imageViewBackground.setBackgroundResource(R.drawable.dental03);
                    break;

                case 1:
                    viewHolder.imageViewBackground.setBackgroundResource(R.drawable.dental04);

                    break;
                case 2:
                    viewHolder.imageViewBackground.setBackgroundResource(R.drawable.dental02);

                    break;
                default:
                    viewHolder.imageViewBackground.setBackgroundResource(R.drawable.dental04);
                    break;

            }
        }
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mCount;
    }


    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }
}
