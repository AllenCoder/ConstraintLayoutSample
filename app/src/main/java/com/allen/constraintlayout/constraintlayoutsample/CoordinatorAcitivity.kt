package com.allen.constraintlayout.constraintlayoutsample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View


class CoordinatorAcitivity : AppCompatActivity() {
    lateinit var viewPage: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_acitivity)

        viewPage = findViewById(R.id.today_dynamic_viewpager)
        var pagerAdapter = MyFragmentPagerAdapter(supportFragmentManager)
        viewPage.adapter = pagerAdapter
    }

    inner class MyFragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {


        override fun getCount(): Int {
            return 1
        }

        override fun getItem(arg0: Int): Fragment {

            return BlankFragment.newInstance("1", "2")
        }


    }
}
