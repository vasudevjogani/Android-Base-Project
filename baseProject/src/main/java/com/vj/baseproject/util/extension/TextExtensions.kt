/*

Copy right here
 */
package com.vj.baseproject.util.extension

import android.content.Context
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView


fun TextView.getTrimmedText(): String {
    return this.text.toString().trim()
}

fun TextView.isEmptyText(): Boolean {
    return TextUtils.isEmpty(this.getTrimmedText())
}

fun EditText.showKeyboard() {
    val inputManager = this.context
        .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}


interface TextChanges {
    fun onTextChange(text: String, view: View?)
}


fun EditText.afterTextChangeEvent(textChanges: TextChanges, view: View? = null) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            textChanges.onTextChange(p0.toString().trim(), view)
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }
    })
}
