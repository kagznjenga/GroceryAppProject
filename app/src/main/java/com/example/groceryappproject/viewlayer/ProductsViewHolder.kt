package com.example.groceryappproject.viewlayer

import androidx.recyclerview.widget.RecyclerView
import com.example.groceryappproject.R
import com.example.groceryappproject.databinding.ProductsViewHolderBinding
import com.example.groceryappproject.datalayer.Constants
import com.example.groceryappproject.datalayer.model.Product
import com.squareup.picasso.Picasso

class ProductsViewHolder(val productsBinding: ProductsViewHolderBinding):
RecyclerView.ViewHolder(productsBinding.root){
    fun bind(product: Product){
        productsBinding.productTitleTv.text = product.product_name
        val imageUrl = "${Constants.IMAGE_URL}${product.product_image_url}"

        Picasso.get().load(imageUrl).placeholder(R.drawable.ic_baseline_image_24).error(R.drawable.ic_baseline_broken_image_24).into(productsBinding.productPicIv)
    }
}