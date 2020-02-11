package ie.wit.activities

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import ie.wit.R
import ie.wit.main.GameApp
import ie.wit.models.gameModel

import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.content_game.*

class Game : AppCompatActivity() {


    var game = gameModel ()
    lateinit var app: GameApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        setSupportActionBar(toolbar)
        app = this.application as GameApp

        var ListSystems = arrayOf<String>("D&D 3.5","D&D 4th","D&D 5th","Call Of Cthulu","Savage Worlds","Warhammer 40k","Pathfinder 1E","Pathfinder 2E","FATE","World of Darkness")
        var gameSystem = findViewById(R.id.gameSystem) as Spinner

        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,ListSystems)
        gameSystem.adapter=adapter


        gameSystem.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                Toast.makeText(this@Game, ListSystems[i], Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(adapterView: AdapterView<*>) {
            }
        }

        btnAddPost.setOnClickListener {
            game.title = gameTitle.text.toString()
            game.description = gameDescription.text.toString()
            game.system = gameSystem.selectedItem as String
            game.day = gameDay.text.toString()
            game.time = gameTime.text.toString()

            setResult(AppCompatActivity.RESULT_OK)
            finish()
        }





        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_game, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_forum -> { startActivity(Intent(this,Forum::class.java))
            true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
