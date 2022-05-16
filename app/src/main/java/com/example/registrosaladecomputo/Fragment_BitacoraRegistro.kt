package com.example.registrosaladecomputo

import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_BitacoraRegistro.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_BitacoraRegistro : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment__bitacora_registro, container, false)
        accionBoton(view)
        return view
    }

    fun accionBoton(view: View){
        val boton: Button = view.findViewById(R.id.btnAgregarB)
        boton.setOnClickListener {
            val fecha: EditText = view.findViewById(R.id.txtFechaR)
            val numcontrol: EditText = view.findViewById(R.id.txtNumC)
            val clave: EditText = view.findViewById(R.id.txtClaveM)

            var cadena: String = "${fecha.text.toString()},${numcontrol.text.toString()},${clave.text.toString()}"
            escribirArchivo("bitacora", cadena)

            val datos: TextView = view.findViewById(R.id.txtDatosB)
            datos.setText("${datos.text.toString()} \n $cadena")
        }
    }

    fun escribirArchivo(nombre: String, contenido: String) {
        val ruta = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()
        val nombreArchivo = "$nombre.txt"
        val archivo = File(ruta + "/" + nombreArchivo)

        if (!archivo.exists()) {
            archivo.createNewFile()
            println(archivo.path)
        }

        val fileWrite: FileWriter = FileWriter(archivo, true)

        val escribir: BufferedWriter = BufferedWriter(fileWrite)
        escribir.write("$contenido")

        escribir.close()
        fileWrite.close()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment_BitacoraRegistro.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_BitacoraRegistro().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}