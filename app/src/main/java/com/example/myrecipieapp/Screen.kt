package com.example.myrecipieapp
// sealed class is used to ensure that only certain classes are capable of inheriting from them no outsider classes can inherit
sealed class Screen(val route:String) {
    object RecipieScreen:Screen("recipiescreen")
    object DetailScreen:Screen("detailscreen")

}