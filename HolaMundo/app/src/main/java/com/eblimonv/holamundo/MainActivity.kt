package com.eblimonv.holamundo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sayHelloSayGoodBye(view: View) {
        if(button.text.toString() == getString(R.string.say_hello)) {
            button.text = getString(R.string.say_good_bye)
            mainText.text = getString(R.string.hola_mundo)
        }else{
            button.text = getString(R.string.say_hello)
            mainText.text = getString(R.string.adios_mundo)
        }
    }


}