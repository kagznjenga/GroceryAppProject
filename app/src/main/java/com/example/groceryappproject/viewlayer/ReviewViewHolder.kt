package com.example.groceryappproject.viewlayer

import androidx.recyclerview.widget.RecyclerView
import com.example.groceryappproject.databinding.ReviewsViewHolderBinding
import com.example.groceryappproject.datalayer.model.Review

class ReviewViewHolder(val reviewsBinding: ReviewsViewHolderBinding): RecyclerView.ViewHolder(reviewsBinding.root) {
    fun bind(review: Review){
        reviewsBinding.reviewsTitleTv.text = review.review_title
        reviewsBinding.reviewsDescTv.text = review.review
    }
}