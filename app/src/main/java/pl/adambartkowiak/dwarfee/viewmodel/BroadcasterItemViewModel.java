package pl.adambartkowiak.dwarfee.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;

import pl.adambartkowiak.dwarfee.activity.BroadcasterDetailActivity;

/**
 * Created by adambartkowiak on 08.05.2017.
 */

public class BroadcasterItemViewModel {

    public BroadcasterItemViewModel() {
        super();
    }

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> imageUrl = new ObservableField<>();

    public void onClickItem(View view) {
        Context context = view.getContext();

        Intent intent = new Intent(view.getContext(), BroadcasterDetailActivity.class);
        context.startActivity(intent);
    }


}
