package com.allen.constraintlayout.constraintlayoutsample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.View
import com.allen.constraintlayout.constraintlayoutsample.adapter.ActivityAdapter
import com.allen.constraintlayout.constraintlayoutsample.model.ActivityModel
import com.chad.library.adapter.base.BaseQuickAdapter
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ActivityAdapter
    lateinit var mDataList: ArrayList<ActivityModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        initData()
        adapter = ActivityAdapter(mDataList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        adapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener({ baseQuickAdapter: BaseQuickAdapter<*, *>?, view: View?, position: Int ->
            val intent = Intent(this@MainActivity, ACTIVITY[position])
            startActivity(intent)
        })
    }

    companion object {
        private val ACTIVITY = arrayOf<Class<*>>(CircleConstraintLayoutActivity::class.java,PullToFinishActivity::class.java,CoordinatorAcitivity::class.java)
        private val TITLE = arrayOf("CircleConstraintLayoutActivity","PullToFinishActivity","CoordinatorAcitivity")
    }

    private fun initData() {
        mDataList = ArrayList<ActivityModel>()
        for (i in TITLE.indices) {
            val item = ActivityModel()
            item.name = TITLE[i]
            mDataList.add(item)
        }
    }

}
