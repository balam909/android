package com.eblimonv.fotogramanimation

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root : View = inflater.inflate(R.layout.fragment_first, container, false)

        val startButton : Button = root.findViewById(R.id.b_f_start_anim)
        val stopButton : Button = root.findViewById(R.id.b_f_stop_anim)

        val imageView : ImageView = root.findViewById(R.id.photogramSerie)
        imageView.visibility = ImageView.VISIBLE
        imageView.setBackgroundResource(R.drawable.animated_fotograms)
        val animationDrawable : AnimationDrawable = imageView.background as AnimationDrawable

        startButton.setOnClickListener { animationDrawable.start() }
        stopButton.setOnClickListener { animationDrawable.stop() }

        return root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.b_f_next).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        view.findViewById<Button>(R.id.b_f_previous).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_ThirdFragment)
        }
    }
}