package com.boshra.news.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.boshra.model.data.repo.NewsRepositoryImpl
import com.boshra.news.ui.screens.ArticleDetailsScreen
import com.boshra.news.ui.screens.NewsListScreen

@Composable
fun NewsAppNavigation(repository: NewsRepositoryImpl) {
    val navController: NavHostController = rememberNavController()


//    GetBreakingNewsUseCase
//    RefreshNewsUseCase
//    DeleteArticleUseCase

//    initialize use cases and pass them to NewsViewModelFactory
//    pass viewModel to screens

    NavHost(navController = navController, startDestination = Screen.NewsList.route) {
        composable(Screen.NewsList.route) {
            NewsListScreen(
                navController,
                viewModel = TODO(),
            )
        }

        composable(Screen.ArticleDetails.route) {
            ArticleDetailsScreen(
                navController,
                viewModel = TODO(),
            )
        }
    }
}