package com.spectre.praticemvvm;

import android.content.Context;
import android.database.Observable;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

/**
 * Created by best__000 on 5/20/2017.
 */

public class ViewModel extends BaseObservable {
    private User user;
    private Context context;

    public ViewModel(User user, Context context) {
        this.user = user;
        this.context = context;

    }

    @Bindable
    public String getUsername() {
        return user.getUsername();
    }

    public void setUsername(String username) {
        user.setUsername(username);
        notifyPropertyChanged(BR.username);
    }

    public TextWatcher getUsernameEditTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                String editTextUsernameValue = charSequence.toString();
                setUsername(editTextUsernameValue);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }


}
