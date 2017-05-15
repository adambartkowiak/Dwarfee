package pl.adambartkowiak.dwarfee.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.adambartkowiak.dwarfee.R;

/**
 * Created by adambartkowiak on 03.05.2017.
 */

public class BroadcasterDetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_broadcaster_detail, container, false);

        View rootView = binding.getRoot();
        return rootView;
    }
}
