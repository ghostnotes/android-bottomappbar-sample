package co.ghostnotes.sample.bottomappbar.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import co.ghostnotes.sample.bottomappbar.R
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : AppCompatActivity(), MainContract.View {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        bottom_app_bar.replaceMenu(R.menu.bottomappbar)
        bottom_app_bar.setNavigationOnClickListener(OnNavigationClickListener())
        bottom_app_bar.setOnMenuItemClickListener(OnBottomMenuItemClickListener(this))

        fab.setOnClickListener(OnFabClickListener(this))

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun showToast(@StringRes resId: Int) {
        showToast(getString(resId))
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    internal class OnNavigationClickListener: View.OnClickListener {
        override fun onClick(v: View) {
            Log.d(TAG, "### on navigation clicked.")
        }
    }

    internal class OnBottomMenuItemClickListener(private val view: MainContract.View): Toolbar.OnMenuItemClickListener {
        override fun onMenuItemClick(item: MenuItem): Boolean {
            Log.d(TAG, "### on menu item clicked.")

            when (item.itemId) {
                R.id.menu_fav -> {
                    view.showToast(R.string.message_favorite_clicked)
                    return true
                }
                R.id.menu_map -> {
                    view.showToast(R.string.message_map_clicked)
                    return true
                }
                R.id.menu_settings -> {
                    view.showToast(R.string.message_settings_clicked)
                    return true
                }
            }

            return false
        }
    }

    internal class OnFabClickListener(private val view: MainContract.View): View.OnClickListener {
        override fun onClick(v: View) {
            view.showToast(R.string.message_fab_clicked)
        }
    }

}
