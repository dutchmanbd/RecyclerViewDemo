package com.oride.recyclerviewdemo

data class Item(
    val id: Int,
    val name: String,
    val type: Int
){

    companion object {
        fun getType(type: Int) = when(type){
           1 -> Type.Single
           2 -> Type.Title
           3 -> Type.Grid
           else -> Type.Single
        }
    }

    sealed class Type(val type: Int){
        object Single : Type(1)
        object Title : Type(2)
        object Grid: Type(3)
    }
}