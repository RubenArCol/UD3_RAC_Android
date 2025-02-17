package com.example.ud3_rac.Model

object UsuarioProvider {
    fun generaLista(cantidad:Int=100)=List(cantidad){ Usuario() }
}