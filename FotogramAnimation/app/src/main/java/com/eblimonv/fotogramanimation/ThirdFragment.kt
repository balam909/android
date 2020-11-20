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
import android.widget.TextView
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root : View = inflater.inflate(R.layout.fragment_third, container, false)
        val animationDrawable = AnimationDrawable()
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
        val imageView : ImageView = root.findViewById(R.id.photogramSerieCompensated)
        imageView.visibility = ImageView.VISIBLE
        imageView.setImageDrawable(animationDrawable)

        val textView : TextView = root.findViewById(R.id.textview_third)


        val startButton : Button = root.findViewById(R.id.b_t_start_anim)
        val stopButton : Button = root.findViewById(R.id.b_t_stop_anim)
        val loadMetadata : Button = root.findViewById(R.id.b_t_load_info)
        startButton.setOnClickListener { animationDrawable.start() }
        stopButton.setOnClickListener { animationDrawable.stop() }
        loadMetadata.setOnClickListener { loadMetadata( animationDrawable, imageView, textView ) }

        return root
    }

    private fun loadMetadata(animationDrawable : AnimationDrawable, imageView : ImageView, textView : TextView){
        val drawable : Drawable = animationDrawable.current
        var width : Int = drawable.intrinsicWidth
        var height : Int = drawable.intrinsicHeight
        var ratio : Double = height/(width+0.01)
        textView.text = "Image width="
        textView.append(width.toString())
        textView.append(" height=")
        textView.append(height.toString())
        textView.append(" ratio=")
        textView.append(ratio.toString())
        width = imageView.measuredWidth
        height = imageView.measuredHeight
        textView.append("\nonClick")
        textView.append(" width=")
        textView.append(width.toString())
        textView.append(" height=")
        textView.append(height.toString())
        val newWidth : Int = (height/ratio).toInt()
        val padding : Int = (width-newWidth)/2
        textView.append("\nnewWidth=")
        textView.append(newWidth.toString())
        textView.append(" padding=")
        textView.append(padding.toString())
        imageView.setPadding(padding, 0, padding, 0)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.b_t_next).setOnClickListener {
            findNavController().navigate(R.id.action_ThirdFragment_to_FirstFragment)
        }
        view.findViewById<Button>(R.id.b_t_previous).setOnClickListener {
            findNavController().navigate(R.id.action_ThirdFragment_to_SecondFragment)
        }

    }
}