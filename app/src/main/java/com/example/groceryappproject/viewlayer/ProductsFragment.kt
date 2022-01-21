package com.example.groceryappproject.viewlayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groceryappproject.R
import com.example.groceryappproject.databinding.FragmentProductsBinding
import com.example.groceryappproject.datalayer.MyItemClickListener
import com.example.groceryappproject.datalayer.model.Product
import com.example.groceryappproject.datalayer.remote.MyRequestHandler
import com.example.groceryappproject.presenterlayer.ProductsMVP
import com.example.groceryappproject.presenterlayer.ProductsPresenter

class ProductsFragment : Fragment(), ProductsMVP.ProductsViewInt {
    lateinit var productBinding: FragmentProductsBinding
    lateinit var productsAdapter: ProductsAdapter
    lateinit var productsPresenter: ProductsPresenter
    lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        productBinding = FragmentProductsBinding.inflate(inflater, container, false)

        communicator = activity as Communicator
        val requestHandler = MyRequestHandler(requireContext())
        productBinding.productsRv.layoutManager = LinearLayoutManager(activity?.applicationContext)
        productsPresenter = ProductsPresenter(requestHandler, this)
        productsPresenter.displayProducts(arguments?.getString("subcategoryId")!!)

        return productBinding.root
    }

    override fun setResult(products: List<Product>) {
        productBinding.apply {
            productsLoading.visibility = View.GONE
            productsAdapter = ProductsAdapter(products, object: MyItemClickListener{
                override fun onCategoryClicked(categoryId: String) {
                }

                override fun onSubcategoryClicked(subcategoryId: String) {
                }

                override fun onProductClicked(productId: String) {
                }

            })
            productsRv.adapter = productsAdapter
        }
    }

    override fun onLoad(isLoading: Boolean) {
        if (isLoading){
            productBinding.productsLoading.visibility = View.VISIBLE
        }
        else{
            productBinding.productsLoading.visibility = View.GONE
        }
    }
}