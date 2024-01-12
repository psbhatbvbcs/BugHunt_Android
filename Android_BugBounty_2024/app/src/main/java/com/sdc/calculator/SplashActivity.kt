package com.sdc.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import es.dmoral.toasty.Toasty


//Activity->The screen which gets displayed.
//This actvity displays the DSC club image for UI/UX
class SplashActivity : AppCompatActivity() {

    //This is a pre-defined function called when the Activity starts/screen starts
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_actvity)

        //Toasty or Toast are small pop ups to display some message
        //This toast displays a Welcome message when you start the app
   Toasty.normal(this,"Welcome!",Toast.LENGTH_SHORT).show()

        //Looper->Acts like a loop for some duration of time
        Looper.myLooper()?.let {
                    Handler(it).postDelayed({
                        //Intent is helped to switch from one screen to another
                         val i = Intent(this,MainActivity::class.java)
                        //switching Screens
                          startActivity(i)
                        // Relieve this activity from running
                },
                      //delaying or showing the splash scree for 3 seconds
                        3000)
        }

    }
}
