package com.example.mymvpdemo.ui.view;

import android.content.SharedPreferences;
import android.widget.EditText;

/**
 * 登陆View
 * Activity需要实现的功能
 */
public interface ILoginView {
    /**
     *
     * @return
     */
    EditText getPassWord();
    EditText getPhone();

}
