package com.alekseymakarov.multinews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.alekseymakarov.multinews.R
import com.alekseymakarov.multinews.model.Article
import com.alekseymakarov.multinews.presenter.NewsPresenter
import com.alekseymakarov.multinews.view.BaseView

class NewsActivity : AppCompatActivity(), BaseView<Article> {

    private lateinit  var newsPresenter : NewsPresenter

    private lateinit var newsListItemTVSite : TextView
    private lateinit var newsListItemTVTitle : TextView
    private lateinit var newsListItemTVDesc : TextView
    private lateinit var newsListItemTVPublAt : TextView
    private lateinit var newsListImageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        initViews()

        newsPresenter = NewsPresenter(this, applicationContext)
        newsPresenter.getDataFromServer()

    }

    private fun initViews(){
      /*  newsListItemTVSite = findViewById(R.id.newsListItemTVSite)
        newsListItemTVTitle = findViewById(R.id.newsListItemTVTitle)
        newsListItemTVDesc = findViewById(R.id.newsListItemTVDesc)
        newsListItemTVPublAt = findViewById(R.id.newsListItemTVPublAt)
        newsListImageView = findViewById(R.id.newsListImageView)*/
    }

    override fun showData(data : List<Article>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        super.onDestroy()
        newsPresenter.detachView()
    }

}
