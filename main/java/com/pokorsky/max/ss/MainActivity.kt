package com.pokorsky.max.ss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import android.widget.SeekBar.OnSeekBarChangeListener

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import android.content.Intent
import android.widget.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ///val spinner: Spinner = findViewById(R.id.spinner)


        // Example of a call to a native method

        var f =add(6,8)
        //button.setOnClickListener()
       // {
         //   sample_text.append(f.toString())

       // }

        var hh: Int = 1

        seekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
               var hh1 = seekBar.progress
                textView.text=(hh1.toString())
                // Write code to perform some action when progress is changed.
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
               var hh2 = seekBar.progress
                textView.text=(hh2.toString())
                // Write code to perform some action when touch is started.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
                ///Toast.makeText(this@MainActivity, "Progress is " + seekBar.progress + "%", Toast.LENGTH_SHORT).show()
               var hh3 = seekBar.progress
                textView.text=(hh3.toString())
            }
        }        )

        var list_of_items = arrayOf("Item 1", "Item 2", "Item 3")
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_of_items)


        spinner.adapter=aa
        button3.setOnClickListener{

            sample_text.text = stringFromJNI()
        }








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

        sample_text.append(add(6,8).toString())
    }

    fun someMethod(Button3: View) {
        // do something useful here
    }


    fun topClick2(view: View) {
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        startActivity(intent)
    }



    }














