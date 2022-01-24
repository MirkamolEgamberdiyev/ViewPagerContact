package com.example.appkotlin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(private val fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    private val fragments: ArrayList<Fragment> = ArrayList()
    private val fragmentTitles: ArrayList<String> = ArrayList()

    override fun getCount(): Int = fragments.size

    override fun getItem(position: Int): Fragment = fragments[position]

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        fragmentTitles.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence = fragmentTitles[position]
}