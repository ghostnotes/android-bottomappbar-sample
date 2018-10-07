package co.ghostnotes.sample.bottomappbar.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.view.View
import co.ghostnotes.sample.bottomappbar.R
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        bottom_app_bar.replaceMenu(R.menu.bottomappbar)
        bottom_app_bar.setNavigationOnClickListener(OnNavigationClickListener())
        bottom_app_bar.setOnMenuItemClickListener(OnBottomMenuItemClickListener())

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    internal class OnNavigationClickListener: View.OnClickListener {
        override fun onClick(v: View?) {
            Log.d(TAG, "### on navigation clicked.")
        }
    }

    internal class OnBottomMenuItemClickListener: Toolbar.OnMenuItemClickListener {
        override fun onMenuItemClick(item: MenuItem?): Boolean {
            Log.d(TAG, "### on menu item clicked.")

            return true
        }
    }

}
