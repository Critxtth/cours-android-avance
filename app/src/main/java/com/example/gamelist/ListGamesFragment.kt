package com.example.gamelist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_list_games.*


class ListGamesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_games, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val queue = Volley.newRequestQueue(this.activity)
        val url = "https://my-json-server.typicode.com/bgdom/cours-android/games"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
               Log.d("salam",response)
                val games = Gson().fromJson(response,Array<Game>::class.java)
                list.layoutManager = LinearLayoutManager(activity)
                list.adapter = GameAdapter(object :GameAdapterInterface {
                    override val games: Array<Game> = games

                    override fun open(game: Game) {
                        fragmentManager!!.beginTransaction().replace(R.id.container, GameItemFragment(game)).commit();
                    }

                })
            },

            Response.ErrorListener { Log.d( "salam","That didn't work!")})

        queue.add(stringRequest)
    }

}




