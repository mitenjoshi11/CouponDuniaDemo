package com.couponduniademo.entities;

import java.util.ArrayList;

/**
 * Created by Miten on 11/21/2015.
 */
public class Data {

    private String SubFranchiseID;

    private String OutletID;

    private String OutletName;

    private String BrandID;

    private String Address;

    private String NeighbourhoodID;

    private String CityID;

    private String Email;

    private String Timings;

    private String CityRank;

    private String Latitude;

    private String Longitude;

    private String Pincode;

    private String Landmark;

    private String Streetname;

    private String BrandName;

    private String OutletURL;

    private String NumCoupons;

    private String NeighbourhoodName;

    private String PhoneNumber;

    private String CityName;

    private String Distance;

    private ArrayList<Categories> Categories;

    private String LogoURL;

    private String CoverURL;

    public String getNeighbourhoodName() {
        return NeighbourhoodName;
    }

    public void setNeighbourhoodName(String NeighbourhoodName) {
        this.NeighbourhoodName = NeighbourhoodName;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public String getTimings() {
        return Timings;
    }

    public void setTimings(String Timings) {
        this.Timings = Timings;
    }

    public String getNumCoupons() {
        return NumCoupons;
    }

    public void setNumCoupons(String NumCoupons) {
        this.NumCoupons = NumCoupons;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String Pincode) {
        this.Pincode = Pincode;
    }

    public ArrayList<Categories> getCategories() {
        return Categories;
    }

    public void setCategories(ArrayList<Categories> categories) {
        Categories = categories;
    }

    public String getLogoURL() {
        return LogoURL;
    }

    public void setLogoURL(String LogoURL) {
        this.LogoURL = LogoURL;
    }

    public String getSubFranchiseID() {
        return SubFranchiseID;
    }

    public void setSubFranchiseID(String SubFranchiseID) {
        this.SubFranchiseID = SubFranchiseID;
    }

    public String getBrandID() {
        return BrandID;
    }

    public void setBrandID(String BrandID) {
        this.BrandID = BrandID;
    }

    public String getLandmark() {
        return Landmark;
    }

    public void setLandmark(String Landmark) {
        this.Landmark = Landmark;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String Latitude) {
        this.Latitude = Latitude;
    }

    public String getNeighbourhoodID() {
        return NeighbourhoodID;
    }

    public void setNeighbourhoodID(String NeighbourhoodID) {
        this.NeighbourhoodID = NeighbourhoodID;
    }

    public String getCoverURL() {
        return CoverURL;
    }

    public void setCoverURL(String CoverURL) {
        this.CoverURL = CoverURL;
    }

    public String getCityID() {
        return CityID;
    }

    public void setCityID(String CityID) {
        this.CityID = CityID;
    }

    public String getOutletName() {
        return OutletName;
    }

    public void setOutletName(String OutletName) {
        this.OutletName = OutletName;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String Distance) {
        this.Distance = Distance;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getStreetname() {
        return Streetname;
    }

    public void setStreetname(String Streetname) {
        this.Streetname = Streetname;
    }

    public String getCityRank() {
        return CityRank;
    }

    public void setCityRank(String CityRank) {
        this.CityRank = CityRank;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getOutletID() {
        return OutletID;
    }

    public void setOutletID(String OutletID) {
        this.OutletID = OutletID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }

    public String getOutletURL() {
        return OutletURL;
    }

    public void setOutletURL(String OutletURL) {
        this.OutletURL = OutletURL;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    @Override
    public String toString() {
        return "Data [NeighbourhoodName = " + NeighbourhoodName + ", CityName = " + CityName + ", Timings = " + Timings + ", NumCoupons = " + NumCoupons + ", Pincode = " + Pincode + ", Categories = " + Categories + ", LogoURL = " + LogoURL + ", SubFranchiseID = " + SubFranchiseID + ", BrandID = " + BrandID + ", Landmark = " + Landmark + ", Latitude = " + Latitude + ", NeighbourhoodID = " + NeighbourhoodID + ", CoverURL = " + CoverURL + ", CityID = " + CityID + ", OutletName = " + OutletName + ", Distance = " + Distance + ", PhoneNumber = " + PhoneNumber + ", Streetname = " + Streetname + ", CityRank = " + CityRank + ", Email = " + Email + ", OutletID = " + OutletID + ", Address = " + Address + ", Longitude = " + Longitude + ", OutletURL = " + OutletURL + ", BrandName = " + BrandName + "]";
    }
}
