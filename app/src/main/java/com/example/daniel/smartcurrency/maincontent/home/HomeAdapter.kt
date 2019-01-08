package com.example.daniel.smartcurrency.maincontent.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.daniel.smartcurrency.R
import com.example.daniel.smartcurrency.models.Currency

class HomeAdapter(private var currencies: List<Currency>,
                  private var listener: (Currency) -> Unit): RecyclerView.Adapter<HomeAdapter.ImageViewHolder>() {

    fun setCurrenciesAndUpdate(currencies: ArrayList<Currency>){
        this.currencies = currencies;
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.home_recyclerview_item, parent, false)
        return ImageViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return this.currencies.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) : Unit = holder.bind(position, listener)


    inner class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val currency_title: TextView = itemView.findViewById(R.id.currency_title)
        private val rate_title: TextView = itemView.findViewById(R.id.rate_title)
        fun bind(position: Int, listener: (Currency) -> Unit) = with(itemView){
            val currency = currencies[position]
            currency_title.text = currency.currency
            rate_title.text = currency.rate
        }
    }
}