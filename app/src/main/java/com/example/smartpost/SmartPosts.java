package com.example.smartpost;

import java.util.ArrayList;

public class SmartPosts {
    private static SmartPosts smartPosts = new SmartPosts();
    static SmartPosts getInstance(){ return smartPosts; }

    public ArrayList<SmartPostInfo> smartPostList;

    private SmartPosts(){

        ArrayList<SmartPostInfo> postList = new ArrayList<>();


    }

}
