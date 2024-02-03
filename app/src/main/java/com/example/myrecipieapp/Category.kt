package com.example.myrecipieapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
//Parcelize requires a plugin in module:app
@Parcelize
data class Category (
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription:String):Parcelable
data class CategoriesResponse(val categories: List<Category>)


//Parcelize here is used because we are transferring whole category object from one screen to another
//In order to send it from one screen to another we need to serialize and deserialize them.
//All of those information is transferred like the object is a string and when deserializing, it is reverted back into an object