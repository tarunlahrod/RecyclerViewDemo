package com.example.recyclerviewdemo;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Don't forget to add this (statement below) to the manifest file in the <application/>
// android:name=".MyApplication"

public class MyApplication extends Application {

    // we declare list as static because we don't want it to change from one instance to the other
    private static List<President> presidentList = new ArrayList<President>();
    private static int nextId = 7;

    // Constructor
    public MyApplication() {
        fillPresidentList();
    }

    private void fillPresidentList() {
        President p0 = new President(0, "Rajendra Prasad", 1950, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/Rajendra_Prasad_%28Indian_President%29%2C_signed_image_for_Walter_Nash_%28NZ_Prime_Minister%29%2C_1958_%2816017609534%29.jpg/100px-Rajendra_Prasad_%28Indian_President%29%2C_signed_image_for_Walter_Nash_%28NZ_Prime_Minister%29%2C_1958_%2816017609534%29.jpg");
        President p1 = new President(1, "Sarvepalli Radhakrishnan", 1962, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Photograph_of_Sarvepalli_Radhakrishnan_presented_to_First_Lady_Jacqueline_Kennedy_in_1962.jpg/100px-Photograph_of_Sarvepalli_Radhakrishnan_presented_to_First_Lady_Jacqueline_Kennedy_in_1962.jpg");
        President p2 = new President(2, "Zakir Husain", 1967, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/President_Zakir_Husain_1998_stamp_of_India_%28cropped%29.jpg/100px-President_Zakir_Husain_1998_stamp_of_India_%28cropped%29.jpg");
        President p3 = new President(3, "Varahagiri Venkata Giri", 1969, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/VV_Giri_1974_stamp_of_India_%28cropped%29.jpg/100px-VV_Giri_1974_stamp_of_India_%28cropped%29.jpg");
        President p4 = new President(4, "Mohammad Hidayatullah", 1969, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Justice_M._Hidayatullah.jpg/100px-Justice_M._Hidayatullah.jpg");
        President p5 = new President(5, "Varahagiri Venkata Giri", 1969, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/VV_Giri_1974_stamp_of_India_%28cropped%29.jpg/100px-VV_Giri_1974_stamp_of_India_%28cropped%29.jpg");
        President p6 = new President(6, "Fakhruddin Ali Ahmed", 1974, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Fakhruddin_Ali_Ahmed_1977_stamp_of_India_%28cropped%29.jpg/100px-Fakhruddin_Ali_Ahmed_1977_stamp_of_India_%28cropped%29.jpg");

        presidentList.addAll(Arrays.asList(new President[] {p0, p1, p2, p3, p4, p5, p6}));
    }

    public static List<President> getPresidentList() {
        return presidentList;
    }

    public static void setPresidentList(List<President> presidentList) {
        MyApplication.presidentList = presidentList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}
