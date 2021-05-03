package ph.apper.android.atienza.api

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_pokemon_image.*
import kotlinx.android.synthetic.main.fragment_pokemon_info.*
import ph.apper.android.atienza.api.api.PokemonAPIClient
import ph.apper.android.atienza.api.extensions.getPokemonID
import ph.apper.android.atienza.api.model.PokemonInfoResponse
import ph.apper.android.atienza.api.model.PokemonListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonInfoFragment : Fragment() {

    private val receiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?){
            var message: String? = intent!!.getStringExtra("data")
            message?.let{
                getData(message.getPokemonID())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupReceiver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_info, container, false)
    }

    override fun onDestroyView() {
        activity!!.unregisterReceiver(receiver)
        super.onDestroyView()
    }

    private fun setupReceiver(){
        val intentFilter = IntentFilter()
        intentFilter.addAction("ph.apper.android.api.broadcast.GETDATA")
        activity!!.registerReceiver(receiver, intentFilter)
    }

    private fun getData(id: Int){
        val call: Call<PokemonInfoResponse> =
            PokemonAPIClient.getPokemonData.getPokemonInfo(id)

        call.enqueue(object: Callback<PokemonInfoResponse> {
            override fun onFailure(
                call: Call<PokemonInfoResponse>,
                t: Throwable
            ){
                Log.d("API CALL", "Failed API CALL")
            }

            override fun onResponse(
                call: Call<PokemonInfoResponse>,
                response: Response<PokemonInfoResponse>
            ) {
                var response: PokemonInfoResponse = response!!.body()!!
                Intent().also{
                    it.setAction("ph.apper.android.api.broadcast.LOADIMAGEACTION")
                    it.putExtra("data",response.sprites.front_default)
                    context!!.sendBroadcast(it)
                }
                pokemon_id.text = "POKEMON ID\n" + response.id.toString()
                pokemon_name.text = "POKEMON NAME\n" + response.name.capitalize()
                pokemon_height.text = "POKEMON HEIGHT\n" + response.height.toString()

                var abilitiesStr: String? = "ABLITIES\n"
                for (ability in response.abilities){
                    abilitiesStr = abilitiesStr + ability.ability.name + "\n"
                }
                pokemon_abilities.text = abilitiesStr
            }
        })
    }
}