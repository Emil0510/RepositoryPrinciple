package com.emilabdurahmanli.brodcastreciever.ui

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.emilabdurahmanli.brodcastreciever.CustomBroadcastReceiver
import com.emilabdurahmanli.brodcastreciever.R
import com.emilabdurahmanli.brodcastreciever.databinding.ActivityMainBinding
import com.emilabdurahmanli.brodcastreciever.databinding.FragmentBlankBinding
import com.emilabdurahmanli.brodcastreciever.ui.fragment.BlankFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also{
            registerReceiver(CustomBroadcastReceiver(), it)
        }


        loadFragment(BlankFragment())

    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer,fragment)
        transaction.commit()
    }
}