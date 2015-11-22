package com.couponduniademo.adapters;

import android.content.Context;
import android.graphics.Color;
import android.location.LocationManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.couponduniademo.R;
import com.couponduniademo.entities.Data;
import com.couponduniademo.holders.RestaurantDataHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Miten on 11/21/2015.
 */
public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantDataHolder> {

    private boolean gps_enabled, network_enabled;
    private ArrayList<Data> restaturantsData;
    private Context mContext;
    private LocationManager locationManager;
    private double sourcelatitude;
    private double sourcelong;

    public RestaurantAdapter(Context context, ArrayList<Data> restaturantsData, final double sourcelatitude, final double sourcelong) {
        this.restaturantsData = restaturantsData;
        this.mContext = context;
        this.sourcelatitude = sourcelatitude;
        this.sourcelong = sourcelong;

        Collections.sort(this.restaturantsData, new Comparator<Data>() {
            @Override
            public int compare(Data lhs, Data rhs) {
                Float distance1 = distFrom((float) sourcelatitude, (float) sourcelong, Float.parseFloat(lhs.getLatitude()), Float.parseFloat(lhs.getLongitude()));
                Float distance2 = distFrom((float) sourcelatitude, (float) sourcelong, Float.parseFloat(rhs.getLatitude()), Float.parseFloat(rhs.getLongitude()));
                return distance1.compareTo(distance2);
            }
        });
    }

    // Calculate Distance from Source latlong to destination latlong
    public static float distFrom(float lat1, float lng1, float lat2, float lng2) {
        double earthRadius = 3958.75;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double dist = earthRadius * c;

        int meterConversion = 1609;

        return new Float(dist * meterConversion).floatValue();
    }

    @Override
    public RestaurantDataHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, null);
        RestaurantDataHolder mh = new RestaurantDataHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(RestaurantDataHolder holder, int position) {

        Data restaurantItem = restaturantsData.get(position);

        Picasso.with(mContext).load(restaurantItem.getLogoURL())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imgLogoUrl);

        holder.txtOutletName.setText(restaurantItem.getOutletName());
        holder.txtNumberOfCoupouns.setText(restaurantItem.getNumCoupons() + mContext.getString(R.string.offers));
        holder.imgLocation.setImageResource(R.drawable.map);
        holder.imgLocation.setColorFilter(Color.parseColor("#33B5E5"));


        if (restaurantItem.getCategories().size() > 0) { // Call When Categories Size greater then 0
            holder.lnrMiddle.removeAllViews();// First remove all views otherwise its overlapping
            for (int i = 0; i < restaurantItem.getCategories().size(); i++) {
                String categoryName = restaurantItem.getCategories().get(i).getCategoryType();
                if (!categoryName.equalsIgnoreCase("")) {// check for category name because everytime Restaurant is coming when category name is empty.
                    TextView textView = new TextView(mContext);
                    textView.setText(restaurantItem.getCategories().get(i).getName());
                    textView.setPadding(5, 0, 10, 0);
                    textView.setTextSize(14);
                    textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.category, 0, 0, 0);
                    textView.setCompoundDrawablePadding(15);
                    textView.setSingleLine(true);
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    holder.lnrMiddle.addView(textView);
                }
            }
        }
        holder.txtDistance.setText(distFrom((float) sourcelatitude, (float) sourcelong, Float.parseFloat(restaurantItem.getLatitude()), Float.parseFloat(restaurantItem.getLongitude())) + " m " + restaurantItem.getNeighbourhoodName());

    }

    @Override
    public int getItemCount() {
        return (null != restaturantsData ? restaturantsData.size() : 0);
    }
}
