package com.daria.appword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.random.Random

private const val LAST_SELECTED_ITEM = "item"

class MainActivity : AppCompatActivity() {

    private lateinit var bottomMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        bottomMenu = findViewById(R.id.bottomMenu)

        bottomMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.game -> {
                    val regulationsFragment = RegulationsFragment()
                    replaceFragment(regulationsFragment)
                }
                R.id.regulations -> {
                    val textFragment = TextFragment ()
                    replaceFragment(textFragment)
                }
                R.id.next -> {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.app_name))
                    val chooser = Intent.createChooser(intent, "Поделиться")
                    startActivity(chooser)


                }

            }
            true

        }
        bottomMenu.selectedItemId = savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.game



        }
    private fun replaceFragment (fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()

    }





}