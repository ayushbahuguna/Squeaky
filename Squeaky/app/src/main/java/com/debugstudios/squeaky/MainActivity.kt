package com.debugstudios.squeaky

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.View
import android.widget.TextView
import com.debugstudios.squeaky.contracts.views.MainView
import com.debugstudios.squeaky.presenters.MainPresenter
import com.debugstudios.squeaky.ui.fragments.NowPlayingFragment
import com.debugstudios.squeaky.ui.fragments.RecentPlaysFragment
import com.debugstudios.squeaky.ui.fragments.YourMusicFragment
import com.joanzapata.iconify.IconDrawable
import com.joanzapata.iconify.fonts.MaterialIcons
import kotlinx.android.synthetic.main.activity_main.*
import net.grandcentrix.thirtyinch.TiActivity


class MainActivity : TiActivity<MainPresenter, MainView>(), MainView {

    var activityTitles: Array<String>? = null
    var navItemIndex: Int = 0
    var navigationDrawerHeader: View? = null

    // tags used to attach the fragments
    private val TAG_YOUR_MUSIC = "your_music"
    private val TAG_NOW_PLAYING = "now_playing"
    private val TAG_RECENT_PLAYS = "recent_plays"
    var CURRENT_TAG = TAG_YOUR_MUSIC

    override fun providePresenter(): MainPresenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        this.title = "Welcome to Squeaky!"
        activityTitles = resources.getStringArray(R.array.nav_item_activity_titles)

        selectNavMenu()
        loadHomeFragment()
        updateMenuIcons(nav_view.menu)
    }

    /**
     * Sets username in layout/nav_header_main
     */
    override fun setUserName(username: String) {
        navigationDrawerHeader = nav_view.getHeaderView(0)
        val usernameTextView = navigationDrawerHeader!!.findViewById(R.id.username) as TextView
        usernameTextView.text = username
    }

    /**
     * Loads fragments based on current selected item in navigation drawer
     */
    fun loadHomeFragment() {
        // Select appropriate nav-menu item
        selectNavMenu()

        val mPendingRunnable = Runnable {
            val fragment = getHomeFragment()
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                    android.R.anim.fade_out)
            fragmentTransaction.replace(main_frame.id, fragment, CURRENT_TAG)
            fragmentTransaction.commitNowAllowingStateLoss()
        }
        mPendingRunnable.run()

        drawer.closeDrawers()
        invalidateOptionsMenu()
    }

    /**
     * Returns an instance of a fragment based on selected item in navigation drawer
     */
    fun getHomeFragment(): Fragment {
        when (navItemIndex) {
            0 -> return YourMusicFragment()
            1 -> return NowPlayingFragment()
            2 -> return RecentPlaysFragment()
        }
        return NowPlayingFragment()
    }

    /**
     * Item selected listener on navigation drawer
     */
    fun selectNavMenu() {
        nav_view.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_your_music -> {
                    navItemIndex = 0
                    CURRENT_TAG = TAG_YOUR_MUSIC
                }
                R.id.nav_now_playing -> {
                    navItemIndex = 1
                    CURRENT_TAG = TAG_NOW_PLAYING
                }
                R.id.nav_recent -> {
                    navItemIndex = 2
                    CURRENT_TAG = TAG_RECENT_PLAYS
                }
            }
            menuItem.isChecked = !menuItem.isChecked

            loadHomeFragment()
            true
        }

        // The navigation drawer icon on toolbar
        val actionBarDrawerToggle: ActionBarDrawerToggle =
                object : ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer,
                        R.string.closeDrawer) {
                    override fun onDrawerOpened(drawerView: View?) {
                        super.onDrawerOpened(drawerView)
                    }

                    override fun onDrawerClosed(drawerView: View?) {
                        super.onDrawerClosed(drawerView)
                    }
                }

        drawer.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }

    /**
     * Function to add icons to the menu items in navigation drawer
     * @param menu is the activity_main_drawer file in menu which is the menu of nav drawer
     */
    fun updateMenuIcons(menu: Menu) {
        menu.findItem(R.id.nav_now_playing).icon =
                IconDrawable(this, MaterialIcons.md_equalizer)
                        .actionBarSize()

        menu.findItem(R.id.nav_your_music).icon =
                IconDrawable(this, MaterialIcons.md_library_music)
                        .actionBarSize()

        menu.findItem(R.id.nav_recent).icon =
                IconDrawable(this, MaterialIcons.md_av_timer)
                        .actionBarSize()
    }
}

