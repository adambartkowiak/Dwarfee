package pl.adambartkowiak.dwarfee.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.adambartkowiak.dwarfee.BuildConfig;
import pl.adambartkowiak.dwarfee.R;
import pl.adambartkowiak.dwarfee.view.adapter.BroadcastersAdapter;
import pl.adambartkowiak.dwarfee.view.decoration.BroadcastersItemDecoration;
import pl.adambartkowiak.dwarfee.view.decoration.StreamItemDecoration;

/**
 * Created by adambartkowiak on 03.05.2017.
 */

public class BroadcastersFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private BroadcastersAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.broadcastersRecyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new GridLayoutManager(this.getActivity(), 2, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // item separator
        int separatorInPixels = getResources().getDimensionPixelSize(R.dimen.broadcasters_item_spacing);
        mRecyclerView.addItemDecoration(new BroadcastersItemDecoration(separatorInPixels));

        // specify an adapter (see also next example)
        mAdapter = new BroadcastersAdapter();
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }
}
