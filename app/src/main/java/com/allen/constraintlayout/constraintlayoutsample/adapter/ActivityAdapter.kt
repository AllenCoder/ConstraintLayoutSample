package com.allen.constraintlayout.constraintlayoutsample.adapter

import com.allen.constraintlayout.constraintlayoutsample.R
import com.allen.constraintlayout.constraintlayoutsample.model.ActivityModel
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by Allen on 2017/10/17.
 */
class ActivityAdapter(data: ArrayList<ActivityModel>?) : BaseQuickAdapter<ActivityModel, BaseViewHolder>(R.layout.item_constraint, data) {
    override fun convert(viewholder: BaseViewHolder?, activityModel: ActivityModel?) {
        viewholder?.setText(R.id.title, activityModel?.name)
    }
}