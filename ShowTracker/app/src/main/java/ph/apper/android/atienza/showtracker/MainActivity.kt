package ph.apper.android.atienza.showtracker

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import ph.apper.android.atienza.showtracker.model.Show
import ph.apper.android.atienza.showtracker.model.ShowGenres
import ph.apper.android.atienza.showtracker.model.ShowType

class MainActivity : AppCompatActivity() {

    companion object {
        var showList: ArrayList<Show> = ArrayList()

        fun addShow(show: Show){
            showList.add(show)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))


        populateShow()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun populateShow(){
        showList = ArrayList()

        var temp  = Show("NeZha", ShowType.MOVIE, ShowGenres.ACTION)
        showList.add(temp)

        temp  = Show("The Social Dilemma", ShowType.MOVIE, ShowGenres.DOCUMENTARY)
        showList.add(temp)

        temp  = Show("Vicenzo", ShowType.KDRAMA, ShowGenres.ACTION)
        showList.add(temp)

        temp  = Show("Oh My Ghost", ShowType.KDRAMA, ShowGenres.ROMANCE)
        showList.add(temp)

        temp  = Show("Attack on Titan", ShowType.ANIME, ShowGenres.ACTION)
        showList.add(temp)

        temp  = Show("HIMYM", ShowType.SERIES, ShowGenres.COMEDY)
        showList.add(temp)

        temp  = Show("F.R.I.E.N.D.S", ShowType.SERIES, ShowGenres.COMEDY)
        showList.add(temp)

        temp = Show("DOTA: Dragon's Blood", ShowType.SERIES, ShowGenres.ANIMATION)
        showList.add(temp)


    }
}