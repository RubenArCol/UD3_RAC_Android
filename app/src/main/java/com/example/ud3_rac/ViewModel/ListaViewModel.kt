package com.example.ud3_rac.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ud3_rac.Model.Usuario
import com.example.ud3_rac.Model.UsuarioProvider

class ListaViewModel: ViewModel() {
    private val _lista= MutableLiveData<List<Usuario>>(UsuarioProvider.generaLista(10))
    val lista: LiveData<List<Usuario>>
        get()=_lista

    fun recargarLista(){
        _lista.value=UsuarioProvider.generaLista(10)
    }
}