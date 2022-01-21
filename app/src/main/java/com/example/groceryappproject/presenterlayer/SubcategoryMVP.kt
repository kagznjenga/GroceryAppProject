package com.example.groceryappproject.presenterlayer

import com.example.groceryappproject.datalayer.model.Category
import com.example.groceryappproject.datalayer.model.Subcategory

class SubcategoryMVP {
    interface SubcategoryViewInt{
        fun setResult(subcategories: List<Subcategory>)
        fun onLoad(isLoading: Boolean)
    }

    interface SubcategoryPresenterInt{
        fun displaySubcategories(categoryId: String)
    }
}