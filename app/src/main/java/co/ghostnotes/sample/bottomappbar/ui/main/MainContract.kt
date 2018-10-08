package co.ghostnotes.sample.bottomappbar.ui.main

import android.support.annotation.StringRes

interface MainContract {

    interface View {
        fun showToast(@StringRes resId: Int)

        fun showToast(message: String)
    }

}