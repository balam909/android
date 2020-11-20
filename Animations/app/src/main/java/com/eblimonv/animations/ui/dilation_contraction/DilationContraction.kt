package com.eblimonv.animations.ui.dilation_contraction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import com.eblimonv.animations.R

class DilationContraction : Fragment() {

    private val DILATION_TEXT : String = "Un texto\nDILATANDO"
    private val CONTRACTION_TEXT : String = "Un texto\nCONTRAYENDO"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root : View = inflater.inflate(R.layout.fragment_dilation_contraction, container, false)
        val textView : TextView = root.findViewById(R.id.text_animation_series)
        val dilation : Button = root.findViewById(R.id.b_start_appearance)
        val contraction : Button = root.findViewById(R.id.b_start_disappearance)
        dilation.setOnClickListener{ view -> startAnimation(view, textView, R.anim.dilation, DILATION_TEXT) }
        contraction.setOnClickListener{ view -> startAnimation(view, textView, R.anim.contraction, CONTRACTION_TEXT) }
        return root
    }

    private fun startAnimation(view: View, textView: TextView, animationKey : Int, text : String) {
        val animation = AnimationUtils.loadAnimation(view.context, animationKey)
        animation.repeatMode = Animation.RESTART
        animation.repeatCount = 20
        animation.fillAfter = true
        textView.text = text
        textView.startAnimation(animation)
    }

}