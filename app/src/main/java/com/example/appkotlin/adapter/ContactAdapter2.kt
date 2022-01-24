package com.example.appkotlin.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appkotlin.R
import com.example.appkotlin.model.Contact

class ContactAdapter2(private val contacts: ArrayList<Contact>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ContactViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val contact = contacts[position]

        (holder as ContactViewHolder).apply {
            tv_contact_name.text = contact.name
            tv_contact_number.text = contact.number
        }
    }

    override fun getItemCount(): Int = contacts.size

    class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_contact_name: TextView = view.findViewById(R.id.tv_con_name)
        val tv_contact_number: TextView = view.findViewById(R.id.tv_con_number)
    }
}