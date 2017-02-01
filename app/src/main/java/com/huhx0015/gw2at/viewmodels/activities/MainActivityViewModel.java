package com.huhx0015.gw2at.viewmodels.activities;

import android.databinding.BaseObservable;
import android.view.View;

/**
 * Created by Michael Yoon Huh on 1/31/2017.
 */

public class MainActivityViewModel extends BaseObservable {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // LISTENER VARIABLES:
    private MainActivityViewModelListener mListener;

    /** VIEW MODEL METHODS _____________________________________________________________________ **/

    public void setViewModelListener(MainActivityViewModelListener listener) {
        this.mListener = listener;
    }

    /** CLICK METHODS __________________________________________________________________________ **/

    public void onClickFabButton(View view) {
        if (mListener != null) {
            mListener.onFabButtonClicked();
        }
    }

    /** INTERFACE ______________________________________________________________________________ **/

    public interface MainActivityViewModelListener {
        void onFabButtonClicked();
    }
}