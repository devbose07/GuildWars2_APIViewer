package com.huhx0015.gw2at.view.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.huhx0015.gw2at.R;
import com.huhx0015.gw2at.databinding.AdapterQuaggansBinding;
import com.huhx0015.gw2at.model.responses.QuaggansResponse;
import com.huhx0015.gw2at.viewmodels.adapters.QuaggansAdapterViewModel;
import java.util.List;

/**
 * Created by Michael Yoon Huh on 2/1/2017.
 */

public class QuaggansAdapter extends RecyclerView.Adapter<QuaggansAdapter.QuaggansViewHolder> {

    /** CLASS VARIABLES ________________________________________________________________________ **/

    // LIST VARIABLES
    private List<QuaggansResponse> mQuaggansList;

    // LOGGING VARIABLES
    private static final String LOG_TAG = QuaggansAdapter.class.getSimpleName();

    /** CONSTRUCTOR METHODS ____________________________________________________________________ **/

    public QuaggansAdapter(List<QuaggansResponse> list) {
        this.mQuaggansList = list;
    }

    /** RECYCLER VIEW METHODS __________________________________________________________________ **/

    @Override
    public QuaggansAdapter.QuaggansViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterQuaggansBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_quaggans, parent, false);
        return new QuaggansAdapter.QuaggansViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(QuaggansAdapter.QuaggansViewHolder holder, int position) {
        String quaggansName = mQuaggansList.get(position).getId();
        String quaggansImageUrl = mQuaggansList.get(position).getUrl();
        holder.bindView(quaggansName, quaggansImageUrl);
    }

    @Override
    public void onViewRecycled(QuaggansViewHolder holder) {
        holder.mBinding.getViewModel().removeOnPropertyChangedCallback(null);
        holder.mBinding.setViewModel(null);
        holder.mBinding.executePendingBindings();
        super.onViewRecycled(holder);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if (mQuaggansList != null) {
            return mQuaggansList.size();
        } else {
            return 0;
        }
    }

    /** SUBCLASSES _____________________________________________________________________________ **/

    class QuaggansViewHolder extends RecyclerView.ViewHolder {

        private AdapterQuaggansBinding mBinding;

        QuaggansViewHolder(AdapterQuaggansBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        private void bindView(String name, String imageUrl) {
            final QuaggansAdapterViewModel viewModel = new QuaggansAdapterViewModel(name, imageUrl);
            mBinding.setViewModel(viewModel);
        }
    }
}
