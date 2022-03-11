package com.example.runningapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.runningapp.R
import com.example.runningapp.databinding.ActivityMainBinding
import com.example.runningapp.db.RunDAO
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    @Inject
//    lateinit var runDAO:RunDAO

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)
        binding.bottomNavigationView.setupWithNavController(findNavController(R.id.navHostFragment))

        findNavController(R.id.navHostFragment).addOnDestinationChangedListener{_,destination,_ ->
            when(destination.id){
                R.id.settingsFragment,R.id.runFragment,R.id.statisticsFragment ->
                    binding.bottomNavigationView.visibility=View.VISIBLE

                else -> binding.bottomNavigationView.visibility=View.GONE
            }
        }


    }
}