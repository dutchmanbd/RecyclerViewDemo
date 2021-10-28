package com.oride.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.oride.recyclerviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<Item>()


    lateinit var binding: ActivityMainBinding

    private val itemAdapter by lazy {
        ItemAdapter()
    }

    private val gridLayoutManager by lazy {
        GridLayoutManager(applicationContext, 3)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerViews()
    }

    private fun setupRecyclerViews() {
        binding.rvItems.apply {
            adapter = itemAdapter
            layoutManager = gridLayoutManager
        }


        items.apply {
            add(Item(1, "Slider", Item.Type.Single.type))
            add(Item(2, "Popular", Item.Type.Title.type))
            add(Item(3, "Toyota 1", Item.Type.Grid.type))
            add(Item(4, "Toyota 2", Item.Type.Grid.type))
            add(Item(5, "Toyotav 3", Item.Type.Grid.type))
            add(Item(6, "Toyota 4", Item.Type.Grid.type))
            add(Item(7, "Toyota 5", Item.Type.Grid.type))
            add(Item(8, "Toyota 6", Item.Type.Grid.type))
            add(Item(9, "General", Item.Type.Title.type))
            add(Item(10, "Toyota 7", Item.Type.Grid.type))
            add(Item(11, "Toyota 8", Item.Type.Grid.type))
            add(Item(12, "Toyotav 9", Item.Type.Grid.type))
            add(Item(13, "Toyota 14", Item.Type.Grid.type))
            add(Item(14, "Toyota 51", Item.Type.Grid.type))
            add(Item(15, "Toyota 61", Item.Type.Grid.type))
            add(Item(21, "Flash Sale", Item.Type.Title.type))
            add(Item(120, "Toyota 7", Item.Type.Grid.type))
            add(Item(113, "Toyota 8", Item.Type.Grid.type))
            add(Item(124, "Toyotav 9", Item.Type.Grid.type))
            add(Item(135, "Toyota 14", Item.Type.Grid.type))
            add(Item(145, "Toyota 51", Item.Type.Grid.type))
            add(Item(155, "Toyota 61", Item.Type.Grid.type))
        }

        itemAdapter.differ.submitList(items)

        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (Item.getType(items[position].type)) {
                    Item.Type.Grid -> 1
                    Item.Type.Single -> 3
                    Item.Type.Title -> 3
                }
            }
        }
    }


}