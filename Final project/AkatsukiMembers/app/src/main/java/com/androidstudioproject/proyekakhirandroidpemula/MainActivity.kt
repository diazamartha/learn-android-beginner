package com.androidstudioproject.proyekakhirandroidpemula

import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    // kita define RecyclerView di activity_main dalam sebuah variabel rvAkatsuki (~19)
    private lateinit var rvAkatsuki: RecyclerView

    // kita panggil resources yang sudah dibuat di strings.xml
    private val list = ArrayList<Akatsuki>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // (~8) hubungkan variabel rvAkatsuki dengan id RecyclerView nya menggunakan findViewById
        rvAkatsuki = findViewById(R.id.rv_akatsuki)
        // set menjadi fixed size seperti ini
        rvAkatsuki.setHasFixedSize(true)

        list.addAll(getListAkatsuki())
        showRecyclerList()


    }

    // buat fungsi untuk mendapatkan semua data dari resources yg telah kita buat di strings.xml
    private fun getListAkatsuki(): ArrayList<Akatsuki> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataBackstory = resources.getStringArray(R.array.data_backstory)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataSpecialJutsu = resources.getStringArray(R.array.data_specialjutsu)
        val listAkatsuki = ArrayList<Akatsuki>()
        for (i in dataName.indices) {
            val akatsuki = Akatsuki(dataName[i], dataBackstory[i], dataPhoto.getResourceId(i, -1), dataSpecialJutsu[i])
            listAkatsuki.add(akatsuki)
        }
        return listAkatsuki
    }

    private fun showRecyclerList() {
        rvAkatsuki.layoutManager = LinearLayoutManager(this)
        val listAkatsukiAdapter = ListAkatsukiAdapter(list)
        rvAkatsuki.adapter = listAkatsukiAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_about_me, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutMe::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}