package com.yangpeiyong.appdemokotlin.network

import com.yangpeiyong.appdemokotlin.data.ArticleInfo

/**
 * Created by yangpeiyong on 16/1/12.
 */
object  ReceiveData {

    data class ArticleListResponse (
        var error: Boolean = false,
        var results: List<ArticleInfo>?
    )
}
