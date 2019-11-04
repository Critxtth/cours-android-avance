package com.example.gamelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.game_item.view.*

class GameAdapter(val games: GameAdapterInterface) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(games.games[position])
    }

    override fun getItemCount(): Int {
        return games.games.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val element = LayoutInflater.from(parent.context).inflate(R.layout.game_item, parent, false)
        return ViewHolder(element)
    }

    inner class ViewHolder(val container: View) : RecyclerView.ViewHolder(container) {
        fun bind(game: Game) {
            container.name.text = game.name
            this.container.setOnClickListener{
                games.open(game)
            }
            Picasso.get().load(game.img).into(container.image);

        }
    }
}