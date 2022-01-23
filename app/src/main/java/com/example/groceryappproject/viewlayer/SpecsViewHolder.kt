package com.example.groceryappproject.viewlayer

import androidx.recyclerview.widget.RecyclerView
import com.example.groceryappproject.databinding.SpecificationsViewHolderBinding
import com.example.groceryappproject.datalayer.model.Specification

class SpecsViewHolder(val specsBinding: SpecificationsViewHolderBinding):
    RecyclerView.ViewHolder(specsBinding.root) {
    fun bind(specification: Specification){
        specsBinding.specsTitleTv.text = specification.title
        specsBinding.specsDescTv.text = specification.specification
    }
}