package com.example.examactivityfragment.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.examactivityfragment.R
import com.example.examactivityfragment.fragment.waytwo.FragmentA
import com.example.examactivityfragment.fragment.waytwo.FragmentB
import com.example.examactivityfragment.utils.Constants

class UseInterActivity2 : AppCompatActivity(),IFragmentCallBack {
    private lateinit var fragmenta : Fragment
    private lateinit var fragmentb : Fragment
    lateinit var tvTitle2 : TextView
    var value: CharSequence? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_use_inter2)
        tvTitle2 = findViewById(R.id.tv_title2)
        fragmenta = FragmentA()
        fragmentb = FragmentB()
    }
    override fun onResume() {
        super.onResume()
        val fm: FragmentManager = supportFragmentManager
        val ftAdd: FragmentTransaction = fm.beginTransaction()
        ftAdd.add(R.id.fragment_content2, FragmentA())
        ftAdd.commit()
    }
    override fun switchFragment(idFragment: Int, textName: String) {
        val fm: FragmentManager = supportFragmentManager
        if(idFragment == Constants.idFragmentB){
            val fmReplace: FragmentTransaction = fm.beginTransaction()
            fmReplace.replace(R.id.fragment_content2, FragmentB.instance2(textName))
            tvTitle2.text = this.getString(R.string.fragmentB)
            fmReplace.commit()
        } else if(idFragment == Constants.idFragmentA){
            val fmReplace: FragmentTransaction = fm.beginTransaction()
            fmReplace.replace(R.id.fragment_content2, FragmentA.instance1(textName))
            tvTitle2.text = this.getString(R.string.fragmentA)
            fmReplace.commit()
        }
    }

}
interface IFragmentCallBack {
    fun switchFragment(idFragment: Int, textName: String)
}
