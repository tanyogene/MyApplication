package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var diceImg:ImageView
    lateinit var numberText:TextView
    lateinit var editPlayerName:EditText
    lateinit var playerNameTV:TextView
    lateinit var binding: ActivityMainBinding
    private val gameInfo2: MyName= MyName("Tan Yogene")
    private var totalScore :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        //practical 7
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

//practical 1
//        val button: Button = findViewById(R.id.button)
//        button
//            .setOnClickListener { sayHi() }


//practical 2
//        diceImg = findViewById(R.id.diceImg)
//        numberText = findViewById(R.id.numbertext)
//        val rollButton: Button = findViewById(R.id.button)
        //val rollButton = findViewById<Button>(R.id.button)
//        rollButton.setOnClickListener{ rollDice() }

//practical 3
//        editPlayerName = findViewById(R.id.editPlayerName)
//        playerNameTV = findViewById(R.id.playername)
        val updateButton = findViewById<Button>(R.id.updatePlayerName)
//        updateButton.setOnClickListener{updatePlayerName(it)}

//practical 7
        binding.gameInfo =gameInfo2
        binding.button.setOnClickListener{ rollDice() }
        binding.updatePlayerName.setOnClickListener{updatePlayerName(it)}
    }

    //practical 1
    private fun sayHi() {
        Toast.makeText(
             this, "Hello Class!",
            Toast.LENGTH_SHORT).show() //small pop out
    }

    //practical 2
//    private fun rollDice(){
//        val randomNumb = (1..6).random()
////        val numberText:TextView = findViewById(R.id.numbertext)
////        val diceImg: ImageView =findViewById(R.id.diceImg)
//        numberText.text = randomNumb.toString()
//        val imgSrc = when (randomNumb){
//            1-> R.drawable.dice_1
//            2-> R.drawable.dice_2
//            3-> R.drawable.dice_3
//            4-> R.drawable.dice_4
//            5-> R.drawable.dice_5
//            else-> R.drawable.dice_6        }
//        diceImg.setImageResource(imgSrc)
//
//        Toast.makeText(this,randomNumb.toString(),Toast.LENGTH_SHORT).show() //small pop out
//    }

    //practical 3
//    private fun updatePlayerName(view: View){
//        playerNameTV.text = editPlayerName.text
//
//        editPlayerName.setText(" ")
//        editPlayerName.clearFocus()
//
//        //Hide Keyboard after update player name
//        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//            imm.hideSoftInputFromWindow(view.windowToken, 0)
//
//    }

    //practical 7
    private fun rollDice(){
        val randomNumb = (1..6).random()
//        val numberText:TextView = findViewById(R.id.numbertext)
//        val diceImg: ImageView =findViewById(R.id.diceImg)
       binding.numbertext.text = randomNumb.toString()
        val imgSrc = when (randomNumb){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else-> R.drawable.dice_6        }
        binding.diceImg.setImageResource(imgSrc)
        totalScore+=randomNumb.toInt()
        gameInfo2.totalScore="Total: " + totalScore.toString()
        binding.gameInfo =gameInfo2



        Toast.makeText(this,randomNumb.toString(),Toast.LENGTH_SHORT).show() //small pop out
    }
    private fun updatePlayerName(view: View){
//        binding.playername.text = binding.editPlayerName.text

        //way 1
//        gameInfo2.playerName=binding.editPlayerName.text.toString()
//        binding.gameInfo =gameInfo2
//       Ways 2(teachers)(this no need mention binding inside):
        binding.apply{
            gameInfo?.playerName = editPlayerName.text.toString()
            invalidateAll()
        }

        binding.editPlayerName.setText(" ")
        binding.editPlayerName.clearFocus()

        //Hide Keyboard after update player name
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

}