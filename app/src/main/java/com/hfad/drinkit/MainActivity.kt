package com.hfad.drinkit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private val Juice_State="JUICE_STATE"
    private val Juice_Size="JUICE_SIZE"
    private val Squeeze_count="SQUEEZE_COUNT"
    private val SELECE="select"
    private val SQUEEZE="squeeze"
    private val DRINK="drink"
    private val RESTART="restart"
    private var lemonState="select"
    private var lemonSize=-1
    private var squeezeCount=-1
    private var lemonTree=LemonTree()
    private var lemonImage: ImageView?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
class LemonTree {
fun pick(): Int{
    return (2..6).random()
}
}
