package com.eblimonv.animations.ui.animlayaout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eblimonv.animations.R
/**
 * A simple [Fragment] subclass.
 * Use the [FullAnimationLayout.newInstance] factory method to
 * create an instance of this fragment.
 */
class FullAnimationLayout : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root : View = inflater.inflate(R.layout.fragment_full_animation_layout, container, false)

        return root
    }

}