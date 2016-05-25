package com.yangpeiyong.appdemokotlin

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.yangpeiyong.appdemokotlin.data.ArticleInfo
import java.lang.ref.WeakReference
import java.util.*

/**
 * @author yangpeiyong
 */
class ArticleAdapter(activity: Activity) : BaseAdapter() {

    var activity = activity

    var articleInfoList:List<ArticleInfo>?=null
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun getCount(): Int {
        return articleInfoList?.size ?: 0
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view = convertView
        if (convertView == null) {
            view = LayoutInflater.from(activity).inflate(R.layout.item_article, null)
        }

        val imageView = view!!.findViewById(R.id.img) as ImageView
        val titleTxt = view.findViewById(R.id.title) as TextView

        val info = articleInfoList!![position]

        titleTxt.text = info.desc

        Glide.with(activity).load("http://ww4.sinaimg.cn/large/7a8aed7bjw1ezrtpmdv45j20u00spahy.jpg").into(imageView)

        return view
    }
}