package com.example.groceryappproject.viewlayer

import androidx.recyclerview.widget.RecyclerView
import com.example.groceryappproject.R
import com.example.groceryappproject.databinding.SubcategoryViewHolderBinding
import com.example.groceryappproject.datalayer.Constants
import com.example.groceryappproject.datalayer.model.Subcategory
import com.squareup.picasso.Picasso

class SubcategoryViewHolder(val subcategoryBinding: SubcategoryViewHolderBinding):
RecyclerView.ViewHolder(subcategoryBinding.root){
    fun bind(subCategory: Subcategory){
        subcategoryBinding.subcategoryTitleTv.text = subCategory.subcategory_name
        val imageUrl = "${Constants.IMAGE_URL}${subCategory.subcategory_image_url}"

        Picasso.get().load(imageUrl).placeholder(R.drawable.ic_baseline_image_24).error(R.drawable.ic_baseline_broken_image_24).into(subcategoryBinding.subcategoryPicIv)
    }
}