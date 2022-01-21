package com.example.groceryappproject.presenterlayer

import com.example.groceryappproject.datalayer.model.Category

class HomeMVP {
    interface HomeViewInt{
        fun setResult(categories: List<Category>)
        fun onLoad(isLoading: Boolean)
    }

    interface HomePresenterInt{
        fun displayCategories()
    }
}