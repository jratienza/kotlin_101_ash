package ph.apper.android.atienza.api

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_pokemon_list.view.*
import ph.apper.android.atienza.api.api.PokemonAPIClient
import ph.apper.android.atienza.api.viewadapter.PokemonAdapter
import ph.apper.android.atienza.api.model.Pokemon
import ph.apper.android.atienza.api.model.PokemonListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PokemonListFragment : Fragment() {

    lateinit var pokemonAdapter: PokemonAdapter
    var pokemonList  = ArrayList<Pokemon>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_pokemon_list, container, false)

        pokemonAdapter = PokemonAdapter(activity!!.applicationContext, pokemonList)
        view.pokemon_list.adapter = pokemonAdapter
//        view.pokemon_list.layoutManager = GridLayoutManager(activity!!.applicationContext, LinearLayoutManager.VERTICAL, false)
        view.pokemon_list.layoutManager = GridLayoutManager(activity!!.applicationContext, 2)

        getData()

        return view
    }

    fun getData(){
        val call: Call<PokemonListResponse> =
            PokemonAPIClient.getPokemonData.getList(0,100)

        call.enqueue(object: Callback<PokemonListResponse> {
            override fun onFailure(
                call: Call<PokemonListResponse>,
                t: Throwable
            ){
                Log.d("API CALL", "Failed API CALL")
            }

            override fun onResponse(
                call: Call<PokemonListResponse>,
                response: Response<PokemonListResponse>) {
                    var response: PokemonListResponse = response!!.body()!!

                    pokemonAdapter.setList(response.pokemonList)
                }
        })
    }
}