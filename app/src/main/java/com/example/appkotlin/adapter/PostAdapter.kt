package com.example.appkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.appkotlin.R
import com.example.appkotlin.listener.OnClickListenerShare
import com.example.appkotlin.model.Post
import com.google.android.material.snackbar.Snackbar

class PostAdapter(
    private val posts: ArrayList<Post>,
    private val onClickListenerShare: OnClickListenerShare
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_post_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post = posts[position]

        (holder as PostViewHolder).apply {
            image_post.setImageResource(post.image)
            tv_post.text = post.description
            share_icon.setOnClickListener {
                onClickListenerShare.sharePost(position)
            }
            like_icon.setOnClickListener {
                tv_like_counter.text = (tv_like_counter.text.toString().toInt() + 1).toString()
                tv_like_counter.visibility = View.VISIBLE
            }
            comment_icon.setOnClickListener {
                if (ll_comment.visibility == View.VISIBLE)
                    ll_comment.visibility = View.GONE
                else
                    ll_comment.visibility = View.VISIBLE
            }
            btn_comment.setOnClickListener {
                if (edt_comment.text.isNotBlank()) {
                    Snackbar.make(view, "Thanks for leaving comment", Snackbar.LENGTH_SHORT).show()
                }
                ll_comment.visibility = View.GONE
                edt_comment.text = null
            }
        }
    }

    override fun getItemCount(): Int = posts.size

    class PostViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val image_post: ImageView = view.findViewById(R.id.image_post)
        val tv_post: TextView = view.findViewById(R.id.tv_post)
        val share_icon: ImageView = view.findViewById(R.id.image_icon_share)
        val like_icon: ImageView = view.findViewById(R.id.image_icon_like)
        val comment_icon: ImageView = view.findViewById(R.id.image_icon_comment)
        val tv_like_counter: TextView = view.findViewById(R.id.tv_like_counter)
        val ll_comment: LinearLayout = view.findViewById(R.id.ll_comment)
        val btn_comment: Button = view.findViewById(R.id.btn_comment)
        val edt_comment: EditText = view.findViewById(R.id.edt_comment)
    }
}