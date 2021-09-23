package com.michaelpessoni.mygithubrepos.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.michaelpessoni.mygithubrepos.R
import com.michaelpessoni.mygithubrepos.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity(), SearchView.OnQueryTextListener {

    companion object {
        const val TAG = "TAG"
    }

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val searchView = menu.findItem(R.id.action_search).actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        Log.e(TAG, "onQueryTextSubmit: $p0")
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        Log.e(TAG, "onQueryTextChange: $p0")
        return false
    }

}