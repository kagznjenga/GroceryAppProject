package com.example.groceryappproject.viewlayer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryappproject.databinding.ProductsViewHolderBinding
import com.example.groceryappproject.datalayer.MyItemClickListener
import com.example.groceryappproject.datalayer.model.Product

class ProductsAdapter(var products: List<Product>, var listener: MyItemClickListener):
RecyclerView.Adapter<ProductsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ProductsViewHolderBinding.inflate(layoutInflater, parent, false)
        return ProductsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)

        holder.itemView.setOnClickListener{
            listener.onProductClicked(product.product_id)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }
}