package com.example.ud3_rac.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ud3_rac.ViewModel.ListaViewModel
import com.example.ud3_rac.databinding.FragmentDetailBinding

class detailFragment : Fragment() {
    val vm: ListaViewModel by activityViewModels()

    var _enlace:FragmentDetailBinding?=null
    val enlace
        get()=_enlace!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _enlace = FragmentDetailBinding.inflate(inflater, container, false)
        val vista = enlace.root

        return vista
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.usuarioSeleccionado.observe(viewLifecycleOwner){usuarioSeleccionado ->
            enlace.recuperaNombre.setText(usuarioSeleccionado.nombre)
        }

        enlace.btnEdit.setOnClickListener{
            vm.usuarioSeleccionado.value?.let { usuarioSeleccionado ->
                val nuevoNombre: String = enlace.recuperaNombre.text.toString()
                vm.modificaUsuario(nuevoNombre)
            }
        }
    }

}