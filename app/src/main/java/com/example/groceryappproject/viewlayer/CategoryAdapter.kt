package com.example.groceryappproject.viewlayer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryappproject.databinding.ViewHolderCategoryBinding
import com.example.groceryappproject.datalayer.MyItemClickListener
import com.example.groceryappproject.datalayer.model.Category

class CategoryAdapter(val categories: List<Category>, val itemClickListener: MyItemClickListener): RecyclerView.Adapter<CategoryViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderCategoryBinding.inflate(layoutInflater, parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)

        holder.itemView.setOnClickListener{
            itemClickListener.onCategoryClicked(category.category_id)
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

}