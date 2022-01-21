package com.example.groceryappproject.viewlayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groceryappproject.R
import com.example.groceryappproject.databinding.FragmentSubcategoryBinding
import com.example.groceryappproject.datalayer.MyItemClickListener
import com.example.groceryappproject.datalayer.model.Subcategory
import com.example.groceryappproject.datalayer.remote.MyRequestHandler
import com.example.groceryappproject.presenterlayer.SubcategoryMVP
import com.example.groceryappproject.presenterlayer.SubcategoryPresenter

class SubcategoryFragment : Fragment(), SubcategoryMVP.SubcategoryViewInt {
    lateinit var subcategoryBinding: FragmentSubcategoryBinding
    lateinit var subcategoryAdapter: SubcategoryAdapter
    lateinit var subcategoryPresenter: SubcategoryPresenter
    lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        subcategoryBinding = FragmentSubcategoryBinding.inflate(inflater, container, false)

        communicator =  activity as Communicator

        val requestHandler = MyRequestHandler(requireActivity().applicationContext)
        subcategoryBinding.subcategoriesRv.layoutManager = LinearLayoutManager(activity?.applicationContext)
        subcategoryPresenter = SubcategoryPresenter(requestHandler, this)
        subcategoryPresenter.displaySubcategories(arguments?.getString("categoryId")!!)

        return subcategoryBinding.root
    }


    override fun setResult(subcategories: List<Subcategory>) {
        subcategoryBinding.apply {
            subcategoriesLoading.visibility = View.GONE
            subcategoryAdapter = SubcategoryAdapter(subcategories, object: MyItemClickListener{
                override fun onSubcategoryClicked(subcategoryId: String) {
                    val fragment = ProductsFragment()
                    communicator.passIdData(fragment, "subcategoryId", subcategoryId)
                }

                override fun onCategoryClicked(categoryId: String) {
                }

                override fun onProductClicked(productId: String) {
                }

            })
            subcategoriesRv.adapter = subcategoryAdapter
        }
    }

    override fun onLoad(isLoading: Boolean) {
        if (isLoading){
            subcategoryBinding.subcategoriesLoading.visibility = View.VISIBLE
        }
        else{
            subcategoryBinding.subcategoriesLoading.visibility = View.GONE
        }
    }

}