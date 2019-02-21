package com.zammle2009wtfgmail.guildwars2companionapplication3;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.TextView;
import java.util.ArrayList;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ExampleViewHolder>
{

    private ArrayList<itemHolder> mTemplateList;

    private OnItemClickListener mListener;

    public interface OnItemClickListener
    {
        void OnItemClick(int position);
    }



    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener = listener;
    }

    public  class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView mItemIcon;
        public ImageView mInfusion1;
        public ImageView mInfusion2;
        public ImageView mInfusion3;
        public TextView mItemName;
        public TextView mItemType;

        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            mItemName = itemView.findViewById(R.id.itemname);
            mItemType = itemView.findViewById(R.id.itemtype);
            mItemIcon = itemView.findViewById(R.id.itemimage);
            mInfusion1 = itemView.findViewById(R.id.infusion1);
            mInfusion2 = itemView.findViewById(R.id.infusion2);
            mInfusion3 = itemView.findViewById(R.id.infusion3);

            mItemIcon.getLayoutParams().width = 59;
            mItemIcon.getLayoutParams().height = 59;

            mInfusion1.getLayoutParams().width = 31;
            mInfusion1.getLayoutParams().height = 31;
            mInfusion2.getLayoutParams().width = 31;
            mInfusion2.getLayoutParams().height = 31;
            mInfusion3.getLayoutParams().width = 31;
            mInfusion3.getLayoutParams().height = 31;

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    if (listener != null)
                    {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION)
                        {
                            listener.OnItemClick(position);
                        }
                    }
                }
            });



             //////////////////////////////////////////
             ///// where i put button functions ///////
            ///////////////////////////////////////////








            ///////////////////////////////////////////////
        }



    }

    public itemAdapter(ArrayList<itemHolder> templateList)
    {
        mTemplateList = templateList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }



    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position)
    {

        ////////////////////////////////
        /// Rules for each item ////////
        ////////////////////////////////


        //// example ///////////////

        /**
        holder.mNumber.setMaxValue(120);
        holder.mNumber.setMinValue(5);
         **/





        ////////////////////////////////


        itemHolder currentItem = mTemplateList.get(position);




        /**

        if (currentItem.GetVis() == false)
        {
            // holder.mNumber.setVisibility(View.INVISIBLE);
            holder.clock.setVisibility(View.INVISIBLE);
            holder.White.setVisibility(View.INVISIBLE);
            holder.IsChecked.setVisibility(View.INVISIBLE);
            holder.realnum.setVisibility(View.INVISIBLE);
        }

         **/


        try {

            holder.mItemIcon.setImageDrawable(currentItem.GetItemIcon());
        }
        catch (Exception e)
        {

        }
        try {

            holder.mInfusion1.setImageDrawable(currentItem.getInfusion1Icon());
        }
        catch (Exception e)
        {
            holder.mInfusion1.setVisibility(View.INVISIBLE);
        }
        try {

            holder.mInfusion2.setImageDrawable(currentItem.getInfusion2Icon());
        }
        catch (Exception e)
        {
            holder.mInfusion2.setVisibility(View.INVISIBLE);
        }
        try {

            holder.mInfusion2.setImageDrawable(currentItem.getInfusion3Icon());
        }
        catch (Exception e)
        {
            holder.mInfusion3.setVisibility(View.INVISIBLE);
        }

        holder.mItemName.setText(currentItem.GetItemName());
        holder.mItemType.setText(currentItem.getItemType());




    }

    @Override
    public int getItemCount() {
        return mTemplateList.size();
    }

}
