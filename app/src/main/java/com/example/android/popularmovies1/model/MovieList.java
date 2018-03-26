package com.example.android.popularmovies1.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by franc on 13/03/2018.
 */

public class MovieList implements Parcelable {

    private int page;
    private int totalResults;
    private int totalPages;
    private List<Movie> results = null;

    public MovieList() {
    }

    protected MovieList(Parcel in) {
        page = in.readInt();
        totalResults = in.readInt();
        totalPages = in.readInt();
        results = in.createTypedArrayList(Movie.CREATOR);
    }

    public static final Creator<MovieList> CREATOR = new Creator<MovieList>() {
        @Override
        public MovieList createFromParcel(Parcel in) {
            return new MovieList(in);
        }

        @Override
        public MovieList[] newArray(int size) {
            return new MovieList[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(page);
        parcel.writeInt(totalResults);
        parcel.writeInt(totalPages);
        parcel.writeTypedList(results);
    }
}
