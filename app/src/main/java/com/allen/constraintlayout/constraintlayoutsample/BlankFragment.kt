package com.allen.constraintlayout.constraintlayoutsample

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.allen.constraintlayout.constraintlayoutsample.adapter.ActivityAdapter
import com.allen.constraintlayout.constraintlayoutsample.adapter.DataAdapter
import com.allen.constraintlayout.constraintlayoutsample.model.ActivityModel
import com.chad.library.adapter.base.BaseQuickAdapter


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {


    lateinit var recyclerView: RecyclerView
    lateinit var adapter: DataAdapter
    lateinit var mDataList: ArrayList<ActivityModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var data = ArrayList<String>()
        for (i in 0..99) {
            data.add(i.toString())
        }
        adapter = DataAdapter(data)
        adapter.onItemClickListener= BaseQuickAdapter.OnItemClickListener({ baseQuickAdapter: BaseQuickAdapter<*, *>?, view: View?, i: Int ->
            Log.d("BlankFragment",i.toString())
        })
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view  =inflater!!.inflate(R.layout.fragment_blank, container, false)
        recyclerView =view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        return view
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }


    companion object {
        fun newInstance(param1: String, param2: String): BlankFragment {
            val fragment = BlankFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
