package com.eblimonv.fotogramanimation

import android.content.res.Resources
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root : View = inflater.inflate(R.layout.fragment_second, container, false)
        val animationDrawable : AnimationDrawable = AnimationDrawable()
        val resources : Resources = resources
        val drawable1 : Drawable = resources.getDrawable(R.drawable.img_001)
        val drawable2 : Drawable = resources.getDrawable(R.drawable.img_002)
        val drawable3 : Drawable = resources.getDrawable(R.drawable.img_003)
        val drawable4 : Drawable = resources.getDrawable(R.drawable.img_004)
        val drawable5 : Drawable = resources.getDrawable(R.drawable.img_005)

        animationDrawable.addFrame(drawable1, 3000)
        animationDrawable.addFrame(drawable2, 3000)
        animationDrawable.addFrame(drawable3, 3000)
        animationDrawable.addFrame(drawable4, 3000)
        animationDrawable.addFrame(drawable5, 3000)

        animationDrawable.isOneShot = false
        val imageView : ImageView = root.findViewById(R.id.photogramSerie)
        imageView.visibility = ImageView.VISIBLE
        imageView.setBackgroundDrawable(animationDrawable)

        val startButton : Button = root.findViewById(R.id.b_s_start_anim)
        val stopButton : Button = root.findViewById(R.id.b_s_stop_anim)
        startButton.setOnClickListener { animationDrawable.start() }
        stopButton.setOnClickListener { animationDrawable.stop() }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.b_s_next).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_ThirdFragment)
        }
        view.findViewById<Button>(R.id.b_s_previous).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}