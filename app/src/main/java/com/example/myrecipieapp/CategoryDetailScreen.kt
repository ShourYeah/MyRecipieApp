package com.example.myrecipieapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable

fun CategoryDetailScreen(category: Category){
    Column(modifier= Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        //Text(text = category.strCategory, textAlign = TextAlign.Center)
         Image(
             painter = rememberAsyncImagePainter(model = category.strCategoryThumb),
             contentDescription = "${category.strCategory}, Thumbnail",
             modifier = Modifier
                 .wrapContentSize()
                 .aspectRatio(1f)
         )
        Text(
            text = category.strCategoryDescription,
            textAlign = TextAlign.Justify,
            style = TextStyle(fontWeight = FontWeight.Normal, fontSize = 24.sp),
            color = Color.Black,
            modifier = Modifier.verticalScroll(rememberScrollState()) //help scrolling text area not image

        )
    }
}