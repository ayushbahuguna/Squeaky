package com.debugstudios.squeaky

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.os.Handler
import com.debugstudios.squeaky.presenters.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import net.grandcentrix.thirtyinch.TiActivity
import android.support.design.widget.FloatingActionButton
import android.widget.TextView
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import com.debugstudios.squeaky.R.id.*
import com.debugstudios.squeaky.contracts.views.*

import android.content.Intent
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.view.MenuItem


class MainActivity : TiActivity<MainPresenter, MainView>(), MainView {
    var navigationView: NavigationView? = null
    private var drawer: DrawerLayout? = null
    private var navHeader: View? = null
    private val toolbar: Toolbar? = null
    private var fab: FloatingActionButton? = null
    // index to identify current nav menu item
    var navItemIndex = 0

    // tags used to attach the fragments
    private val TAG_HOME = "home"
    private val TAG_NOW_PLAYING = "nowplaying"
    private val TAG_MUSIC_LIBRARY = "musiclibrary"
    private val TAG_RECENT_PLAYS = "recentplays"
    private val TAG_RECOMMENDED = "recommended"
    private val TAG_SETTINGS = "settings"
    private val TAG_DOWNLOAD = "download"
    var CURRENT_TAG = TAG_NOW_PLAYING

    // toolbar titles respected to selected nav menu item
    private var activityTitles: Array<String>? = null

    // flag to load home fragment when user presses back key
    private val shouldLoadHomeFragOnBackPress = true
    private var handler: Handler? = null

    override fun showText(text: String) {
        //text2.text = text
    }

    override fun providePresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar);
        handler = Handler()
        navHeader = navigationView?.getHeaderView(0)
        drawer = DrawerLayout(this)
        navigationView = NavigationView(this)
        fab = FloatingActionButton(this)
        // load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles)

        fab?.setOnClickListener(View.OnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        })

        // initializing navigation menu
        setUpNavigationView();
        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }
    }

    private fun setUpNavigationView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun loadHomeFragment() {
        // selecting appropriate nav menu item
        selectNavMenu();

        // set toolbar title
        setToolbarTitle();
        if (supportFragmentManager.findFragmentByTag(CURRENT_TAG) != null) {
            drawer?.closeDrawer(0)
            // show or hide the fab button
            toggleFab();
            return;
        }
        val pendingRunnable = Runnable {
            // update the main content by replacing fragments
            val fragment = getHomeFragment()
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG)
            fragmentTransaction.commitAllowingStateLoss()
        }
        if (pendingRunnable != null) {
            handler?.post(pendingRunnable)
        }
        toggleFab()
        drawer?.closeDrawers();
        invalidateOptionsMenu();
    }

    private fun getHomeFragment(): Fragment? {

    }

    private fun toggleFab() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun selectNavMenu() {//Setting Navigation View Item Selected Listener to handle the item click of the navigation menu

        }
    private fun setToolbarTitle() {
        supportActionBar?.setTitle(activityTitles!![navItemIndex])
    }

}

