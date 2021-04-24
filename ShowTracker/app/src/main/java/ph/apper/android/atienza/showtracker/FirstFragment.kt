package ph.apper.android.atienza.showtracker

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_first.*
import ph.apper.android.atienza.showtracker.model.Show
import ph.apper.android.atienza.showtracker.model.ShowGenres
import ph.apper.android.atienza.showtracker.model.ShowType

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)

    }

    private fun init(view:View){

        var typeArray = arrayOf(
            ShowType.UNDEFINED.toString(),
            ShowType.SERIES.toString(),
            ShowType.ANIME.toString(),
            ShowType.KDRAMA.toString(),
            ShowType.MOVIE.toString(),
            ShowType.OVA.toString()
        )

        val arrayTypeAdapter = ArrayAdapter(
            this.requireContext(),
            android.R.layout.simple_spinner_item,
            typeArray)

        spinner_type.adapter = arrayTypeAdapter
        spinner_type.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.d("Spinner Data", "Type: ${typeArray[position]}")
//                Snackbar.make(
//                        view!!,
//                        "Selected: ${typeArray[position]}",
//                        Snackbar.LENGTH_LONG)
//                        .setAction("Action",
//                                null).show()
            }
        }

        var genreArray = arrayOf(
            ShowGenres.UNDEFINED.toString(),
            ShowGenres.ANIMATION.toString(),
            ShowGenres.COMEDY.toString(),
            ShowGenres.ACTION.toString(),
            ShowGenres.DOCUMENTARY.toString(),
            ShowGenres.DRAMA.toString(),
            ShowGenres.HORROR.toString(),
            ShowGenres.MUSICAL.toString(),
            ShowGenres.ROMANCE.toString(),
            ShowGenres.THRILLER.toString()
        )

        val arrayGenreAdapter = ArrayAdapter(
            this.requireContext(),
            android.R.layout.simple_spinner_item,
            genreArray)

        spinner_genre.adapter = arrayGenreAdapter

        spinner_genre.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
            ) {
                Log.d("Spinner Data", "Genre: ${genreArray[position]}")

//                Snackbar.make(
//                        view!!,
//                        "Selected: ${genreArray[position]}",
//                        Snackbar.LENGTH_LONG)
//                        .setAction("Action",
//                                null).show()
            }
        }



        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            //new Show Added
            var title = et_title.text.toString()
            var genre: String = spinner_genre.selectedItem as String
            var type: String = spinner_type.selectedItem as String

            MainActivity.addShow(Show(
                    title,
                    ShowType.getType(type),
                    ShowGenres.getGenre(genre)
            ))
            Log.d("Data", "$title, $genre, $type")
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}