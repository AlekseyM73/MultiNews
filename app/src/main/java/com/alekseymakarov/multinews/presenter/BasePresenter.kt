package com.alekseymakarov.multinews.presenter

import com.alekseymakarov.multinews.view.BaseView

interface BasePresenter<V : BaseView> {

    fun attach (view: V)
    fun detach ()
}