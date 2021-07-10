package com.sahu.appsetup

import android.os.Bundle
import com.sahu.appUtil.ui.BaseActivity
import com.sahu.appsetup.databinding.MainActivityBinding
import com.sahu.appsetup.ext.replaceFragment
import com.sahu.appsetup.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityBinding>(R.layout.main_activity) {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.main_activity)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, MainFragment.newInstance())
//                .commitNow()
//        }
//    }

    override fun init(savedInstanceState: Bundle?, binding: MainActivityBinding) {
        replaceFragment(
            R.id.container,
            MainFragment.newInstance(),
            "MainFragment",
            addToStack = false
        )
    }
}