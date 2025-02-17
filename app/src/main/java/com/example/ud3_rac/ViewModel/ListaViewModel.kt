package com.example.ud3_rac.ViewModel

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ud3_rac.Model.Usuario
import com.example.ud3_rac.Model.UsuarioProvider

class ListaViewModel: ViewModel() {
    private val _lista= MutableLiveData<MutableList<Usuario>>(UsuarioProvider.generaLista(10))
    val lista: LiveData<MutableList<Usuario>>
        get()= _lista

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

}