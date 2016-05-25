package com.yangpeiyong.appdemokotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import android.widget.Toast
import butterknife.Bind
import butterknife.ButterKnife
import com.yangpeiyong.appdemokotlin.data.ArticleInfo
import com.yangpeiyong.appdemokotlin.network.ReceiveData
import com.yangpeiyong.appdemokotlin.network.RestClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    var articleAdapter: ArticleAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        articleAdapter = ArticleAdapter(this)
        listView.adapter = articleAdapter

        RestClient.api().articles(10, 20).enqueue(object : Callback<ReceiveData.ArticleListResponse> {
            override fun onResponse(call: Call<ReceiveData.ArticleListResponse>, response: Response<ReceiveData.ArticleListResponse>) {
                var articleInfoList = response.body().results
                articleAdapter?.articleInfoList = articleInfoList
                articleAdapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<ReceiveData.ArticleListResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }
        })

    }
}
