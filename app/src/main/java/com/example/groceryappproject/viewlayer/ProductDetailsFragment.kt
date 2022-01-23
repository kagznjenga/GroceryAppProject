package com.example.groceryappproject.viewlayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groceryappproject.R
import com.example.groceryappproject.databinding.FragmentProductDetailsBinding
import com.example.groceryappproject.datalayer.model.ProductDetails
import com.example.groceryappproject.datalayer.remote.MyRequestHandler
import com.example.groceryappproject.presenterlayer.ProductDetailsMVP
import com.example.groceryappproject.presenterlayer.ProductDetialsPresenter

class ProductDetailsFragment : Fragment(), ProductDetailsMVP.ProductDetailsView {
    lateinit var detailsBinding: FragmentProductDetailsBinding
    lateinit var communicator: Communicator
    lateinit var prodDetailsPresenter: ProductDetialsPresenter
    lateinit var productDetailsAdapter: ProductDetailsAdapter
    lateinit var reviewAdapter: ReviewAdapter
    lateinit var specsAdapter: SpecsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailsBinding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        val requestHandler = MyRequestHandler(requireContext().applicationContext)
        prodDetailsPresenter = ProductDetialsPresenter(requestHandler, this)
        detailsBinding.apply {
            reviewsRv.layoutManager = LinearLayoutManager(activity?.applicationContext)
            specsRv.layoutManager = LinearLayoutManager(activity?.applicationContext)
        }
        return detailsBinding.root
    }

    override fun setResult(productDetails: ProductDetails?) {
       detailsBinding.apply {

       }
    }

    override fun onLoad(isLoading: Boolean) {
        if (isLoading){
            detailsBinding.productDetailsLoading.visibility = View.VISIBLE
        }
        else{
            detailsBinding.productDetailsLoading.visibility = View.GONE
        }
    }
}