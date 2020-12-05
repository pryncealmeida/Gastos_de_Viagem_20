package com.example.gastosdeviagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

//A
class MainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)




    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.buttonCalculate){
            calculate()
        }

    }



        private fun calculate() {

        if(ValidationOK()){
            try {
                val distance = editText_distancia.text.toString().toFloat()
                val autonomia = editText_autonomia.text.toString().toFloat()
                val preco = editText_preco.text.toString().toFloat()

                val resultado = (distance * preco) / autonomia
                totalValue.text = "R$ ${"%.2f".format(resultado)}"
            }
            catch (nfe : NumberFormatException){
                Toast.makeText(this, getString(R.string.Valores_validos), Toast.LENGTH_LONG).show()

            }

        }
        else{
        Toast.makeText(this, getString(R.string.Preencha_campos), Toast.LENGTH_LONG).show()
        }


    }


    private fun ValidationOK(): Boolean{
    return( editText_distancia.text.toString() != ""
            && editText_autonomia.text.toString() != ""
            && editText_autonomia.text.toString()!= "0"
            && editText_preco.text.toString() != "")



    }


}
