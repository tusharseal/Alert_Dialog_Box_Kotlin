package com.example.alertdialogboxkotlin

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)

        btn1.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this@MainActivity).create()
            alertDialog.setTitle("Terms & Conditions")
            alertDialog.setIcon(R.drawable.info)
            alertDialog.setMessage("Have you Read All the Terms and Conditions")
            alertDialog.setButton(
                "Yes, I've Read"
            ) { dialogInterface, i ->
                Toast.makeText(
                    this@MainActivity,
                    "Yes,You can proceed Now..",
                    Toast.LENGTH_SHORT
                ).show()
            }
            alertDialog.show()
        }

        btn2.setOnClickListener {
            val delDialog = AlertDialog.Builder(this@MainActivity)
            delDialog.setTitle("Delete?")
            delDialog.setIcon(R.drawable.delete)
            delDialog.setMessage("Do You Really want to delete?")
            delDialog.setPositiveButton(
                "Yes"
            ) { dialogInterface, i ->
                Toast.makeText(
                    this@MainActivity,
                    "Deleted Successfully",
                    Toast.LENGTH_SHORT
                ).show()
            }
            delDialog.setNegativeButton(
                "No"
            ) { dialogInterface, i ->
                Toast.makeText(
                    this@MainActivity,
                    "Not Deleted",
                    Toast.LENGTH_SHORT
                ).show()
            }
            delDialog.show()
        }

        btn3.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "Third Dialog On Back Pressed",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onBackPressed() {
        val exitDialog = AlertDialog.Builder(this@MainActivity)
        exitDialog.setTitle("Exit?")
        exitDialog.setIcon(R.drawable.exit)
        exitDialog.setMessage("Do You Really want to Exit?")
        exitDialog.setPositiveButton(
            "No"
        ) { dialogInterface, i ->
            Toast.makeText(this@MainActivity, "Welcome Back", Toast.LENGTH_SHORT).show()
        }
        exitDialog.setNegativeButton(
            "Yes"
        ) { dialogInterface, i ->
            Toast.makeText(this@MainActivity, "Tata! Bye-Bye!", Toast.LENGTH_SHORT).show()
            super@MainActivity.onBackPressed()
        }
        exitDialog.setNeutralButton(
            "Cancel"
        ) { dialogInterface, i ->
            Toast.makeText(
                this@MainActivity,
                "Operation Cancelled!!",
                Toast.LENGTH_SHORT
            ).show()
        }
        exitDialog.show()
    }
}