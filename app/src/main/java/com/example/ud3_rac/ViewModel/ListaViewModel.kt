package com.example.ud3_rac.ViewModel

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ud3_rac.Model.Usuario
import com.example.ud3_rac.Model.UsuarioProvider
import kotlin.math.max

class ListaViewModel: ViewModel() {

    private val _lista= MutableLiveData<MutableList<Usuario>>(UsuarioProvider.generaLista(10))
    val lista: LiveData<MutableList<Usuario>>
        get()= _lista

    private var _usuarioSeleccionado = MutableLiveData<Usuario>()
    val usuarioSeleccionado: LiveData<Usuario>
        get()= _usuarioSeleccionado

    private val _pos_modificada = MutableLiveData<Int>() // LiveData para posiciones modificadas
    val pos_modificada: LiveData<Int>
        get() = _pos_modificada

    val timer = object : CountDownTimer(5000, 5000){
        override fun onTick(millisUntilFinished: Long) {

        }

        override fun onFinish() {
            generaUsuario()
            start()
        }

    }

    fun arrancaTimer(){
        timer.start()
    }

    private fun generaUsuario() {
        //_lista.value?.add(Usuario())
        _lista.value = _lista.value?.toMutableList()?.apply { add(Usuario()) }
    }

    fun recargarLista(){
        _lista.value=UsuarioProvider.generaLista(10)
    }

    fun seleccionaUsuario(posicion: Int) {
        _usuarioSeleccionado.value = _lista.value?.get(posicion)
    }

    fun modificaUsuario(nuevoNombre: String) {
        val usuarioSeleccionado = _usuarioSeleccionado.value ?: return
        val nuevaLista = _lista.value?.toMutableList() ?: return

        val index = nuevaLista.indexOfFirst { it.idUsuario == usuarioSeleccionado.idUsuario }
        if (index != -1) {
            nuevaLista[index].nombre = nuevoNombre
            nuevaLista[index].hora = Usuario.devuelveHora()
            _lista.value = nuevaLista
            _pos_modificada.value = index
        }
    }

}