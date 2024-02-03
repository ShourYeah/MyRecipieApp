package com.example.myrecipieapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable

fun RecipeScreen(modifier: Modifier = Modifier,
                 viewstate:MainViewModel.RecipeState,
                 navigateToDetail: (Category)-> Unit //Whoever passes recipe screen should tell what should be executed on navigation
                 ){
    val recipeViewModel: MainViewModel = viewModel()

    Box(modifier = Modifier.fillMaxSize()){
        when{
            viewstate.loading ->{
                CircularProgressIndicator(modifier.align(Alignment.Center))  // aligning circular progress indicator at the center of the screen

            }

            viewstate.error != null -> {
                Text(text = "Error Occured")    // Either we are loading or we are facing error
            }

            //If not loading and not facing error:

            else -> {
                // Display Categories
                    CategoryScreen(categories = viewstate.list,
                        navigateToDetail)

            }
        }
    }

}


//To display Item in grid
@Composable
fun CategoryScreen(categories: List<Category>,
                   navigateToDetail: (Category)-> Unit
                   ){
    //Lazy Vertical grid with two items populates everything it fetches and
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize() ){

        items(categories){
            category -> //for every single category item that you have available for category, pass that into a new category item
            CategoryItem(category = category, navigateToDetail)
        }
    }
}

// How each item looks like
@Composable
fun CategoryItem(category: Category,
                 navigateToDetail: (Category)-> Unit
                 ){

    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxSize()
        .clickable { navigateToDetail(category) } //Defines what happens when I click on the column
        ,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )


        // For the text to be displayed associated with image
        Text(
                text = category.strCategory,
                color = Color.Black,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top=4.dp) //Space towards the top
            )
    }
}