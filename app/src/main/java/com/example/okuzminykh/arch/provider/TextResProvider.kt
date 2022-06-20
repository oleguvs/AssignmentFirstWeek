package com.example.okuzminykh.arch.provider

import android.content.Context
import com.example.okuzminykh.arch.provider.model.TextProvider

class TextResProvider(private val context: Context) {

    fun getString(txtProvider: TextProvider): String {
        return txtProvider.getString(context)
    }
}