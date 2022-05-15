package com.example.registrosaladecomputo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    private var spinnerA:Spinner?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerA=findViewById(R.id.spinnerA)

        val listaCarreras= arrayOf("Ing. Informática", "Ing. Tic´s", "Ing. Agronomía","Ing. Forestal", "Lic. Biología" )

    hh}







    /**


    fun registrar(view: View) {
        val nc : EditText = findViewById(R.id.txtNcontrol)
        val nombre : EditText = findViewById(R.id.txtNombre)
        val carrera : Spinner = findViewById(R.id.cbxCarreras)
        val semestre : Spinner = findViewById(R.id.cbxSemestre)
        val grupoA : RadioButton = findViewById(R.id.rbtGrupoA)
        val grupoB : RadioButton = findViewById(R.id.rbtGrupoB)
        var cadena = "Numero de Control: " + nc.text.toString() +"\n"+
                     "Nombre: " + nombre.text.toString() +"\n"+
                     "Carrera: " + carrera.selectedItem+"\n"+
                     "Semestre:  " + semestre.selectedItem.toString() +"\n"+
        var cadena = nc.text.toString()+","+
                     nombre.text.toString()+","+
                     carrera.selectedItem+","+
                     semestre.selectedItem+","
        if (grupoA.isChecked)
            cadena+" A"
        else
            cadena+" B"

        cadena+"\n"

        println("$cadena")//


    }
     */
}