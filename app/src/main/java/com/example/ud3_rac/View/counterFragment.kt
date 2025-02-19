package com.example.ud3_rac.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.ud3_rac.R
import com.example.ud3_rac.ViewModel.ListaViewModel

class counterFragment : Fragment() {
    val vm: ListaViewModel by activityViewModels()

    private lateinit var contadorTextView: TextView
    private lateinit var modificadoTextView: TextView
    private lateinit var EliminadoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_counter, container, false)

        contadorTextView = vista.findViewById(R.id.Insertado)
        modificadoTextView = vista.findViewById(R.id.Modificado)
        EliminadoTextView = vista.findViewById(R.id.Eliminado)

        vm.lista.observe(viewLifecycleOwner) { lista ->
            contadorTextView.text = vm.contadorUsuario.value.toString()
        }

        vm.pos_modificada.observe(viewLifecycleOwner) { posicion ->
            if (posicion >= 0) {
                modificadoTextView.text = vm.contadorModificado.value.toString()
            }
        }

        vm.pos_eliminada.observe(viewLifecycleOwner) { posicion ->
            if (posicion >= 0) {
                EliminadoTextView.text = vm.contadorEliminado.value.toString()
            }
        }

        return vista
    }
}