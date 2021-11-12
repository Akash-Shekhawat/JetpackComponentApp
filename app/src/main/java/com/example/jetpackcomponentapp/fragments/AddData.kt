package com.example.jetpackcomponentapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcomponentapp.R
import com.example.jetpackcomponentapp.DataClass
import com.example.jetpackcomponentapp.viewmodels.ViewModelclass
import kotlinx.android.synthetic.main.fragment_add_data.*


class AddData : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachListeners()
    }

    private fun attachListeners() {
        addData_BTN.setOnClickListener {
            addDataInRoomDB()
            Toast.makeText(context, "Data added successfully", Toast.LENGTH_LONG).show()
            fragmentManager?.popBackStack()
        }

        /**
         * Go back to previous fragment
         * from the stack
         */
        cancelAddingDetails_BTN.setOnClickListener {
            fragmentManager?.popBackStack()

        }
    }

    private fun addDataInRoomDB() {
        /*val roomDatabaseBuilder = context?.let { DatabaseBuilder.getInstance(it) }
          Executors.newSingleThreadExecutor().execute {
              roomDatabaseBuilder!!.personDao().insertPersonDetails(
                  PersonDataClass(
                      personId = null,
                      personName = personName_ET.text.toString(),
                      personContact = personContact_ET.text.toString(),
                      personAddress = personAddress_ET.text.toString()
                  )
              )
          }*/

        val application = activity!!.application
        val personViewModel = ViewModelProvider(this).get(ViewModelclass(application)::class.java)
        personViewModel.addPersonDetails(
            DataClass(
                personId = null,
                personName = personName_ET.text.toString(),
                personContact = personContact_ET.text.toString(),
                personAddress = personAddress_ET.text.toString()
            )
        )
    }
}