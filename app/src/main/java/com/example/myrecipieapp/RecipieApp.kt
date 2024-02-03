package com.example.myrecipieapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

@Composable

fun RecipieApp(navController: NavHostController){
    val recipeViewModel: MainViewModel= viewModel()
    val viewstate by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipieScreen.route){
        composable(route= Screen.RecipieScreen.route){
            RecipeScreen(viewstate = viewstate, navigateToDetail ={
            // This part is responsible for passing data from the current screen to the detail screen.
            // It utilizes the savedStateHandle, which is a component of the compose navigation framework
                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it) //cat is reference for category ie called here using "parcelize"
                navController.navigate(Screen.DetailScreen.route)

            } )
        }


        composable(route= Screen.DetailScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")?: Category("","","","")
            CategoryDetailScreen(category = category)
        }

    }


}