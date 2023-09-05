package com.rian.myclubapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class Detail_Club : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_FOUNDED = "extra_founded"
        const val EXTRA_NATION = "extra_nation"
        const val EXTRA_LEAGUE = "extra_league"
        const val EXTRA_CITY = "extra_city"
        const val EXTRA_NATION_IMG = "extra_nation_image"
        const val EXTRA_LEAGUE_IMG = "extra_league_image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_club)

        val back: ImageView = findViewById(R.id.btn_back)
        back.setOnClickListener {
            finish()
        }


        val clubItem: ImageView = findViewById(R.id.club_item)
        val clubName: TextView = findViewById(R.id.club_name)
        val clubFounded: TextView = findViewById(R.id.tahun_berdiri)
        val clubCity: TextView = findViewById(R.id.club_city)
        val clubLiga: TextView = findViewById(R.id.liga_name)
        val ligaImg: ImageView = findViewById(R.id.liga_img)
        val clubNation: TextView = findViewById(R.id.nation_name)
        val nationImg: ImageView = findViewById(R.id.nation_img)
        val clubDescription: TextView = findViewById(R.id.club_description)


        val name_club = intent.getStringExtra(EXTRA_NAME)
        val club_img = intent.getStringExtra(EXTRA_PHOTO)
        val club_founded = intent.getStringExtra(EXTRA_FOUNDED)
        val club_city = intent.getStringExtra(EXTRA_CITY)
        val club_liga = intent.getStringExtra(EXTRA_LEAGUE)
        val club_nation = intent.getStringExtra(EXTRA_NATION)
        val club_description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val club_nation_img = intent.getStringExtra(EXTRA_NATION_IMG)
        val club_league_img = intent.getStringExtra(EXTRA_LEAGUE_IMG)



        clubName.text = name_club
        Glide.with(this)
            .load(club_img)
            .apply(RequestOptions())
            .into(clubItem)
        Glide.with(this)
            .load(club_nation_img)
            .apply(RequestOptions())
            .into(nationImg)
        Glide.with(this)
            .load(club_league_img)
            .apply(RequestOptions())
            .into(ligaImg)
        clubFounded.text = club_founded
        clubDescription.text = club_description
        clubNation.text = club_nation
        clubLiga.text = club_liga
        clubCity.text = club_city
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}