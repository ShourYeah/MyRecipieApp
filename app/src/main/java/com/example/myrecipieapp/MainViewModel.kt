package com.example.myrecipieapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel :ViewModel (){

    private val _categorieState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categorieState

    init {
        fetchCategories()
    }




    private  fun fetchCategories(){
    viewModelScope.launch {
        try {
                val response = recipieService.getCategories()
                _categorieState.value = _categorieState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )

            // a public immutable State variable categoriesState is created, exposing only the read-only version of _categorieState.

        } catch (e: Exception){
            _categorieState.value = _categorieState.value.copy(
                loading = false,  //we are not loading anymore because we failed
                error = "Error fetching Categories ${e.message}"
            )
        }

    }
}


    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null  //can be null OR capable of being null

    )


}