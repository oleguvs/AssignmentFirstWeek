package com.example.okuzminykh.arch.adapter

interface AdapterContentElement {

    fun areContentsTheSame(other: AdapterContentElement): Boolean
}