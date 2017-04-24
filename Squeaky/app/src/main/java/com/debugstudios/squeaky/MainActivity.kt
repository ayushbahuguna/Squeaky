package com.debugstudios.squeaky

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.afollestad.assent.Assent
import com.afollestad.assent.AssentCallback
import com.debugstudios.squeaky.contracts.views.MainView
import com.debugstudios.squeaky.presenters.MainPresenter
import com.debugstudios.squeaky.ui.fragments.NowPlayingFragment
import com.debugstudios.squeaky.ui.fragments.RecentPlaysFragment
import com.debugstudios.squeaky.ui.fragments.SettingsFragment
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
    private val TAG_SETTINGS = "settings"
    var CURRENT_TAG = TAG_YOUR_MUSIC

    override fun providePresenter(): MainPresenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        Assent.setActivity(this, this)

        if (!Assent.isPermissionGranted(Assent.WRITE_EXTERNAL_STORAGE)) {
            Assent.requestPermissions(AssentCallback { result ->
                if(!result!!.allPermissionsGranted()){
                    Toast.makeText(applicationContext,
                            "Cannot function without the permissions!",
                            Toast.LENGTH_LONG).show()
                } else {
                    selectNavMenu()
                    loadHomeFragment()
                    updateMenuIcons(nav_view.menu)
                }
            }, 69, Assent.WRITE_EXTERNAL_STORAGE)
        }
        else {
            selectNavMenu()
            loadHomeFragment()
            updateMenuIcons(nav_view.menu)
        }

        this.title = "Welcome to Squeaky!"
        activityTitles = resources.getStringArray(R.array.nav_item_activity_titles)
    }

    override fun onResume() {
        super.onResume()
        Assent.setActivity(this, this)
    }

    override fun onPause() {
        super.onPause()
        if (isFinishing)
            Assent.setActivity(this, null)
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<out String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Assent.handleResult(permissions, grantResults)
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
     * Sets the visibility of progress bar
     */
    override fun setLoadingStatus(isLoading: Boolean) {
        val progressBar = findViewById(R.id.main_progress_bar) as ProgressBar
        if (isLoading) {progressBar.visibility = View.VISIBLE}
        else {progressBar.visibility = View.GONE}
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
            3 -> return SettingsFragment()
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
                R.id.nav_settings -> {
                    navItemIndex = 3
                    CURRENT_TAG = TAG_SETTINGS
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

        menu.findItem(R.id.nav_settings).icon =
                IconDrawable(this, MaterialIcons.md_settings)
                        .actionBarSize()
    }
}

