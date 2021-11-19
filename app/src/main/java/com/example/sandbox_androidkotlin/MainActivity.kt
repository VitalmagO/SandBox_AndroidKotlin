package com.example.sandbox_androidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myObserver: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myObserver = MyObserver()
        lifecycle.addObserver(myObserver)
    }

    private fun toastMeState(message: String) {
        Toast.makeText(this, "${lifecycle.currentState}, $message", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        toastMeState("ON_START")
    }

    override fun onResume() {
        super.onResume()
        toastMeState("ON_RESUME")
    }

    override fun onPostResume() {
        super.onPostResume()
        toastMeState("onPostResume")
    }

    override fun onPause() {
        super.onPause()
        toastMeState("ON_PAUSE")
    }

    override fun onStop() {
        super.onStop()
        toastMeState("ON_STOP")
    }

    override fun onRestart() {
        super.onRestart()
        toastMeState("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        toastMeState("ON_DESTROY")
    }



    fun toastMe(view: View) {
        val myToast = Toast.makeText(this, "Hello, I'am Toast!", Toast.LENGTH_SHORT)

        myToast.show()
    }

    fun countMe(view: View) {
        val countString = textView.text.toString()
        var count: Int = Integer.parseInt(countString)

        count++
        textView.text = count.toString()
    }

    fun randomMe(view: View) {
        val randomIntent = Intent(this, SecondActivity::class.java)
        val countString = textView.text.toString()
        val count = Integer.parseInt(countString)

        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)
        startActivity(randomIntent)
    }
}