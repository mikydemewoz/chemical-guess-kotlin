package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var chemical_list: MutableList<String> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guess_button: Button = findViewById(R.id.guess)
        val guess_edit_view: EditText = findViewById(R.id.guess_edit_view)
        val add_button: Button = findViewById(R.id.add)
        val add_edit_view: EditText = findViewById(R.id.add_chemical_edit)
        val result: TextView = findViewById(R.id.result)

        val add_buttonListener = View.OnClickListener {
            val chemical: String =add_edit_view.text.toString().trim()
            if (chemical.equals("")){
                result.text = "Please enter a value"
                result.visibility = TextView.VISIBLE;
            }else{
                add(chemical)
            }

        }

        add_button.setOnClickListener(add_buttonListener)

        val guess_buttonListener = View.OnClickListener {
            val chemical: String =guess_edit_view.text.toString().trim()
            if (chemical.equals("")){
                result.text = "Please enter a value"
                result.visibility = TextView.VISIBLE;
            }else{
                val present = check(chemical)
                if (present){
                    result.text = "You are correct the value is "+chemical
                    result.visibility = TextView.VISIBLE;
                }else{
                    result.text = "You guessed it wrong"
                    result.visibility = TextView.VISIBLE;
                }
            }

        }

        guess_button.setOnClickListener(guess_buttonListener)
    }

    private fun add(chemical: String) {
        chemical_list.add(chemical)
    }

    private fun check(chemical: String): Boolean {
        for (ele in chemical_list){
            if(chemical.equals(ele))return true
        }

        return false
    }

}