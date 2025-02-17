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
class UsuarioAdapter(
    private val values: Usuario.Companion
) : RecyclerView.Adapter<UsuarioAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LineausuarioBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content
        holder.fecha.text = item.details
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: LineausuarioBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.idUsuario
        val contentView: TextView = binding.nombreUsuario
        val fecha: TextView = binding.horaUsuario

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}