package com.example.examactivityfragment.fragment.waytwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import com.example.examactivityfragment.R
import com.example.examactivityfragment.activity.IFragmentCallBack
import com.example.examactivityfragment.activity.UseInterActivity2
import com.example.examactivityfragment.utils.Constants

class FragmentA : Fragment(R.layout.fragment_a) {
    lateinit var iFragmentCallBack: IFragmentCallBack
    var string: String = ""
    companion object {
        fun instance1(stringText: String): FragmentA {
            val fragment = FragmentA()
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
        val btnA = view.findViewById<Button>(R.id.btnA)
        val editTextA = view.findViewById<EditText>(R.id.editTextA)

        editTextA.setText(string)
        btnA.setOnClickListener {
            val textName = editTextA?.text.toString()
            iFragmentCallBack.switchFragment(Constants.idFragmentB, textName)
        }

    }
}