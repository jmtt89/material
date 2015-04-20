package com.ogangi.messangi.demomaterial;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.bignerdranch.android.multiselector.MultiSelector;
import com.bignerdranch.android.multiselector.SwappingHolder;
import com.thedeanda.lorem.Lorem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import adapters.inboxAdapter;
import models.Notification;

/**
 * Created by jesus on 17-04-2015.
 */
public class inboxFragment2 extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private MultiSelector mMultiSelector = new MultiSelector();
    private class MyHolder extends SwappingHolder implements View.OnClickListener {
        //private final CheckBox mSolvedCheckBox;

        public MyHolder(View itemView) {
            super(itemView, mMultiSelector);
            mMultiSelector.setSelectable(true);
            //mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.solvedCheckBox);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mMultiSelector.tapSelection(this)) {
                // Selection is on, so tapSelection() toggled item selection.
            } else {
                // Selection is off; handle normal item click here.
            }
        }
    }


    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static inboxFragment2 newInstance() {
        inboxFragment2 fragment = new inboxFragment2();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, 0);
        fragment.setArguments(args);
        return fragment;
    }

    public inboxFragment2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View inboxView = inflater.inflate(R.layout.fragment_inbox, container,false);
        mRecyclerView = (RecyclerView)inboxView.findViewById(R.id.inboxList);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(inboxView.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        CopyOnWriteArrayList<Notification> myDataset = new CopyOnWriteArrayList<>();
        //Demo Data
        for (int i = 0; i < 20; i++) {
            myDataset.add(new Notification(Lorem.getTitle(2, 4),"11-11-11", Lorem.getHtmlParagraphs(1, 4)));
        }
        mAdapter = new inboxAdapter(new ArrayList<>(myDataset));
        mRecyclerView.setAdapter(mAdapter);


        return inboxView;
    }


}

