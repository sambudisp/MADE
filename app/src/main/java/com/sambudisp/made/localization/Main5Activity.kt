package com.sambudisp.made.localization

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.sambudisp.made.R
import kotlinx.android.synthetic.main.activity_main5.*
import kotlinx.android.synthetic.main.bottom_sheet_presisten.*

class Main5Activity : AppCompatActivity(), historyListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val pokeCount = 3
        val hello = resources.getString(
            R.string.hello_world,
            "Narenda Wicaksono",
            pokeCount,
            "Yoza Aprilio"
        )
        tv_hello.text = hello
        val songCount = 5
        val pluralText =
            resources.getQuantityString(R.plurals.numberOfSongsAvailable, songCount, songCount)
        tv_plural.text = pluralText
        tv_xliff.text = resources.getString(R.string.app_homeurl)

        btn_show_botsheetdialog.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.bottom_sheet_animal_list, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()
        }

        btn_show_botsheetdialog_frag.setOnClickListener {
            val bottomSheet = ContohBottomSheetDialog()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }

        val img1 = applicationContext.resources.getDrawable(R.drawable.ic_expand_less_black_24dp)
        val img2 = applicationContext.resources.getDrawable(R.drawable.ic_expand_more_black_24dp)

        val sheetBehavior = BottomSheetBehavior.from(bottom_sheet_presisten)
        sheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(p0: View, p1: Float) {
            }

            override fun onStateChanged(p0: View, p1: Int) {
                when (p1) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        Toast.makeText(applicationContext, "Hidden", Toast.LENGTH_SHORT).show()
                        show_hide_bottom_sheet.setText("Show")
                        show_hide_bottom_sheet.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            img1,
                            null
                        );
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        Toast.makeText(applicationContext, "Expanded", Toast.LENGTH_SHORT).show()
                        show_hide_bottom_sheet.setText("Hide")
                        show_hide_bottom_sheet.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            img2,
                            null
                        );
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        Toast.makeText(applicationContext, "Collapsed", Toast.LENGTH_SHORT).show()
                        show_hide_bottom_sheet.setText("Show")
                        show_hide_bottom_sheet.setCompoundDrawablesWithIntrinsicBounds(
                            null,
                            null,
                            img1,
                            null
                        );
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        Toast.makeText(applicationContext, "Dragging", Toast.LENGTH_SHORT).show()
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        Toast.makeText(applicationContext, "Settling", Toast.LENGTH_SHORT).show()
                    }
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                        Toast.makeText(applicationContext, "Half Expanded", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        })

        // -- //
        val list = ArrayList<HistoryResponse>()
        list.add(HistoryResponse("Sambudi", "Alamatnya", "Jamnya"))
        list.add(HistoryResponse("Sambudi", "Alamatnya", "Jamnya"))
        list.add(HistoryResponse("Sambudi", "Alamatnya", "Jamnya"))
        list.add(HistoryResponse("Sambudi", "Alamatnya", "Jamnya"))
        list.add(HistoryResponse("Sambudi", "Alamatnya", "Jamnya"))

        val historyAdapter = HistoryAdapter(list, this)

        rv_list_presisten?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = historyAdapter
        }

        btn_show_botsheetdialog_2.setOnClickListener {
            if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            } else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
            }
        }

        show_hide_bottom_sheet.setOnClickListener {
            if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            } else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
            }
        }
        // -- //

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_settings) {
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onHistoryClick(history: HistoryResponse) {

    }
}
