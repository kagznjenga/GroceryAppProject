package com.example.groceryappproject.viewlayer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryappproject.databinding.SubcategoryViewHolderBinding
import com.example.groceryappproject.datalayer.MyItemClickListener
import com.example.groceryappproject.datalayer.model.Subcategory

class SubcategoryAdapter(var subCategories: List<Subcategory>, var listener: MyItemClickListener):
RecyclerView.Adapter<SubcategoryViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubcategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = SubcategoryViewHolderBinding.inflate(layoutInflater, parent, false)
        return SubcategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubcategoryViewHolder, position: Int) {
        val subCategory = subCategories[position]
        holder.bind(subCategory)

        holder.itemView.setOnClickListener{
            listener.onSubcategoryClicked(subCategory.subcategory_id)
        }
    }

    override fun getItemCount(): Int {
        return subCategories.size
    }
}