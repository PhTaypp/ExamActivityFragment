package com.example.examactivityfragment.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.examactivityfragment.R
import com.example.examactivityfragment.fragment.wayone.Fragment1
import com.example.examactivityfragment.fragment.wayone.Fragment2

class UseInterActivity : AppCompatActivity(), Fragment1.Fragment1Listener, Fragment2.Fragment2Listener  {
    private lateinit var fragment1 : Fragment
    private lateinit var fragment2 : Fragment
    lateinit var tvTitle : TextView
    var value: CharSequence? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_use_inter)
        tvTitle = findViewById(R.id.tv_title)
        fragment1 = Fragment1()
        fragment2 = Fragment2()
        setLayoutFragment1()
    }

    override fun onFrag1Sent(result: CharSequence?) {
        if (result != null) {
            value = result
        }
        setLayoutFragment2()
    }

    override fun onFrag2Sent(result : CharSequence?) {
        if (result != null) {
            value = result
        }
        setLayoutFragment1()
    }
    private fun updateFragment(fragment : Fragment){
        val fm: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        fragment.let { ft.replace(R.id.fragment_content, it) }
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        ft.commit()
    }
    private fun setLayoutFragment1(){
        updateFragment(fragment1)
        tvTitle.text = this.getString(R.string.fragment1)
    }
    private fun setLayoutFragment2(){
        updateFragment(fragment2)
        tvTitle.text = this.getString(R.string.fragment2)
    }
}


