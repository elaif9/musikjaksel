package com.fcfas.musikjaksel.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Indie implements Parcelable {
    private String name, category, remarks, photo, linkcontent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLinkcontent() {
        return linkcontent;
    }

    public void setLinkcontent(String linkcontent) {
        this.linkcontent = linkcontent;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.category);
        dest.writeString(this.remarks);
        dest.writeString(this.photo);
        dest.writeString(this.linkcontent);
    }
    public Indie(){}
    protected Indie(Parcel in){
        this.name = in.readString();
        this.category= in.readString();
        this.remarks = in.readString();
        this.photo = in.readString();
        this.linkcontent = in.readString();
    }

    public static final Parcelable.Creator<Indie> CREATOR = new Parcelable.Creator<Indie>(){
        @Override
        public Indie createFromParcel(Parcel source){
            return new Indie(source);
        }
        @Override
        public Indie[] newArray(int size){
            return new Indie[size];
        }
    };
}
