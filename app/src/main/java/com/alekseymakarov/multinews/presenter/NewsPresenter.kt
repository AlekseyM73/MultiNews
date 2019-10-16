package com.alekseymakarov.multinews.presenter

import android.view.View
import com.alekseymakarov.multinews.ui.NewsActivity
import com.alekseymakarov.multinews.view.BaseView

class NewsPresenter (var view: BaseView?) : BasePresenter {


    override
    fun detachView (){
         view = null
     }




}