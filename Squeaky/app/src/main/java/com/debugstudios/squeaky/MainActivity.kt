package com.debugstudios.squeaky

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.debugstudios.squeaky.presenters.MainPresenter
import com.debugstudios.squeaky.contracts.views.MainView
import kotlinx.android.synthetic.main.activity_main.*
import net.grandcentrix.thirtyinch.TiActivity

class MainActivity : TiActivity<MainPresenter, MainView>(), MainView {

    override fun showText(text: String) {
        text2.text = text
    }

    override fun providePresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
