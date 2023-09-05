package com.rian.myclubapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvClub: RecyclerView
    private val list = ArrayList<Club>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val about_me: ImageView = findViewById(R.id.about_me)
        about_me.setOnClickListener {
            val intent = Intent(this, About_Me::class.java)
            startActivity(intent)
        }
        //---------------------------------------------------------------

        val rvClub : RecyclerView = findViewById(R.id.club_rv)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        val characterAdapter = Club_Adapter(getListClub())
        rvClub.setHasFixedSize(true)
        rvClub.layoutManager = layoutManager
        rvClub.adapter = characterAdapter

    }

    private fun getListClub(): ArrayList<Club> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataFounded = resources.getStringArray(R.array.data_berdiri)
        val dataNation = resources.getStringArray(R.array.data_negara)
        val dataLeague = resources.getStringArray(R.array.data_liga)
        val dataCity = resources.getStringArray(R.array.data_kota)
        val dataNationImg = resources.getStringArray(R.array.data_negara_img)
        val dataLeagueImg = resources.getStringArray(R.array.data_liga_img)
        val listHero = ArrayList<Club>()
        for (i in dataName.indices) {
            val club = Club(dataName[i], dataDescription[i], dataPhoto[i], dataFounded[i], dataNation[i], dataLeague[i], dataCity[i], dataNationImg[i], dataLeagueImg[i])
            listHero.add(club)
        }
        return listHero
    }



    private fun showRecyclerList() {
        rvClub.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = Club_Adapter(list)
        rvClub.adapter = listHeroAdapter

    }


}