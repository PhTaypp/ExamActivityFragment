package com.example.examactivityfragment.fragment.wayone

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.example.examactivityfragment.R
import com.example.examactivityfragment.activity.UseInterActivity


class Fragment1 : Fragment(R.layout.fragment_1) {
    lateinit var btn1 : AppCompatButton
    lateinit var editText1 : EditText
    var listener1 : Fragment1Listener? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        btn1.setOnClickListener{
            val result = editText1.text
            listener1!!.onFrag1Sent(result)
        }
    }
    private fun initView(){
        btn1 = view!!.findViewById(R.id.btn1)
        editText1 = view!!.findViewById(R.id.editText1)
    }

    override fun onStart() {
        super.onStart()
        val activity = context as UseInterActivity
        activity.value?.let {
            editText1.setText(it)
        }
        print("llllll")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Fragment1Listener) {
            listener1 = context
        } else {
            throw RuntimeException(
                "$context implement FragmentAListener"
            )
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener1 = null
    }

    fun updateEditText1(text : CharSequence) {
        editText1.setText(text)
    }
    interface Fragment1Listener {
        fun onFrag1Sent(result : CharSequence?)
    }

}