package com.example.scarpelli.dinerdecider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    //TODO
    // - store food in array
    // - add food to array
    // - pick random food from array

    private val foodList = arrayListOf("Thai", "Chinese", "Pizza", "Nachos", "Nothing")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decideBtn.setOnClickListener {
            val randomFood = Random().nextInt(foodList.count())

            selectedFoodTxt.text = foodList[randomFood]
        }

        addFoodBtn.setOnClickListener {

            if (hasFoodAlready(addFoodTxt.text.toString()) == false) {
                foodList.add(addFoodTxt.text.toString())
                addFoodTxt.text.clear()
                println(foodList)
            }
            else {
                Toast.makeText(applicationContext, "Food item already exists", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun hasFoodAlready(newFood: String): Boolean? {
        if (foodList.contains((newFood))){
            return true
        }

        if (newFood.isEmpty()) {
            return true
        }

        return false
    }

}
