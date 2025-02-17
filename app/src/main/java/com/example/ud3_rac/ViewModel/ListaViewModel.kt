package com.example.ud3_rac.ViewModel

import androidx.lifecycle.ViewModel
import com.example.ud3_rac.Model.Usuario
import com.example.ud3_rac.Model.UsuarioProvider

class ListaViewModel: ViewModel() {
    val lista:List<Usuario> = UsuarioProvider.generaLista(50)
}