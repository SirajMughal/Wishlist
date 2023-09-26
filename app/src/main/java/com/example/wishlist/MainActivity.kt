package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // In your activity code:
        // Initialize the RecyclerView and adapter
        val recyclerView: RecyclerView = findViewById(R.id.list_items)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val itemList = mutableListOf<Item>() // Your data source
        val adapter = ItemAdapter(itemList)
        recyclerView.adapter = adapter

// Handle user input and add new items
        val submitButton: Button = findViewById(R.id.button)
        val itemNameEditText: EditText = findViewById(R.id.editTextText)
        val itemPriceEditText: EditText = findViewById(R.id.editTextText2)
        val itemUrlEditText: EditText = findViewById(R.id.editTextText3)

        submitButton.setOnClickListener {
            //Log.d("SubmitButton", "Clicked")

            // Get user input
            val itemName = itemNameEditText.text.toString()
            val itemPrice = itemPriceEditText.text.toString()
            val itemUrl = itemUrlEditText.text.toString()

            // Create a new item
            val newItem = Item(itemName, itemPrice, itemUrl)

            // Add the new item to the data source
            itemList.add(newItem)


            // Notify the adapter that the data has changed
            adapter.notifyDataSetChanged()

            // Clear the input fields
            itemNameEditText.text.clear()
            itemPriceEditText.text.clear()
            itemUrlEditText.text.clear()
        }
    }
}