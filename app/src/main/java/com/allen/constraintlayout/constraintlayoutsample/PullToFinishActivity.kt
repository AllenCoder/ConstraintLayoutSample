package com.allen.constraintlayout.constraintlayoutsample

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ooo.oxo.library.widget.PullBackLayout
import android.content.Intent



class PullToFinishActivity : AppCompatActivity(), PullBackLayout.Callback {
    val TAG ="PullToFinishActivity"
    override fun onPullStart() {
        Log.d(TAG,"onPullStart")
    }

    override fun onPull(p0: Float) {
    }

    override fun onPullCancel() {
    }

    override fun onPullComplete() {
        Log.d(TAG,"onPullComplete")
        supportFinishAfterTransition()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pull_to_finish)
        var puller = findViewById<PullBackLayout>(R.id.puller)
        puller.setCallback(this)

    }

    override fun supportFinishAfterTransition() {
//        val data = Intent()
//        data.putExtra("index", binding.pager.getCurrentItem())
//        setResult(Activity.RESULT_OK, data)
//
//        showSystemUi()

        super.supportFinishAfterTransition()
    }
}
