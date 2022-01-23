package com.example.groceryappproject.viewlayer

import androidx.recyclerview.widget.RecyclerView
import com.example.groceryappproject.R
import com.example.groceryappproject.databinding.FragmentProductDetailsBinding
import com.example.groceryappproject.databinding.ReviewsViewHolderBinding
import com.example.groceryappproject.databinding.SpecificationsViewHolderBinding
import com.example.groceryappproject.datalayer.Constants
import com.example.groceryappproject.datalayer.model.ProductDetails
import com.example.groceryappproject.datalayer.model.Review
import com.example.groceryappproject.datalayer.model.Specification
import com.squareup.picasso.Picasso

class ProductDetailsViewHolder(val prodDetailsBinding: FragmentProductDetailsBinding):
    RecyclerView.ViewHolder(prodDetailsBinding.root) {
    fun bind(productDetails: ProductDetails){
        prodDetailsBinding.apply {
            detailsTitleTv.text = productDetails.product_name
            myRatebar.rating = productDetails.average_rating.toFloat()
            priceTv.text = "'$'productDetails.price"
            descriptionTv.text = productDetails.description

            val imageUrl = "${Constants.IMAGE_URL}${productDetails.product_image_url}"
            Picasso.get().load(imageUrl).placeholder(R.drawable.ic_baseline_image_24).error(R.drawable.ic_baseline_broken_image_24)
                .into(productDetailsIv)
        }
    }
}

