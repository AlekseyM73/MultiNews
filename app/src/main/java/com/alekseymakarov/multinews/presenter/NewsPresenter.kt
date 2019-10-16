package com.alekseymakarov.multinews.presenter

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.Toast.makeText
import com.alekseymakarov.multinews.App
import com.alekseymakarov.multinews.api.ApiService
import com.alekseymakarov.multinews.model.Article
import com.alekseymakarov.multinews.ui.NewsActivity
import com.alekseymakarov.multinews.view.BaseView
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsPresenter (var view: BaseView<Article>?, val context:Context) : BasePresenter {

    override fun getDataFromServer() {
        val s = arrayOf("time")
        ApiService.apiService.getEverythingNews("auto","",*s,
            from = "",to = "",language = "en", sortBy = "",
            pageSize = 20, page = 1, apiKey = ""
            ).observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> Toast.makeText(context,"$result.status",Toast.LENGTH_LONG).show()
                    //Log.d("Result","$result.status")
                    },
                { error -> (error.message) }
            )

    }
    override
    fun detachView (){
         view = null
     }




}