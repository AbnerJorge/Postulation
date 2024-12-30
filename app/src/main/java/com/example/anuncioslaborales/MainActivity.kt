package com.example.anuncioslaborales

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.anuncioslaborales.databinding.ActivityMainBinding
import com.example.anuncioslaborales.viewModel.LoginViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
        navController = navHostFragment.findNavController()
        navController.setGraph(R.navigation.worker_nav_graph)

        bottomNavigationView = binding.bottomNavigationView

        setupNavigation()
        observeBottomNavState()
    }

    private fun observeBottomNavState() {
        TODO("Not yet implemented")
    }

    private fun setupNavigation(){
        bottomNavigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener(){ _, destination, _ ->
            if (destination.id == R.id.loginFragment){
                loginViewModel.hideBottomNav()
            }
        }
    }

    fun setupBottomNavWithController(newNavController: NavController){
        bottomNavigationView.setupWithNavController(newNavController)
    }

    fun bottomNavVisibility(visible: Boolean){
        bottomNavigationView.visibility = if (visible) View.VISIBLE else View.GONE
    }
}

