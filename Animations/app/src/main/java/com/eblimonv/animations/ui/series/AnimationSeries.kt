package com.eblimonv.animations.ui.series

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

class AnimationSeries : Fragment() {

    private val TEXT : String = "ANIMÁNDOME"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root : View = inflater.inflate(R.layout.fragment_animation_series, container, false)
        val textView : TextView = root.findViewById(R.id.text_animation_series)
        val button : Button = root.findViewById(R.id.b_start_animation_series)
        button.setOnClickListener{view -> startAnimation(view, textView)}
        return root
    }

    private fun startAnimation(view: View, textView: TextView) {
        val animation : Animation = AnimationUtils.loadAnimation(view.context, R.anim.animation_serie)
        animation.fillAfter = true
        animation.repeatCount = Animation.RESTART
        animation.repeatCount = 5
        textView.text = TEXT;
        textView.startAnimation(animation)
    }

}