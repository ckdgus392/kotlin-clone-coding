package com.example.aop_part2_chapter01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val heightEditText:EditText = findViewById(R.id.heightEditText) //? = null값 가능
        val weightEditText = findViewById<EditText>(R.id.weightEditText) //:EditText는 자료형이 선언되었지만 <>는 꺾쇠안에 표시해줘야함
        val resultButton = findViewById<Button>(R.id.resultButton)

        resultButton.setOnClickListener {
            //Log.d("MainActivity", "ResultButton이 클릭되었습니다.")

            if( heightEditText.text.isEmpty() || weightEditText.text.isEmpty()){
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //이 아래로는 절대 빈 값이 올 수 없음.

            val height: Int = heightEditText.text.toString().toInt()
            val weight: Int = weightEditText.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java) //main에서 result xml을 실행시키고싶을 때

            intent.putExtra("height", height)
            intent.putExtra("weight", weight)

            startActivity(intent)
            //Log.d("MainActivity", "height : $height weight : $weight") //$ : 변수값을 바로 가져옴
        }
    }
}