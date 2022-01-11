package com.example.examactivityfragment.fragment.waytwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import com.example.examactivityfragment.R
import com.example.examactivityfragment.activity.IFragmentCallBack
import com.example.examactivityfragment.activity.UseInterActivity2
import com.example.examactivityfragment.utils.Constants

class FragmentB : Fragment(R.layout.fragment_b) {
    lateinit var iFragmentCallBack: IFragmentCallBack
    var string: String = ""
    companion object {
        fun instance2(stringText: String): FragmentB {
            val fragment = FragmentB()
            val bundle = bundleOf("text" to stringText)
            fragment.arguments = bundle
            return fragment
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (context is UseInterActivity2) {
            iFragmentCallBack = context as UseInterActivity2
        }
        arguments?.let {
            val text = arguments?.getString("text")
            string = text.toString()
        }
        val btnB = view.findViewById<Button>(R.id.btnB)
        val editTextB = view.findViewById<EditText>(R.id.editTextB)

        editTextB?.setText(string)
        btnB.setOnClickListener {
            val textName = editTextB?.text.toString()
            iFragmentCallBack.switchFragment(Constants.idFragmentA, textName)
        }

    }
}