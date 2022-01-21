package com.example.groceryappproject.viewlayer

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.groceryappproject.R
import com.example.groceryappproject.databinding.ActivityHomeBinding
import com.example.groceryappproject.datalayer.MyItemClickListener
import com.example.groceryappproject.datalayer.model.Category
import com.example.groceryappproject.datalayer.remote.MyRequestHandler
import com.example.groceryappproject.presenterlayer.HomeMVP
import com.example.groceryappproject.presenterlayer.HomePresenter
import com.google.android.material.navigation.NavigationView
import java.util.*

class HomeActivity : AppCompatActivity(), HomeMVP.HomeViewInt, Communicator {
    lateinit var homeBinding: ActivityHomeBinding
    lateinit var categoryAdapter: CategoryAdapter
    lateinit var homePresenter: HomePresenter
    lateinit var drawerLayout: DrawerLayout
    var categories: List<Category> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        drawerLayout = findViewById(R.id.drawer_layout)
        val requestHandler = MyRequestHandler(this)
        homeBinding.categoriesRv.layoutManager = LinearLayoutManager(this)
        homePresenter = HomePresenter(requestHandler, this)
        homePresenter.displayCategories()

        setNavDrawer()
    }

    private fun setNavDrawer() {
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.home_toolbar)

        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)

        navigationView.setNavigationItemSelectedListener { menuItems ->
            menuItems.isChecked = true
            this.drawerLayout.closeDrawers()

            when (menuItems.itemId) {
                R.id.profile -> {
                    Toast.makeText(this, "Profile", Toast.LENGTH_LONG).show()
                }
                R.id.shop -> {
                    categoryAdapter = CategoryAdapter(categories, object: MyItemClickListener{
                        override fun onCategoryClicked(categoryId: String) {
                            loadFragment(categoryId)
                        }

                        override fun onSubcategoryClicked(subcategoryId: String) {
                        }

                        override fun onProductClicked(productId: String) {
                        }
                    })
                    Toast.makeText(this, "Shopping Items", Toast.LENGTH_LONG).show()
                }
                R.id.my_orders -> {
                    Toast.makeText(this, "Settings", Toast.LENGTH_LONG).show()
                }
                R.id.logout -> {
                    Toast.makeText(this, "Offer", Toast.LENGTH_LONG).show()
                }
            }
            true
        }

    }

    override fun setResult(categories: List<Category>) {
        homeBinding.categoriesLoading.visibility = View.GONE
        homeBinding.apply {
            categoryAdapter = CategoryAdapter(categories, object: MyItemClickListener{
                override fun onCategoryClicked(categoryId: String) {
                    loadFragment(categoryId)
                }

                override fun onSubcategoryClicked(subcategoryId: String) {
                }

                override fun onProductClicked(productId: String) {
                }
            })
            categoriesRv.adapter = categoryAdapter
        }
    }

    override fun onLoad(isLoading: Boolean) {
        if (isLoading){
            homeBinding.categoriesLoading.visibility = View.VISIBLE
        }
        else{
            homeBinding.categoriesLoading.visibility = View.GONE
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                this.drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers()
        } else {
            super.onBackPressed()
        }
    }

    fun loadFragment(categoryId: String) {
        val bundle = Bundle()
        bundle.putString("categoryId", categoryId)
        val fragment = SubcategoryFragment()
        fragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.drawer_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun passIdData(newFragment: Fragment, tag: String, itemId: String) {
        val bundle = Bundle()
        bundle.putString(tag, itemId)
        val fragment = newFragment
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().add(R.id.drawer_layout, fragment).commit()
    }

}