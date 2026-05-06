package com.boshra.news.view_model

import androidx.lifecycle.ViewModel
import com.boshra.model.domain.entities.Article
import com.boshra.model.domain.use_cases.GetBreakingNewsUseCase
import com.boshra.model.domain.use_cases.RefreshNewsUseCase
import com.boshra.model.domain.use_cases.DeleteArticleUseCase

class NewsViewModel(
    private val getBreakingNewsUseCase: GetBreakingNewsUseCase,
    private val refreshNewsUseCase: RefreshNewsUseCase,
    private val deleteArticleUseCase: DeleteArticleUseCase
) : ViewModel() {

    fun onSelectArticle(article: Article) {

    }

    fun onRefreshNewsFromRemote() {

    }

    fun onDeleteArticle(article: Article) {

    }

}

