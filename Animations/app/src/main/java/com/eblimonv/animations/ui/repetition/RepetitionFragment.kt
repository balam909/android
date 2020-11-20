package com.eblimonv.animations.ui.repetition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.eblimonv.animations.R

class RepetitionFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_repetition, container, false)
        val textView: TextView = root.findViewById(R.id.text_repetition)
        val button : Button = root.findViewById(R.id.b_start_repetition)
        button.setOnClickListener{view -> startAnimation(view, textView)}
        return root
    }

    private fun startAnimation(view : View, textView : TextView){
        val animation : Animation = AnimationUtils.loadAnimation(view.context, R.anim.repetition)
        animation.repeatMode = Animation.RESTART
        animation.repeatCount = 20
        animation.fillAfter = true
        textView.startAnimation(animation)
        textView.append("\nRepeatMode: "+animation.repeatMode)
        textView.append("\nRepeatCount: "+animation.repeatCount)
    }
}