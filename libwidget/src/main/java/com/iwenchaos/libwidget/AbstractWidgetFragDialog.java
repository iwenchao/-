package com.iwenchaos.libwidget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by chaos on 17-8-22.
 */

public abstract class AbstractWidgetFragDialog extends DialogFragment {



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = createView(inflater,container);
        return view;
    }


    public abstract View createView(LayoutInflater inflater,ViewGroup container);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
