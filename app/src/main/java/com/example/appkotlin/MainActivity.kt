package com.example.appkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.appkotlin.fragment.ContactFragment
import com.example.appkotlin.fragment.PostFragment
import com.example.appkotlin.fragment.UserFragment
import com.example.appkotlin.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(){

    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var contactFragment: ContactFragment
    private lateinit var userFragment: UserFragment
    private lateinit var postFragment: PostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        viewPager = findViewById(R.id.vp_main)

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        contactFragment = ContactFragment()
        userFragment = UserFragment()
        postFragment = PostFragment()


        viewPagerAdapter.addFragment(contactFragment, "Contacts")
        viewPagerAdapter.addFragment(userFragment, "Users")
        viewPagerAdapter.addFragment(postFragment, "Posts")

        viewPager.adapter = viewPagerAdapter

        tabLayout = findViewById(R.id.tab)
        tabLayout.setupWithViewPager(viewPager)
    }
}