package com.eblimonv.animations.ui.rotations

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

class Rotations : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root : View = inflater.inflate(R.layout.fragment_rotations, container, false)
        val textView : TextView = root.findViewById(R.id.text_animation_series)
        val button : Button = root.findViewById(R.id.b_start_animation_series)
        button.setOnClickListener{ view -> startRotate(view, textView)}
        return root
    }

    private fun startRotate(view: View, textView: TextView) {
        val animation : Animation = AnimationUtils.loadAnimation(view.context, R.anim.rotation)
        animation.repeatMode = Animation.RESTART
        animation.repeatCount = 20
        animation.fillAfter = true
        textView.startAnimation(animation)
    }

}