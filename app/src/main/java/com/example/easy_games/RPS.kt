package com.example.easy_games

import android.graphics.drawable.Drawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text
import kotlin.random.Random

class RPS : AppCompatActivity() {

    lateinit var btnScissor: ImageButton
    lateinit var btnPaper: ImageButton
    lateinit var btnRock: ImageButton
    lateinit var imgResult:ImageView
    lateinit var imgMine:ImageView
    lateinit var txtScoreTable: TextView
    lateinit var txtAi: TextView

    var yourScore = 0
    var computerScore = 0

    var compWin = "Computer Win"
    var youWin = "You Win"
    var draw = "Draw"

    lateinit var scissors: Drawable
    lateinit var paper: Drawable
    lateinit var rock: Drawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rps)

        imgResult = findViewById(R.id.imgResult)
        btnScissor = findViewById(R.id.btnScissor)
        btnPaper = findViewById(R.id.btnPaper)
        btnRock = findViewById(R.id.btnRock)
        imgMine = findViewById(R.id.imgMine)
        txtScoreTable = findViewById(R.id.txtScoreTable)
        txtAi = findViewById(R.id.txtAi)

        scissors = resources.getDrawable(R.drawable.scissors, null)
        paper = resources.getDrawable(R.drawable.paper, null)
        rock = resources.getDrawable(R.drawable.rock, null)

        btnScissor.setOnClickListener(){
            var random = (Math.random() * 3 + 1).toInt()
            var result = getPrecision(random)
            imgResult.setImageDrawable(result)
            whoWins(random, 1)
            imgMine.setImageDrawable(scissors)
        }

        btnPaper.setOnClickListener(){
            var random = (Math.random() * 3 + 1).toInt()
            var result = getPrecision(random)
            imgResult.setImageDrawable(result)
            whoWins(random, 2)
            imgMine.setImageDrawable(paper)
        }

        btnRock.setOnClickListener(){
            var random = (Math.random() * 3 + 1).toInt()
            var result = getPrecision(random)
            imgResult.setImageDrawable(result)
            whoWins(random, 3)
            imgMine.setImageDrawable(rock)
        }

    }

    fun getPrecision(selectNum: Int): Drawable{
        when(selectNum){
            1 -> return scissors
            2 -> return paper
            3 -> return rock
            else -> return scissors
        }
    }

    fun whoWins(computer:Int, you:Int){
        if(computer == you){
            equelWin()
        } else if(computer == 1 && you == 2){
            compWin()
        } else if(computer == 1 && you == 3){
            youWin()
        } else if(computer == 2 && you == 1){
            youWin()
        } else if(computer == 2 && you == 3){
            compWin()
        } else if(computer == 3 && you == 1){
            compWin()
        } else if(computer == 3 && you == 2){
            youWin()
        }
    }

    fun youWin(){
        yourScore += 1
        updateTable()
        txtAi.setText(youWin)
    }

    fun compWin(){
        computerScore += 1
        updateTable()
        txtAi.setText(compWin)
    }

    fun equelWin(){
        txtAi.setText(draw)
    }

    fun updateTable(){
        txtScoreTable.setText("Computer: $computerScore    -    You: $yourScore")
    }

}