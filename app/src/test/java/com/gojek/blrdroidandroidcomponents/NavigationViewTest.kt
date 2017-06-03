package com.gojek.blrdroidandroidcomponents

import android.app.Activity
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import junit.framework.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.Shadows

@RunWith(CustomRobolectricTestRunner::class)
class CustomNavigationViewTest {

    private lateinit var mainActivityView: View
    private lateinit var navigationView: CustomNavigationView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var activity: Activity

    @Before
    @Throws(Exception::class)
    fun setUp() {
        val activityController = Robolectric.buildActivity(AppCompatActivity::class.java)
        activity = activityController.get()
        mainActivityView = LayoutInflater.from(activity).inflate(R.layout.activity_main, null)
        navigationView = mainActivityView.findViewById(R.id.navigationView) as CustomNavigationView
        drawerLayout = mainActivityView.findViewById(R.id.drawerLayout) as DrawerLayout
    }

    private fun clickNavViewItem(navigationView: NavigationView, navItemResId: Int) {
        val findItem: MenuItem = navigationView.menu.findItem(navItemResId)
        Shadows.shadowOf(navigationView).callOnAttachedToWindow()
        this.navigationView.onNavigationItemSelected(findItem);
    }

    @Test
    fun testThatOnClickingArchiveItemTheDrawerIsClosed() {
        drawerLayout.openDrawer(navigationView)

        clickNavViewItem(navigationView, R.id.nav_archive)

        assertFalse(drawerLayout.isDrawerOpen(navigationView))
    }

    @Test
    fun testThatOnClickingRemindersItemTheDrawerIsClosed() {
        drawerLayout.openDrawer(navigationView)

        clickNavViewItem(navigationView, R.id.nav_reminders)

        assertFalse(drawerLayout.isDrawerOpen(navigationView))
    }

    @Test
    fun testThatOnClickingTrashItemTheDrawerIsClosed() {
        drawerLayout.openDrawer(navigationView)

        clickNavViewItem(navigationView, R.id.nav_trash)

        assertFalse(drawerLayout.isDrawerOpen(navigationView))
    }

    @Test
    fun testThatOnClickingSettingsItemTheDrawerIsClosed() {
        drawerLayout.openDrawer(navigationView)

        clickNavViewItem(navigationView, R.id.nav_settings)

        assertFalse(drawerLayout.isDrawerOpen(navigationView))
    }
}

