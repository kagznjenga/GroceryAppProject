package com.example.groceryappproject.viewlayer

import androidx.recyclerview.widget.RecyclerView
import com.example.groceryappproject.R
import com.example.groceryappproject.databinding.ViewHolderCategoryBinding
import com.example.groceryappproject.datalayer.Constants
import com.example.groceryappproject.datalayer.model.Category
import com.squareup.picasso.Picasso

class CategoryViewHolder(val viewHolderBinding: ViewHolderCategoryBinding):
    RecyclerView.ViewHolder(viewHolderBinding.root) {
        fun bind(category: Category){
            viewHolderBinding.categoryTitleTv.text = category.category_name
            val imageUrl = "${Constants.IMAGE_URL}${category.category_image_url}"

            Picasso.get().load(imageUrl).placeholder(R.drawable.ic_baseline_image_24).error(R.drawable.ic_baseline_broken_image_24).into(viewHolderBinding.categoryPicIv)
        }
}