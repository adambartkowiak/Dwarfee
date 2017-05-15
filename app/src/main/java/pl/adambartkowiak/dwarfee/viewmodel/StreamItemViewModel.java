package pl.adambartkowiak.dwarfee.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;

import pl.adambartkowiak.dwarfee.activity.BroadcasterDetailActivity;

/**
 * Created by adambartkowiak on 08.05.2017.
 */

public class StreamItemViewModel {

    public final ObservableField<Boolean> awarded = new ObservableField<>();
    public final ObservableField<Boolean> assignedTo = new ObservableField<>();

    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableField<String> description = new ObservableField<>();
    public final ObservableField<String> clock = new ObservableField<>();
    public final ObservableField<String> avatarUrl = new ObservableField<>();

    public void onClickLeaveButton() {
        assignedTo.set(false);
    }

    public void onClickCalendarIcon() {
        assignedTo.set(true);
    }

    public void onClickAvatar(View view) {
        Context context = view.getContext();

        Intent intent = new Intent(view.getContext(), BroadcasterDetailActivity.class);
        context.startActivity(intent);
    }

}
