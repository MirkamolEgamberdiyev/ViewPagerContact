package com.example.appkotlin.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appkotlin.R
import com.example.appkotlin.adapter.PostAdapter
import com.example.appkotlin.listener.OnClickListenerShare
import com.example.appkotlin.model.Post


class PostFragment : Fragment() {

    private lateinit var postAdapter: PostAdapter
    private lateinit var recyclerView: RecyclerView
    lateinit var posts: ArrayList<Post>

    private var onClickListenerShare = object : OnClickListenerShare {
        override fun sharePost(position: Int) {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "image/plain"
            val uri = Uri.parse(
                "android.resource://" + R::class.java.getPackage().name + "/" + posts[position].image
            )
            shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
            shareIntent.putExtra(Intent.EXTRA_TEXT, posts[position].description)
            startActivity(Intent.createChooser(shareIntent, "Share"))
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            inflater.inflate(R.layout.fragment_post, container, false)

        initViews(view)

        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.rv_post)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        posts = addPosts()

        refreshAdapter()
    }

    private fun refreshAdapter() {
        postAdapter = PostAdapter(posts, onClickListenerShare)
        recyclerView.adapter = postAdapter
    }

    private fun addPosts(): java.util.ArrayList<Post> {
        return ArrayList<Post>().apply {
            for (i in 1..5) {
                this.add(
                    Post(
                        R.drawable.land_1,
                        "My favourite car"
                    )
                )
                this.add(
                    Post(
                        R.drawable.land_1,
                        "My favourite car"
                    )
                )
                this.add(
                    Post(
                        R.drawable.land_1,
                        "My favourite car"
                    )
                )
                this.add(
                    Post(
                        R.drawable.land_1,
                        "My favourite car"
                    )
                )
            }
        }
    }
}