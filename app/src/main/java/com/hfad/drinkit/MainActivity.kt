package com.hfad.drinkit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val JUICE_STATE="JUICE_STATE"
    private val JUICE_SIZE="JUICE_SIZE"
    private val SQUEEZE_COUNT="SQUEEZE_COUNT"
    private val SELECT="select"
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
            squeezeCount=savedInstanceState.getInt(SQUEEZE_COUNT, -1)  }
        juiceImage= findViewById(R.id.image_juice_state)
        setViewElement()
        juiceImage!!.setOnClickListener{  clickJuiceImage()   }
        juiceImage!!.setOnLongClickListener {  showSnackbar()  } }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(JUICE_STATE, juiceState)
        outState.putInt(JUICE_SIZE, juiceSize)
        outState.putInt(SQUEEZE_COUNT, squeezeCount)
        super.onSaveInstanceState(outState)   }
    private fun showSnackbar(): Boolean{
        if (juiceState!=SQUEEZE){ return false }
        val squeezeText=getString(R.string.squeeze_count, squeezeCount)
        Snackbar.make(
            findViewById(R.id.constraint_Layout),
            squeezeText, Snackbar.LENGTH_SHORT ).show()
        return true}

    private fun clickJuiceImage() {
    if(juiceState==SELECT){
           juiceState=SQUEEZE
        juiceSize=juiceTree.pick()
        squeezeCount=0
       }
        else if (juiceState==SQUEEZE)
    {
            squeezeCount++
        juiceSize--
        if (juiceSize==0){
            juiceState=DRINK
            juiceSize=-1
        }
    }
        else if (juiceState==DRINK){
            juiceState=RESTART
    }
        else if(juiceState==RESTART){
        juiceState=SELECT
    }
        setViewElement()
 }

    private fun setViewElement() {
// TODO: set up a conditional that tracks the lemonadeState
        // TODO: for each state, the textAction TextView should be set to the corresponding string from
        //  the string resources file. The strings are named to match the state
        // TODO: Additionally, for each state, the lemonImage should be set to the corresponding
        //  drawable from the drawable resources. The drawables have the same names as the strings
        //  but remember that they are drawables, not strings.
        val textAction: TextView=findViewById(R.id.Text_action)
        if (juiceState==SELECT){
            textAction.setText(R.string.juice_select)
            juiceImage?.setImageResource(R.drawable.lemon_tree)
        }
        if (juiceState==SQUEEZE){
            textAction.setText(R.string.juice_squeeze)
        juiceImage?.setImageResource(R.drawable.lemon_squeeze)
        }
        if (juiceState==DRINK){
            textAction.setText(R.string.juice_drink)
            juiceImage?.setImageResource(R.drawable.lemon_drink)
        }
        if (juiceState==RESTART){
            textAction.setText(R.string.juice_empty_glass)
            juiceImage?.setImageResource(R.drawable.lemon_restart)
        }
    }
}
class JuiceTree {
fun pick(): Int{

    return (2..6).random()
}
}
