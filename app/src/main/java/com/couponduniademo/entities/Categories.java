package com.couponduniademo.entities;

/**
 * Created by Miten on 11/21/2015.
 */
public class Categories {

    private String OfflineCategoryID;

    private String Name;

    private String ParentCategoryID;

    private String CategoryType;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCategoryType() {
        return CategoryType;
    }

    public void setCategoryType(String CategoryType) {
        this.CategoryType = CategoryType;
    }

    public String getParentCategoryID() {
        return ParentCategoryID;
    }

    public void setParentCategoryID(String ParentCategoryID) {
        this.ParentCategoryID = ParentCategoryID;
    }

    public String getOfflineCategoryID() {
        return OfflineCategoryID;
    }

    public void setOfflineCategoryID(String OfflineCategoryID) {
        this.OfflineCategoryID = OfflineCategoryID;
    }

    @Override
    public String toString() {
        return "ClassPojo [Name = " + Name + ", CategoryType = " + CategoryType + ", ParentCategoryID = " + ParentCategoryID + ", OfflineCategoryID = " + OfflineCategoryID + "]";
    }
}
