package pl.adambartkowiak.dwarfee.view.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.daimajia.swipe.SwipeLayout;

import pl.adambartkowiak.dwarfee.R;
import pl.adambartkowiak.dwarfee.databinding.StreamItemBinding;
import pl.adambartkowiak.dwarfee.viewmodel.StreamItemViewModel;

/**
 * Created by adambartkowiak on 03.05.2017.
 */

public class StreamAdapter extends RecyclerView.Adapter<StreamAdapter.ViewHolder> {

    private String[] mDataset;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inflate layout form DataBindingXML
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType /*getItemViewType(int position)*/, parent, false);

        //get root DataBindingXML view
        ViewGroup rootBindingView = (ViewGroup) binding.getRoot();

        //sets swipe layout configuration
        SwipeLayout swipeLayout = (SwipeLayout) rootBindingView.findViewById(R.id.swipe_layout);
        swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        swipeLayout.addDrag(SwipeLayout.DragEdge.Left, rootBindingView.findViewById(R.id.bottom_wrapper));

        //return created viewHolder
        return new ViewHolder((StreamItemBinding) binding);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.view_news_swipe_item;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        StreamItemViewModel item = getItemForPosition(position);
        holder.bind(item);
    }

    private StreamItemViewModel getItemForPosition(int position) {

        StreamItemViewModel streamItemViewModel = new StreamItemViewModel();

        streamItemViewModel.title.set("Title #" + position);
        streamItemViewModel.description.set("Description #" + position + ", Hello All! This in only simple text for testing purpose.");

        //awarded
        if (position % 5 == 0) {
            streamItemViewModel.awarded.set(true);
        } else {
            streamItemViewModel.awarded.set(false);
        }

        //assignedTo
        if (position % 3 == 0) {
            streamItemViewModel.assignedTo.set(true);
        } else {
            streamItemViewModel.assignedTo.set(false);
        }

        streamItemViewModel.clock.set("8h");

        return streamItemViewModel;
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    //ViewHolder
    static class ViewHolder extends RecyclerView.ViewHolder {
        private final StreamItemBinding binding;

        public ViewHolder(StreamItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(StreamItemViewModel item) {
            binding.setViewModel(item);
            binding.executePendingBindings();
        }
    }
}
