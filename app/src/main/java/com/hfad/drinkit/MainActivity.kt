package com.hfad.drinkit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private val JUICE_STATE="JUICE_STATE"
    private val JUICE_SIZE="JUICE_SIZE"
    private val SQUEEZE_COUNT="SQUEEZE_COUNT"
    private val SELECE="select"
    private val SQUEEZE="squeeze"
    private val DRINK="drink"
    private val RESTART="restart"
    private var juiceState="select"
    private var juiceSize=-1
    private var squeezeCount=-1
    private var juiceTree=JuiceTree()
    private var juiceImage: ImageView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState!=null){
            juiceState=savedInstanceState.getString("JUICE_STATE", "select")
            juiceSize=savedInstanceState.getInt("JUICE_SIZE", -1)
            squeezeCount=savedInstanceState.getInt(SQUEEZE_COUNT, -1)
        }
        juiceImage= findViewById(R.id.image_juice_state)
        setViewElement()
        juiceImage!!.setOnClickListener{
            clickJuiceImage()
        }
        juiceImage!!.setOnLongClickListener {
            showSnackbar()
        }
    }

    private fun showSnackbar(): Boolean{
        TODO("Not yet implemented")
    }

    private fun clickJuiceImage() {
        TODO("Not yet implemented")
    }

    private fun setViewElement() {
        TODO("Not yet implemented")
    }
}
class JuiceTree {
fun pick(): Int{
    return (2..6).random()
}
}
