package com.example.registrosaladecomputo

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private var spinnerA:Spinner?=null
    val bitacoraFragment: Fragment_BitacoraRegistro = Fragment_BitacoraRegistro()
    val estudianteFragment: Fragment_Estudiantes = Fragment_Estudiantes()
    val asignaturaFragment: Fragment_Materias = Fragment_Materias()
    val salaComputoFragment: Fragment_SalasDeComputo = Fragment_SalasDeComputo()

    val REQUEST_CODE: Int = 200

    /**
     * Función onCreate
     */
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.contenedor, bitacoraFragment).commit()

        //spinnerA=findViewById(R.id.spinnerA)

        val listaCarreras= arrayOf("Ing. Informática", "Ing. Tic´s", "Ing. Agronomía","Ing. Forestal", "Lic. Biología" )

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun verificarPermisos() {
        val permisoEscribir: Int = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val permisoLeer: Int = ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)

        if(permisoEscribir == PackageManager.PERMISSION_GRANTED && permisoLeer == PackageManager.PERMISSION_GRANTED){
            println("Permisos de lectura y escritura concedidos")
        } else {
            requestPermissions(listOf<String>(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE).toTypedArray(), REQUEST_CODE)
        }
    }

    fun bitacoraBoton(view: View) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedor, bitacoraFragment).commit()
    }
    fun estudianteBoton(view: View) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedor, estudianteFragment).commit()
    }
    fun materiasBoton(view: View) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedor, asignaturaFragment).commit()
    }
    fun salasBoton(view: View) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedor, salaComputoFragment).commit()
    }


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