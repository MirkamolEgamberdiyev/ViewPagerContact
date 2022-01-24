package com.example.appkotlin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appkotlin.R
import com.example.appkotlin.adapter.ContactAdapter2
import com.example.appkotlin.model.Contact

class ContactFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var contactAdapter2: ContactAdapter2
    private lateinit var contacts: ArrayList<Contact>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_contact, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        contacts = addContacts()
        recyclerView = view.findViewById(R.id.rv_contact)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        refreshAdapter()
    }

    private fun refreshAdapter() {
        contactAdapter2 = ContactAdapter2(contacts)
        recyclerView.adapter = contactAdapter2
    }

    private fun addContacts(): java.util.ArrayList<Contact> {
        return ArrayList<Contact>().apply {
            for (i in 1..10) {
                this.add(Contact("Muhammadyusuf", "90-520-29-51"))
                this.add(Contact("Mirkamol", "97-469-79-07"))
                this.add(Contact("Khurshid", "91-114-67-61"))
                this.add(Contact("Jaloliddin", "99-452-23-99"))
            }
        }
    }
}