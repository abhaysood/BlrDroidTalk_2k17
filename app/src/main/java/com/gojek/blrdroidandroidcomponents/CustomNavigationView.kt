package com.gojek.blrdroidandroidcomponents

import android.content.ContentValues
import android.content.Context
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.MenuItem

class CustomNavigationView : NavigationView, NavigationView.OnNavigationItemSelectedListener {
    lateinit var drawerLayout: DrawerLayout

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        setNavigationItemSelectedListener(this)
        if (parent !is DrawerLayout) {
            throw IllegalStateException("NavigationView's parent must be a DrawerLayout")
        } else {
            drawerLayout = parent as DrawerLayout
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_notes -> {
                Log.d(ContentValues.TAG, "nav_notes")
                drawerLayout.closeDrawer(Gravity.START)
                return true
            }
            R.id.nav_archive -> {
                Log.d(ContentValues.TAG, "nav_archive")
                drawerLayout.closeDrawer(Gravity.START)
                return true
            }
            R.id.nav_reminders -> {
                Log.d(ContentValues.TAG, "nav_reminders")
                drawerLayout.closeDrawer(Gravity.START)
                return true
            }
            R.id.nav_trash -> {
                Log.d(ContentValues.TAG, "nav_trash")
                drawerLayout.closeDrawer(Gravity.START)
                return true
            }
            else -> {
                return false
            }
        }
    }
}