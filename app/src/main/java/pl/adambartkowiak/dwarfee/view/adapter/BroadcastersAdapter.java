package pl.adambartkowiak.dwarfee.view.adapter;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import pl.adambartkowiak.dwarfee.R;
import pl.adambartkowiak.dwarfee.databinding.BroadcasterItemBinding;
import pl.adambartkowiak.dwarfee.viewmodel.BroadcasterItemViewModel;


/**
 * Created by adambartkowiak on 03.05.2017.
 */

public class BroadcastersAdapter extends RecyclerView.Adapter<BroadcastersAdapter.ViewHolder> {

    private String[] mDataset;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view

        //Inflate layout form DataBindingXML
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType /*getItemViewType(int position)*/, parent, false);


        return new ViewHolder((BroadcasterItemBinding) binding);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.view_broadcasters_item;
    }

    @Override
    public void onBindViewHolder(BroadcastersAdapter.ViewHolder holder, int position) {
        BroadcasterItemViewModel item = getItemForPosition(position);
        holder.bind(item);
    }

    private BroadcasterItemViewModel getItemForPosition(int position) {

        BroadcasterItemViewModel broadcasterItemViewModel = new BroadcasterItemViewModel();

        broadcasterItemViewModel.name.set("Name #" + position);

        if (position % 3 == 0) {
            broadcasterItemViewModel.imageUrl.set("http://emsc2.tv/img/logo-1.png");
        } else if (position % 3 == 1) {
            broadcasterItemViewModel.imageUrl.set("http://emsc2.tv/img/logo-2.png");
        } else {
            broadcasterItemViewModel.imageUrl.set("http://emsc2.tv/img/logo-3.png");
        }

        return broadcasterItemViewModel;
    }

    @Override
    public int getItemCount() {
        return 49;
    }

    //ViewHolder
    static class ViewHolder extends RecyclerView.ViewHolder {
        private final BroadcasterItemBinding binding;

        public ViewHolder(BroadcasterItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(BroadcasterItemViewModel item) {
            binding.setViewModel(item);
            binding.executePendingBindings();
        }
    }
}
