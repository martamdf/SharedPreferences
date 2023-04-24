package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val numRandom = Random.nextInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFromPreferences()
    }

    private fun loadFromPreferences(){
        // Equivale a las lineas de abajo
        //val shared = getPreferences(Context.MODE_PRIVATE)
        //val numOld = shared.getInt("MiInteger", 0)
        //Log.w("Tag", "$numOld")

        //Funciones impotantes: let, apply, with, run

        getPreferences(Context.MODE_PRIVATE).apply {
            getInt("MiInteger", 0)
            Log.w("Tag", "${getInt("MiInteger", 0)}")
        }

    }

    override fun onStop() {
        saveFromPreferences()
        super.onStop()
    }
    private fun saveFromPreferences(){

        // Equivale a las lineas de abajo
        // val shared = getPreferences(Context.MODE_PRIVATE)
        // val sharedPreferencesEditable = shared.edit()
        // sharedPreferencesEditable.putInt("MiInteger", numRandom)
        // sharedPreferencesEditable.apply()

        getPreferences(Context.MODE_PRIVATE).edit().apply {
            putInt("MiInteger", numRandom)
            apply()
        }





    }
}