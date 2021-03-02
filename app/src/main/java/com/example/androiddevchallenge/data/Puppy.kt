package com.example.androiddevchallenge.data

// TODO
data class Puppy(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val aga: Int = 3,
    val sex: Sex = Sex.Female,
    val size: Size = Size.Small
)

enum class Sex {
    Male, Female
}

enum class Size {
    Small, Medium, Large
}