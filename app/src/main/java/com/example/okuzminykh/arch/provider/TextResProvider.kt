package com.example.okuzminykh.assignmentfirstweek.arch.provider

import android.content.Context
import com.example.okuzminykh.assignmentfirstweek.arch.provider.model.TextProvider

class TextResProvider(private val context: Context) {

    fun getString(txtProvider: TextProvider): String {
        return txtProvider.getString(context)
    }
}