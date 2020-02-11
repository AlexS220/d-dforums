package ie.wit.main

import android.app.Application
import android.util.Log
import ie.wit.models.GameMemStore
import ie.wit.models.GameStore

class GameApp: Application (){
    lateinit var gamezStore: GameStore

    override fun onCreate() {
        super.onCreate()
        gamezStore = GameMemStore()
        Log.v("Add game","D&D Forum App started")
    }
}