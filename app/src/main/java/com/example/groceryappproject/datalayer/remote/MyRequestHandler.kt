package com.example.groceryappproject.datalayer.remote

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.groceryappproject.datalayer.Constants
import com.example.groceryappproject.datalayer.OperateCallback
import com.example.groceryappproject.datalayer.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.lang.Exception

class MyRequestHandler(val context: Context) {
    val queue = Volley.newRequestQueue(context)

    fun registerUser(user: User, operateCallback: OperateCallback) {
        val endPoint = "user/register"
        val url = "${Constants.BASE_URL}$endPoint"
        val data = JSONObject()

        data.put("full_name", user.fullName)
        data.put("mobile_no", user.mobile)
        data.put("email_id", user.email)
        data.put("password", user.password)

        val request = JsonObjectRequest(Request.Method.POST, url, data,
            {
                apiResponse: JSONObject ->
                val message = apiResponse.getString("message")
                operateCallback.onLoginRegisterSuccess(message)
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            },
            {
                error: VolleyError ->
                val message = error.message.toString()
                operateCallback.onError(message)
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            })

        request.tag = "register_request"
        queue.add(request)
    }

    fun login(email: String, password: String, operateCallback: OperateCallback) {
        val endPoint = "User/auth"
        val url = "${Constants.BASE_URL}$endPoint"
        val data = JSONObject()

        data.put("email_id", email)
        data.put("password", password)

        val request = JsonObjectRequest(Request.Method.POST, url, data,
            {
                apiResponse: JSONObject ->
                val message = apiResponse.getString("message")
                operateCallback.onLoginRegisterSuccess(message)
                val status = apiResponse.getInt("status")
                val preferences = context.getSharedPreferences("login_details", AppCompatActivity.MODE_PRIVATE)

                val editor = preferences.edit()

                editor.putInt("status", status)
                editor.apply()
            },
            {
                error: VolleyError ->
                val message = error.message.toString()
                operateCallback.onError(message)
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            })
        request.tag = "login_request"
        queue.add(request)

    }

    fun loadCategories(operateCallback: OperateCallback){
        val endPoint = "category"
        val url = "${Constants.BASE_URL}$endPoint"

        val request = StringRequest(Request.Method.GET, url,
            {
                apiResponse: String ->
                val typeToken = object: TypeToken<CategoryResponse>(){}
                val myGson = Gson()

                try {
                    val dataResponse: CategoryResponse = myGson.fromJson(apiResponse, typeToken.type)

                    if (dataResponse.status == 0){
                        val categories: List<Category> = dataResponse.categories
                        operateCallback.onCategoriesSuccess(categories)
                    }
                    else{
                        Toast.makeText(context, "Failed to load categories. Please try again.", Toast.LENGTH_LONG).show()
                    }
                } catch (e: Exception){
                    Toast.makeText(context, "Error found: ${e.message}", Toast.LENGTH_LONG).show()
                }
            },
            {
                error: VolleyError ->
                Toast.makeText(context, "Error found: ${error.message}", Toast.LENGTH_LONG).show()
                val message = "Failed"
                operateCallback.onError(message)
            })
        request.tag = "categories_request"
        queue.add(request)
    }

    fun loadSubcategories(categoryId: String, operateCallback: OperateCallback){
        val endPoint = "SubCategory?category_id=$categoryId"
        val url = "${Constants.BASE_URL}$endPoint"

        val request = StringRequest(Request.Method.GET, url,
            {
                    apiResponse: String ->
                val typeToken = object: TypeToken<SubcategoryResponse>(){}
                val myGson = Gson()

                try {
                    val dataResponse: SubcategoryResponse = myGson.fromJson(apiResponse, typeToken.type)

                    if (dataResponse.status == 0){
                        val subcategories: List<Subcategory> = dataResponse.subcategories
                        operateCallback.onSubcategoriesSuccess(subcategories)
                    }
                    else{
                        Toast.makeText(context, "Failed to load categories. Please try again.", Toast.LENGTH_LONG).show()
                    }
                } catch (e: Exception){
                    Toast.makeText(context, "Error found: ${e.message}", Toast.LENGTH_LONG).show()
                }
            },
            {
                    error: VolleyError ->
                Toast.makeText(context, "Error found: ${error.message}", Toast.LENGTH_LONG).show()
                val message = "Failed"
                operateCallback.onError(message)
            })
        request.tag = "subcategories_request"
        queue.add(request)
    }

    fun loadProducts(subcategoryId: String, operateCallback: OperateCallback){
        val endPoint = "SubCategory/products/$subcategoryId"
        val url = "${Constants.BASE_URL}$endPoint"

        val request = StringRequest(Request.Method.GET, url,
            {
                    apiResponse: String ->
                val typeToken = object: TypeToken<ProductsResponse>(){}
                val myGson = Gson()

                try {
                    val dataResponse: ProductsResponse = myGson.fromJson(apiResponse, typeToken.type)

                    if (dataResponse.status == 0){
                        val products: List<Product> = dataResponse.products
                        operateCallback.onProductsSuccess(products)
                    }
                    else{
                        Toast.makeText(context, "Failed to load categories. Please try again.", Toast.LENGTH_LONG).show()
                    }
                } catch (e: Exception){
                    Toast.makeText(context, "Error found: ${e.message}", Toast.LENGTH_LONG).show()
                }
            },
            {
                    error: VolleyError ->
                Toast.makeText(context, "Error found: ${error.message}", Toast.LENGTH_LONG).show()
                val message = "Failed"
                operateCallback.onError(message)
            })
        request.tag = "products_request"
        queue.add(request)
    }

    fun loadProductDetails(productId: String, operateCallback: OperateCallback){
        val endPoint = "product/details/$productId"
        val url = "${Constants.BASE_URL}$endPoint"

        val request = StringRequest(Request.Method.GET, url,
            {
                    apiResponse: String ->
                val typeToken = object: TypeToken<ProductDetailsResponse>(){}
                val myGson = Gson()

                try {
                    val dataResponse: ProductDetailsResponse = myGson.fromJson(apiResponse, typeToken.type)

                    if (dataResponse.status == 0){
                        val productDetails: ProductDetails = dataResponse.product
                        operateCallback.onDetailsSuccess(productDetails)
                    }
                    else{
                        Toast.makeText(context, "Failed to load categories. Please try again.", Toast.LENGTH_LONG).show()
                    }
                } catch (e: Exception){
                    Toast.makeText(context, "Error found: ${e.message}", Toast.LENGTH_LONG).show()
                }
            },
            {
                    error: VolleyError ->
                Toast.makeText(context, "Error found: ${error.message}", Toast.LENGTH_LONG).show()
                val message = "Failed"
                operateCallback.onError(message)
            })
        request.tag = "prod_details_request"
        queue.add(request)
    }
}