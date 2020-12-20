package me.tandeneck.tanutils.extends

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * author:tandeneck
 * time:2020/12/14
 * description: View 的扩展函数
 */

fun View.hideKeyboard() {
    clearFocus()
    (context.getSystemService(Context.INPUT_METHOD_SERVICE) as
            InputMethodManager).hideSoftInputFromWindow(windowToken, 0)
}

fun View.showKeyboard() {
    requestFocus()
    (context.getSystemService(Context.INPUT_METHOD_SERVICE) as
            InputMethodManager).showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}