package com.example.ud3_rac.Model

import java.time.LocalTime
import kotlin.random.Random

class Usuario (
    val idUsuario:Int = ++id,
    var nombre:String = nombreAleatorio(),
    var hora:LocalTime = LocalTime.now()
){
    companion object{
        const val VOCALES = "aeiou"
        const val CONSONANTES = "bcdfghjklmnpqrstvwxyz"
        var id:Int = 0

        fun nombreAleatorio():String{//Entre 4 y 6 letras
            val nombre: StringBuilder = StringBuilder("")
            //Dos letras siempre
            if (Math.random() < 0.5) { //por añadir un poco de variedad a la estructura
                nombre.append(vocalAleatoria())
                nombre.append(consonanteAleatoria())
            } else {
                nombre.append(consonanteAleatoria())
                nombre.append(vocalAleatoria())
            }
            if(Random.nextInt(2)==1) nombre.append(vocalAleatoria())//quizás esta también
            if(Random.nextInt(2)==1)nombre.append(consonanteAleatoria())//quizás esta también
            //Otras dos letras siempre
            if (Math.random() < 0.5) { //por añadir un poco de variedad a la estructura
                nombre.append(vocalAleatoria())
                nombre.append(consonanteAleatoria())
            } else {
                nombre.append(consonanteAleatoria())
                nombre.append(vocalAleatoria())
            }
            return nombre.toString()
        }

        fun vocalAleatoria(): String {
            val pos = (Math.random() * VOCALES.length).toInt()
            return VOCALES.substring(pos, pos + 1)
        }

        fun consonanteAleatoria(): String {
            val pos = (Math.random() * CONSONANTES.length).toInt()
            return CONSONANTES.substring(pos, pos + 1)
        }


    }

}