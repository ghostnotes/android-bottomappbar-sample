package co.ghostnotes.sample.bottomappbar.ui.main

import android.app.Dialog
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialogFragment
import android.support.design.widget.CoordinatorLayout
import android.util.Log
import android.view.View
import co.ghostnotes.sample.bottomappbar.R

class MainBottomSheet: BottomSheetDialogFragment(), MainBottomSheetContract.View {

    companion object {
        private val TAG = MainBottomSheet::class.java.simpleName

        fun newInstance(): MainBottomSheet = MainBottomSheet()
    }

    override fun setupDialog(dialog: Dialog, style: Int) {
        //super.setupDialog(dialog, style)

        val contentView = View.inflate(context, R.layout.main_bottom_sheet, null)
        dialog.setContentView(contentView)

        /*
        val params = (contentView.parent as View).layoutParams
        if (params is CoordinatorLayout.LayoutParams) {
            val behavior = params.behavior
            if (behavior is BottomSheetBehavior) {
                behavior.setBottomSheetCallback(MainBottomSheetCallback(this))
            }
        }
        */
    }

    internal class MainBottomSheetCallback(private val view: MainBottomSheetContract.View): BottomSheetBehavior.BottomSheetCallback() {
        override fun onSlide(v: View, slideOffset: Float) {
            // do nothing.
            Log.d(TAG, "### on slide. [$slideOffset]")
        }

        override fun onStateChanged(v: View, newState: Int) {
            Log.d(TAG, "### bottom sheet state is changed. [$newState]")
            when (newState) {
                BottomSheetBehavior.STATE_HIDDEN -> view.dismiss()
            }
        }
    }

}