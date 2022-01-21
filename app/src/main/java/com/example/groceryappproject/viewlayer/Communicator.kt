package com.example.groceryappproject.viewlayer

import androidx.fragment.app.Fragment

interface Communicator {
    fun passIdData(newFragment: Fragment, tag: String, itemId: String)
}