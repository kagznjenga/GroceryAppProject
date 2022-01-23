package com.example.groceryappproject.viewlayer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryappproject.databinding.FragmentProductDetailsBinding
import com.example.groceryappproject.datalayer.MyItemClickListener
import com.example.groceryappproject.datalayer.model.ProductDetails

class ProductDetailsAdapter(val prodDetails: ProductDetails, val clickListener: MyItemClickListener):
RecyclerView.Adapter<ProductDetailsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDetailsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FragmentProductDetailsBinding.inflate(layoutInflater, parent, false)
        return ProductDetailsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductDetailsViewHolder, position: Int) {
        holder.bind(prodDetails)
    }

    override fun getItemCount(): Int {
        return 1
    }
}