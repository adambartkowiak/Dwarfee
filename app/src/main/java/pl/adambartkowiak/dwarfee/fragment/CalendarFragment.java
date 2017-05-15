package pl.adambartkowiak.dwarfee.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.adambartkowiak.dwarfee.R;
import pl.adambartkowiak.dwarfee.view.adapter.StreamAdapter;

/**
 * Created by adambartkowiak on 03.05.2017.
 */

public class CalendarFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calendar, container, false);
        return rootView;
    }
}
