package ph.apper.android.atienza.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ph.apper.android.atienza.api.viewadapter.PokemonInfoAdapter

class MainActivity : AppCompatActivity() {
    private val pokemonImageFragment = PokemonImageFragment()
    private val pokemonInfoFragment = PokemonInfoFragment()
    private val pokemonListFragment = PokemonListFragment()

    private lateinit var pokemonInfoAdapter: PokemonInfoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_holder, pokemonListFragment)
            .commit()

        pokemonInfoAdapter =
            PokemonInfoAdapter(
                supportFragmentManager
            )
        pokemonInfoAdapter.add(pokemonInfoFragment, "Pokemon Information")
        pokemonInfoAdapter.add(pokemonImageFragment, "PokemonImage")
        pokemon_info_viewpager.adapter = pokemonInfoAdapter
    }

}