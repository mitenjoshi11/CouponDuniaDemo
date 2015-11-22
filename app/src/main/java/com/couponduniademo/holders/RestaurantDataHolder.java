package com.couponduniademo.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.couponduniademo.R;

/**
 * Created by Miten on 11/21/2015.
 */
public class RestaurantDataHolder extends RecyclerView.ViewHolder {

    public ImageView imgLogoUrl;
    public TextView txtOutletName;
    public TextView txtNumberOfCoupouns;
    public ImageView imgLocation;
    public TextView txtDistance;
    public LinearLayout lnrMiddle;

    public RestaurantDataHolder(View itemView) {
        super(itemView);

        this.imgLogoUrl = (ImageView) itemView.findViewById(R.id.imgLogoUrl);
        this.txtOutletName = (TextView) itemView.findViewById(R.id.txtOutletName);
        this.txtNumberOfCoupouns = (TextView) itemView.findViewById(R.id.txtNumberOfCoupouns);
        this.imgLocation = (ImageView) itemView.findViewById(R.id.imgLocation);
        this.txtDistance = (TextView) itemView.findViewById(R.id.txtDistance);
        this.lnrMiddle = (LinearLayout)itemView.findViewById(R.id.lnrMiddle);
    }
}
