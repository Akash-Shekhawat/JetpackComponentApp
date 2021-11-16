package com.example.jetpackcomponentapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_person_view.view.*

class CustomAdapter(
    private val context: Context,
    private val personsDataset: ArrayList<DataClass>
): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val personNameTextView: TextView = view.personName_TV
        val personContactTextView: TextView = view.personContact_TV
        val personAddressTextView: TextView = view.personAddress_TV
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_person_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = personsDataset.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val personName = personsDataset[position].personName
        val personContact = personsDataset[position].personContact
        val personAddress = personsDataset[position].personAddress

        holder.personNameTextView.text = personName
        holder.personContactTextView.text = personContact
        holder.personAddressTextView.text = personAddress
    }
}