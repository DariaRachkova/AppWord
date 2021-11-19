package com.daria.appword

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

private const val LAST_RANDOMIZED_VALUE = "LAST_RANDOMIZED_VALUE"
private const val LAST_RANDOM_VALUE = "LAST_RANDOM_VALUE"

class RegulationsFragment : Fragment() {

    private lateinit var letterOne: TextView
    private lateinit var randomizeButtonOne: Button
    private lateinit var letterTwo: TextView
    private lateinit var randomizeButtonTwo: Button
    private lateinit var regulationsButton: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_regulations, container, false)

        val bannerList:List<Banner> = listOf(
            Banner(R.drawable.image_fon),
            Banner(R.drawable.image_fon),
            Banner(R.drawable.image_fon)


        )

        val usersRecyclerView: RecyclerView = view.findViewById(R.id.users_recycler_view)
        usersRecyclerView.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)


        usersRecyclerView.adapter = BannerAdapter(bannerList)





        letterOne = view.findViewById(R.id.letter_one)
        randomizeButtonOne = view.findViewById(R.id.randomize_button_one)


        randomizeButtonOne.setOnClickListener { randomize() }

        letterTwo = view.findViewById(R.id.letter_two)
        randomizeButtonTwo = view.findViewById(R.id.randomize_button_two)

        randomizeButtonTwo.setOnClickListener { randomizeTwo() }


        if (savedInstanceState != null)
            letterOne.text = savedInstanceState.getString(LAST_RANDOMIZED_VALUE)

        if (savedInstanceState != null)
            letterTwo.text = savedInstanceState.getString(LAST_RANDOM_VALUE)


        regulationsButton = view.findViewById(R.id.regulations_button)


        val textFragment = TextFragment()
        regulationsButton.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragment_container, textFragment)
                ?.commit()
        }

        return view


    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(LAST_RANDOMIZED_VALUE, letterOne.text.toString())
        outState.putString(LAST_RANDOM_VALUE, letterTwo.text.toString())
        super.onSaveInstanceState(outState)
    }

    private fun randomize() {
        val alphabet: CharRange = 'А'..'Я'
        val randomString: String = List(1) { alphabet.random() }.joinToString("")
        letterOne.text = randomString
    }

    private fun randomizeTwo() {
        val alphabet: CharRange = 'А'..'Я'
        val randomString: String = List(1) { alphabet.random() }.joinToString("")
        letterTwo.text = randomString
    }



}