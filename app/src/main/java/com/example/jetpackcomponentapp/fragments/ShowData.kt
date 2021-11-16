package com.example.jetpackcomponentapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackcomponentapp.CustomAdapter
import com.example.jetpackcomponentapp.R
import com.example.jetpackcomponentapp.DataClass
import com.example.jetpackcomponentapp.viewmodels.ViewModelclass
import kotlinx.android.synthetic.main.fragment_show_data.*


class ShowData : Fragment() {

    private lateinit var customAdapter: CustomAdapter
    private val TAG = "DisplayDataFragment"
    private var personList: ArrayList<DataClass> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_data, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i(TAG, "onActivityCreated")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "onViewCreated")

        setupUI()

        addPersonDetails_FAB.setOnClickListener {
            openAddPersonDetailsFragment()
        }
    }

    private fun setupUI() {
        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        personDetails_RV.layoutManager = linearLayoutManager
        setupListFromRoom()
    }

    private fun setupListFromRoom() {

        val application = activity!!.application
        val personViewModel = ViewModelProvider(this).get(ViewModelclass(application)::class.java)

        personViewModel.allPersons.observe(viewLifecycleOwner, Observer {

            personList = it as ArrayList<DataClass>
            customAdapter = CustomAdapter(context!!, personList)
            personDetails_RV.adapter = customAdapter
            customAdapter.notifyDataSetChanged()
        })


    }

    private fun openAddPersonDetailsFragment() {
        val fragmentManager = fragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragmentContainer_FL, AddData())
        // Add fragment to backstack
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.commit()
    }

}