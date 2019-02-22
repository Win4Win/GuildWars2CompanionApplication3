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

        public TextView mItemName;
        public TextView mItemType;

        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            mItemName = itemView.findViewById(R.id.itemname);
            mItemType = itemView.findViewById(R.id.itemtype);
            mItemIcon = itemView.findViewById(R.id.itemimage);


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

            holder.mItemIcon.setImageDrawable(currentItem.getItemIcon());
        }
        catch (Exception e)
        {

        }


        holder.mItemName.setText(currentItem.GetItemName());
        holder.mItemType.setText(currentItem.getItemType());




    }

    @Override
    public int getItemCount() {
        return mTemplateList.size();
    }

}
