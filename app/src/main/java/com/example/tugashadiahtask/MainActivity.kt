package com.example.tugashadiahtask

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#1DA4EF")))
        actionBar?.setTitle("Task Isep Irmansyah Dana")

        loadFragment(BerandaFragment())
        bottomNav = findViewById(R.id.bottomNav)

        bottomNav.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_LABELED

        bottomNav.itemIconTintList = createColorStateList()
        bottomNav.itemTextColor = createColorStateList()

        bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.beranda -> {
                    loadFragment(BerandaFragment())
                    removeIconShadow(bottomNav)
                    true
                }

                R.id.riwayat -> {
                    val intent = Intent(this, RiwayatActivity::class.java)
                    startActivity(intent)
                    false
                }

                R.id.dompet -> {
                    loadFragment(DompetFragment())
                    removeIconShadow(bottomNav)
                    true
                }

                R.id.profile -> {
                    loadFragment(ProfileFragment())
                    removeIconShadow(bottomNav)
                    true
                }

                else -> false
            }
        }

        drawerLayout = findViewById(R.id.my_drawer_layout)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

    private fun createColorStateList(): ColorStateList {
        val states = arrayOf(
            intArrayOf(android.R.attr.state_checked),
            intArrayOf(-android.R.attr.state_checked)
        )
        val colors = intArrayOf(
            ContextCompat.getColor(this, R.color.biru),
            ContextCompat.getColor(this, R.color.abu)
        )
        return ColorStateList(states, colors)
    }

    private fun removeIconShadow(bottomNavigationView: BottomNavigationView) {
        val menuView = bottomNavigationView.getChildAt(0) as? BottomNavigationMenuView

        menuView?.let {
            for (i in 0 until it.childCount) {
                val itemView = it.getChildAt(i)
                val iconView = itemView.findViewById<View>(com.google.android.material.R.id.icon)

                iconView?.let { icon ->
                    icon.elevation = 0f
                }
            }
        }
    }
}
