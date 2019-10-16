package com.alekseymakarov.multinews.view

import com.alekseymakarov.multinews.model.Article

interface BaseView <T> {

    fun showData(data: List<T>)
    fun showProgress()
    fun hideProgress()


}