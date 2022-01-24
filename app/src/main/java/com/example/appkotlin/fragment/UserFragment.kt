package com.example.appkotlin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appkotlin.R
import com.example.appkotlin.adapter.UserAdapter
import com.example.appkotlin.model.User

class UserFragment : Fragment() {

    private lateinit var userAdapter: UserAdapter
    private lateinit var users: ArrayList<User>
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_user, container, false)

        initViews(view)

        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.rv_user)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        users = addUsers()

        refreshAdapter()
    }

    private fun refreshAdapter() {
        userAdapter = UserAdapter(users)
        recyclerView.adapter = userAdapter
    }

    private fun addUsers(): java.util.ArrayList<User> {
        return ArrayList<User>().apply {
            for (i in 1..5) {
                this.add(User("MirkamolEgamberdiyev", "6325836785972"))
                this.add(User("MuhammadyusufSaliyev", "37846537"))
                this.add(User("KhurshidKobilov", "83945739"))
                this.add(User("JaloliddinAbdullayev", "5384957"))
                this.add(User("ShoxruxGafurov", "348945908"))
            }
        }
    }
}