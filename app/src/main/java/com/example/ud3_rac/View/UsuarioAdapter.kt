package com.example.ud3_rac.View

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.ud3_rac.Model.Usuario

import com.example.ud3_rac.databinding.LineausuarioBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class UsuarioAdapter(private val values: List<Usuario>) : RecyclerView.Adapter<UsuarioAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LineausuarioBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rellena(values[position])
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val binding: LineausuarioBinding) : RecyclerView.ViewHolder(binding.root) {
        fun rellena(usuario: Usuario){
            binding.idUsuario.text = usuario.idUsuario.toString()
            binding.horaUsuario.text = usuario.hora
            binding.nombreUsuario.text = usuario.nombre
        }
    }

}