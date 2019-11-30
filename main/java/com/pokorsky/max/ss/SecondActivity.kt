package com.pokorsky.max.ss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import android.widget.Toast
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener

import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.view.*
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.sample_text
import kotlinx.android.synthetic.main.activity_main2.seekBar
import kotlinx.android.synthetic.main.activity_main2.textView
import android.widget.ArrayAdapter




class SecondActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        // Example of a call to a native method

       ///// var f =add(6,8)
        //button.setOnClickListener()
        // {
        //   sample_text.append(f.toString())

        // }

        var hh: Int = 1
        val items = arrayOf("this", "is", "a", "really", "silly", "list")

        /////ArrayAdapter(this, android.R.layout.simple_list_item_1, items)

        seekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
                ///Toast.makeText(this@MainActivity, "Progress is " + seekBar.progress + "%", Toast.LENGTH_SHORT).show()
                hh = seekBar.progress
                textView.text=(hh.toString())
            }
        }        )






     ////   sample_text.text = stringFromJNI()




    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String
    external fun add(a: Int, b: Int): Int

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }

    fun topClick(v: View) {
        Toast.makeText(this, "Top button clicked", Toast.LENGTH_SHORT).show()

        Log.i("info", "The user clicked the top button")

        ////sample_text.append(add(6,8).toString()) крашится тут
    }

    fun topClick2(view: View) {
        val intent = Intent(this@SecondActivity, MainActivity::class.java)
        startActivity(intent)
    }



}