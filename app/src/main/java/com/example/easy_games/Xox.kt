package com.example.easy_games

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class Xox : AppCompatActivity() {

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button

    var start = 0
    var gameArray = IntArray(9) // 001-100-10
    var finished:Boolean = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xox)



        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)


        btn1.setOnClickListener(){

            if (gameArray[0] == 0){
                gameArray[0] = ((start % 2) * 2 - 1) * (-1)
                addResult(btn1)
            }

        }

        btn2.setOnClickListener(){
            if (gameArray[1] == 0){
                gameArray[1] = ((start % 2) * 2 - 1) * (-1)
                addResult(btn2)
            }
        }

        btn3.setOnClickListener(){
            if (gameArray[2] == 0){
            gameArray[2] = ((start % 2) * 2 - 1) * (-1)
            addResult(btn3)
            }
        }

        btn4.setOnClickListener(){
            if (gameArray[3] == 0){
            gameArray[3] = ((start % 2) * 2 - 1) * (-1)
            addResult(btn4) }
        }

        btn5.setOnClickListener(){
            if (gameArray[4] == 0){
            gameArray[4] = ((start % 2) * 2 - 1) * (-1)
            addResult(btn5) }
        }

        btn6.setOnClickListener(){
            if (gameArray[5] == 0){
            gameArray[5] = ((start % 2) * 2 - 1) * (-1)
            addResult(btn6) }
        }

        btn7.setOnClickListener(){
            if (gameArray[6] == 0){
            gameArray[6] = ((start % 2) * 2 - 1) * (-1)
            addResult(btn7) }
        }

        btn8.setOnClickListener(){
            if (gameArray[7] == 0){

            gameArray[7] = ((start % 2) * 2 - 1) * (-1) 
            addResult(btn8) }
        }

        btn9.setOnClickListener(){
            if (gameArray[8] == 0){

                gameArray[8] = ((start % 2) * 2 - 1) * (-1)
            addResult(btn9)
            }
        }


    }

    fun addResult (btn:Button){

        if(!finished){

            if(start % 2 == 0){
                btn.setText("X")
            } else {
                btn.setText("O")
            }
            checkGame()
            start++
        } else {
            Snackbar.make(findViewById(android.R.id.content), "Oyun bitti yeni oyuna basla", Snackbar.LENGTH_LONG).show()
        }

    }


    // 0 1 2
    // 0 3 6
    // 0 4 8
    // 1 4 7
    // 2 5 8
    // 3 4 5
    // 6 7 8
    // 2 4 6
    fun checkGame(){

        if (gameArray[0] == 1 && gameArray[1] == 1 && gameArray[2] == 1 ||
            gameArray[0] == 1 && gameArray[3] == 1 && gameArray[6] == 1 ||
            gameArray[0] == 1 && gameArray[4] == 1 && gameArray[8] == 1 ||
            gameArray[1] == 1 && gameArray[4] == 1 && gameArray[7] == 1 ||
            gameArray[2] == 1 && gameArray[5] == 1 && gameArray[8] == 1 ||
            gameArray[3] == 1 && gameArray[4] == 1 && gameArray[5] == 1 ||
            gameArray[6] == 1 && gameArray[7] == 1 && gameArray[8] == 1 ||
            gameArray[2] == 1 && gameArray[4] == 1 && gameArray[6] == 1
                ){
            Snackbar.make(findViewById(android.R.id.content), "X kazandı", Snackbar.LENGTH_LONG).show()
            finished = true
        }
         else if (gameArray[0] == -1 && gameArray[1] == -1 && gameArray[2] == -1 ||
            gameArray[0] == -1 && gameArray[3] == -1 && gameArray[6] == -1 ||
            gameArray[0] == -1 && gameArray[4] == -1 && gameArray[8] == -1 ||
            gameArray[1] == -1 && gameArray[4] == -1 && gameArray[7] == -1 ||
            gameArray[2] == -1 && gameArray[5] == -1 && gameArray[8] == -1 ||
            gameArray[3] == -1 && gameArray[4] == -1 && gameArray[5] == -1 ||
            gameArray[6] == -1 && gameArray[7] == -1 && gameArray[8] == -1 ||
            gameArray[2] == -1 && gameArray[4] == -1 && gameArray[6] == -1)
         {
            Snackbar.make(findViewById(android.R.id.content), "O kazandi", Snackbar.LENGTH_LONG).show()
             finished = true
        }

    }
}