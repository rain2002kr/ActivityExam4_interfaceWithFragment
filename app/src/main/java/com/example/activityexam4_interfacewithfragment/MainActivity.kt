package com.example.activityexam4_interfacewithfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_blank.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_send.setOnClickListener(View.OnClickListener {
            supportFragmentManager.findFragmentById(R.id.blankFragment).let{
                if(it is BlankFragment){
                    it.setActivityText(inputText.text.toString())
                }
            }
        })

        supportFragmentManager.beginTransaction()
            .replace(R.id.blankFragment,BlankFragment())
            .commit()
    }
    override fun onAttachFragment(fragment: androidx.fragment.app.Fragment) {
        super.onAttachFragment(fragment)
        if(fragment is BlankFragment){
            fragment.onTextListener = object:BlankFragment.OnTextListener{
                override fun onTextChange(text: String?) {
                    fragmentText.setText(text)
                }
            }
        }
    }
}
