package ph.apper.android.atienza.api

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.MemoryFile
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_pokemon_image.*


class PokemonImageFragment : Fragment() {

    private val receiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?){
            var image_url: String? = intent!!.getStringExtra("data")

            image_url?.let {
                Picasso
                    .with(activity!!.applicationContext)
                    .load(it)
                    .memoryPolicy(MemoryPolicy.NO_CACHE)
                    .placeholder(R.drawable.ic_pokeball)
                    .error(R.drawable.ic_pokeball)
                    .into(pokemon_image)
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
        return inflater.inflate(R.layout.fragment_pokemon_image, container, false)
    }

    override fun onDestroyView() {
        activity!!.unregisterReceiver(receiver)
        super.onDestroyView()
    }

    private fun setupReceiver(){
        val intentFilter = IntentFilter()
        intentFilter.addAction("ph.apper.android.api.broadcast.LOADIMAGEACTION")
        activity!!.registerReceiver(receiver, intentFilter)
    }
}