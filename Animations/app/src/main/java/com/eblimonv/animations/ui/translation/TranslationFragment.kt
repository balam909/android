package com.eblimonv.animations.ui.translation

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

class TranslationFragment : Fragment() {

    private val text : String = "\n Texto añadido";

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_translation, container, false)
        val rightTranslationButton : Button = root.findViewById(R.id.b_t_right)
        val leftTranslationButton : Button = root.findViewById(R.id.b_t_left)
        val textView: TextView = root.findViewById(R.id.text_translation)
        rightTranslationButton.setOnClickListener {v -> translation(v, textView, R.anim.right_translation) }
        leftTranslationButton.setOnClickListener {v -> translation(v, textView, R.anim.left_translation)}
        return root
    }

    private fun translation(view: View, textView: TextView, transitionId : Int){
        val animation : Animation = AnimationUtils.loadAnimation(view.context, transitionId)
        animation.fillAfter = true
        textView.animation = animation
        if(!textView.text.contains(text)){
            textView.append(text)
        }
    }
}