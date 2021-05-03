package ph.apper.android.atienza.api.viewadapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_pokemonlist_row.view.*
import ph.apper.android.atienza.api.R
import ph.apper.android.atienza.api.model.Pokemon

class PokemonAdapter(private val context:Context, private var pokemonList:ArrayList<Pokemon>)
    :RecyclerView.Adapter<PokemonAdapter.ViewHolder>(){

    fun setList(pokemonList: ArrayList<Pokemon>){
        this.pokemonList.clear()
        this.pokemonList.addAll(pokemonList)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val pokemon_name = view.pokemon_name
        public var btn_view_data = view.btn_view_data

        fun bindItems(pokemon: Pokemon){
            pokemon_name.text = pokemon.name.toUpperCase()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_pokemonlist_row, parent, false)
        )
    }

    override fun getItemCount(): Int = pokemonList.size

    override fun onBindViewHolder(holder: PokemonAdapter.ViewHolder, position: Int) {
        holder.bindItems(pokemonList[position])
        holder.btn_view_data.setOnClickListener{
            Intent().also{
                it.setAction("ph.apper.android.api.broadcast.GETDATA")
                it.putExtra("data", pokemonList[position].url)
                context!!.sendBroadcast(it)
            }
        }
    }
}