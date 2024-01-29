package com.example.artinstituteofchicagono.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.artinstituteofchicagono.R
import com.example.artinstituteofchicagono.databinding.ActivityMainBinding
import com.example.artinstituteofchicagono.ui.fragment.DetailFragment

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        installSplashScreen()

        setContentView(bind.root)


        val bottomNavigationView = bind.bottomNavigation
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNavigationView.setupWithNavController(navController)
    }

        /*navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.detailFragment) {
                bottomNavigationView.visibility = View.GONE
            } else {
                bottomNavigationView.visibility = View.VISIBLE
            }
        }*/


        /*supportFragmentManager.registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {
            override fun onFragmentViewCreated(fm: FragmentManager, f: Fragment, v: View, savedInstanceState: Bundle?) {
                TransitionManager.beginDelayedTransition(bind.root, Slide(Gravity.BOTTOM).excludeTarget(R.id.fragmentContainerView, true))
                when (f) {
                    is DialogFragment -> {

                        bottomNavigationView.visibility = View.GONE
                    }
                    else -> {
                        bottomNavigationView.visibility = View.VISIBLE
                    }
                }
            }
        }, true)
*/
/*
        supportFragmentManager.setFragmentResultListener(
            "paintDia", this
        ) { _: String, bund: Bundle ->

            /*val userData: PaintingSimp? = if (Build.VERSION.SDK_INT >= 33) {
                bund.getParcelable("paint", PaintingSimp::class.java)
            } else {
                bund.getParcelable("paint")
            }*/

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, DetailFragment()).commit()


            // Toast.makeText(this, "any.id", Toast.LENGTH_SHORT).show()
            // var i = Intent(this, DetailActivity::class.java)


            //  startActivity(i)
            /*supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, DetailFragment())
                setReorderingAllowed(true)
                addToBackStack(null)
                commit()
            }*/
        }





        // val appBarConfiguration = AppBarConfiguration(setOf(R.id.mainFragment,    R.id.personalFragment))
        // setupActionBarWithNavController(navController, appBarConfiguration)


    }


 */

}