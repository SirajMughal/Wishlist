package com.example.wishlist
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.R

// Define a data model class
data class Item(
    val name: String,
    val price: String,
    val url: String)

// Create a custom adapter
class ItemAdapter(private val itemList: List<Item>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    // ViewHolder class for your item views
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Views in your item layout
        val itemNameTextView: TextView = itemView.findViewById(R.id.itemNameTextView)
        val itemPriceTextView: TextView = itemView.findViewById(R.id.itemPriceTextView)
        val itemUrlTextView: TextView = itemView.findViewById(R.id.itemUrlTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate your item layout and create a ViewHolder
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind data to your item views based on the position
        val item = itemList[position]
        holder.itemNameTextView.text = item.name
        holder.itemPriceTextView.text = item.price
        holder.itemUrlTextView.text = item.url
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}