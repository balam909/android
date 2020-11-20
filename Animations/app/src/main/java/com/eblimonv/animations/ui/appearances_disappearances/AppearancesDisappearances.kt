package com.eblimonv.animations.ui.appearances_disappearances

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

class AppearancesDisappearances : Fragment() {

    private val APPEARANCE : String = "Un Texto\nApareciendo"
    private val DISAPPEARANCE : String = "Un Texto\nDesapareciendo"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root : View = inflater.inflate(R.layout.fragment_appearances_disappearances, container, false)
        val textView : TextView = root.findViewById(R.id.text_animation_series)
        val appearanceButton : Button = root.findViewById(R.id.b_start_appearance)
        val disappearanceButton : Button = root.findViewById(R.id.b_start_disappearance)
        appearanceButton.setOnClickListener { view -> startAnimation(view, textView, R.anim.appearance, APPEARANCE )}
        disappearanceButton.setOnClickListener { view -> startAnimation(view, textView, R.anim.disappearance, DISAPPEARANCE )}
        return root
    }

    private fun startAnimation(view: View, textView: TextView, animationKey: Int, text: String) {
        val animation : Animation = AnimationUtils.loadAnimation(view.context, animationKey)
        animation.repeatMode = Animation.RESTART
        animation.repeatCount = 20
        animation.fillAfter = true
        textView.text = text
        textView.startAnimation(animation)
    }

}