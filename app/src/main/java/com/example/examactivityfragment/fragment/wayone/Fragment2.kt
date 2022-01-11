package com.example.examactivityfragment.fragment.wayone

import android.content.Context
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.example.examactivityfragment.R
import com.example.examactivityfragment.activity.UseInterActivity


class Fragment2 : Fragment(R.layout.fragment_2) {
    lateinit var editText2: EditText
    lateinit var btn2 : AppCompatButton
    private var listener2: Fragment2Listener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        btn2.setOnClickListener{
            val result = editText2.text
            listener2!!.onFrag2Sent(result)
        }
    }

    private fun initView(){
        btn2 = view!!.findViewById(R.id.btn2)
        editText2 = view!!.findViewById(R.id.editText2)
    }

    override fun onStart() {
        super.onStart()
        val activity = context as UseInterActivity
        activity.value?.let {
            editText2.setText(it)
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Fragment2Listener) {
            listener2 = context
        } else {
            throw RuntimeException(
                "$context implement FragmentAListener"
            )
        }
    }

    override fun onDetach() {
        super.onDetach()
        // close listener
        listener2 = null
    }
   fun updateEditText2(text : CharSequence) {
        editText2.text = text as Editable?
    }

    interface Fragment2Listener {
        fun onFrag2Sent(input: CharSequence?)
    }

}