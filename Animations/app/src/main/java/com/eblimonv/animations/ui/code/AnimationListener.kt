package com.eblimonv.animations.ui.code

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Button
import android.widget.TextView
import com.eblimonv.animations.R

/**
 * A simple [Fragment] subclass.
 * Use the [AnimationListener.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnimationListener : Fragment(), Animation.AnimationListener {

    private var i : Int = 0;
    private var textViewObject : TextView? = null
    private var scale : ScaleAnimation? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root : View = inflater.inflate(R.layout.fragment_animation_listener, container, false)

        val textViewSubject : TextView = root.findViewById(R.id.text_animation_series_title)
        textViewSubject.text = "Usando la Interfaz Animation Listener"

        textViewObject = root.findViewById(R.id.text_animation_series)
        textViewObject?.text = "CONTADOR = "+i

        val button : Button = root.findViewById(R.id.b_start_animation_series)
        button.setOnClickListener{startAnimation()}

        return root
    }

    private fun startAnimation(){
        // animación aparición
        val appearance = AlphaAnimation(0F,1F);
        appearance.duration = 1000
        appearance.fillAfter = true;
        appearance.repeatMode = Animation.RESTART;
        appearance.repeatCount = 10;
        appearance.setAnimationListener(this);
        // animación escalado
        // rs indica que las coordenadas son relativas
        val rs : Int = ScaleAnimation.RELATIVE_TO_SELF;
        scale = ScaleAnimation(1F,2F,1F,5F,rs,0.5F,rs, 0.5F)
        scale?.duration = 3000;
        scale?.fillAfter = true;
        textViewObject?.startAnimation(appearance);
    }

    override fun onAnimationStart(animation: Animation?) {

    }

    override fun onAnimationEnd(animation: Animation?) {
        textViewObject?.text = "THE END";
        textViewObject?.startAnimation(scale);
    }

    override fun onAnimationRepeat(animation: Animation?) {
        i++
        textViewObject?.text = "CONTADOR = " + i;
    }

}