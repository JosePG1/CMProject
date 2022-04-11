package com.example.guideestg

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Spinner

const val PARAM1_LOCAL = "local"


class MainActivity : AppCompatActivity() {


    var selectedValue : String = "Nothing Here"

    //String Values for the array
    var sala: String = "sala"
    var auditorio: String = "auditorio"
    var lab : String = "lab"
    var bar: String = "bar"
    var cant : String = "cant"
    var repro : String = "repro"



        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Hide the action bar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()


            //String Values for the array
            sala = getString(R.string.sala)
            auditorio = getString(R.string.auditorio)
            lab = getString(R.string.laboratorio)
            bar = getString(R.string.bar)
            cant  = getString(R.string.cantina)
            repro = getString(R.string.reprografia)



        // Declaring and initializing
        // the Spinner from the layout file
        val mSpinner = findViewById<Spinner>(R.id.dropdown_menu)

        // Create a list to display in the Spinner
        val mList = arrayOf<String?>(sala,auditorio,lab,bar,cant,repro)

        // Create an adapter as shown below
        val mArrayAdapter = ArrayAdapter<Any?>(this, R.layout.spinner_item, mList)
        mArrayAdapter.setDropDownViewResource(R.layout.spinner_item)

        // Set the adapter to the Spinner
        mSpinner.adapter = mArrayAdapter

        selectedValue = mSpinner.selectedItem.toString()




    }

    fun nextAction(view: View) {
        if(selectedValue == sala){
            val intent = Intent(this, MainActivity2::class.java).apply {
                putExtra(PARAM1_LOCAL, selectedValue.toString())
            }
            startActivity(intent)
        }
    }
}