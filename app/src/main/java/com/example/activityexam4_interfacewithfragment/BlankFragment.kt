package com.example.activityexam4_interfacewithfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_blank.*

class BlankFragment : Fragment() {

    interface OnTextListener{
        fun onTextChange(text:String?)
    }
    var onTextListener : OnTextListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bt_confirm.setOnClickListener{
            onTextListener?.onTextChange("확인되었습니다.")
        }
    }

    fun setActivityText(text: String?){
        activityText.setText(text)
    }
}
