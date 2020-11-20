package com.eblimonv.animations.ui.code

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import android.widget.Button
import android.widget.TextView
import com.eblimonv.animations.R

/**
 * A simple [Fragment] subclass.
 * Use the [AnimationsInCode.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnimationsInCode : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root : View = inflater.inflate(R.layout.fragment_animations_in_code, container, false)
        val textViewSubject : TextView = root.findViewById(R.id.text_animation_series_title)
        textViewSubject.text = "Una serie de animaciones utilizando código"

        val textViewObject : TextView = root.findViewById(R.id.text_animation_series)
        textViewObject.text = "Me animo mediante código"

        val animationSet = AnimationSet(true)

        val button : Button = root.findViewById(R.id.b_start_animation_series)
        button.setOnClickListener{startAnimation(textViewObject, animationSet)}

        return root
    }

    private fun startAnimation(textViewObject : TextView, animationSet : AnimationSet){
        val appearanceAnimation = AlphaAnimation(0F,1F)
        appearanceAnimation.duration = 3000
        animationSet.addAnimation(appearanceAnimation)

        val rs : Int = ScaleAnimation.RELATIVE_TO_SELF
        val scale = ScaleAnimation(1.0f,2.0f,1.0f,5.0f,rs,0.5f,rs,0.5f)
        scale.duration = 3000
        scale.startOffset = 300
        animationSet.addAnimation(scale)

        val rs2 : Int = RotateAnimation.RELATIVE_TO_SELF
        val rotateAnimation = RotateAnimation(0f,45f,rs2,0.5f,rs2,0.5f)
        rotateAnimation.duration = 3000
        rotateAnimation.startOffset = 6000
        animationSet.addAnimation(rotateAnimation)

        val rs3 : Int = TranslateAnimation.RELATIVE_TO_PARENT
        val translateAnimation = TranslateAnimation(rs3,0f,rs3,0f,rs3,0f,rs3,0.25f);
        translateAnimation.duration = 3000
        translateAnimation.startOffset = 9000
        animationSet.addAnimation(translateAnimation)

        textViewObject.startAnimation(animationSet)
    }

}