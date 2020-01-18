package com.sambudisp.made.localization

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sambudisp.made.R
import kotlinx.android.synthetic.main.bottom_sheet_animal_list.*

class ContohBottomSheetDialog : BottomSheetDialogFragment(), historyListener {
    override fun onHistoryClick(history: HistoryResponse) {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.bottom_sheet_animal_list, container, false)
        return v //super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //return super.onCreateDialog(savedInstanceState)
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.setOnShowListener { setupBottomSheet(it) }
        return dialog
    }

    private fun setupBottomSheet(dialogInterface: DialogInterface) {
        val bottomSheetDialog = dialogInterface as BottomSheetDialog
        val bottomSheet = bottomSheetDialog.findViewById<View>(
                com.google.android.material.R.id.design_bottom_sheet)
                ?: return
        bottomSheet.setBackgroundColor(Color.TRANSPARENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val list = ArrayList<HistoryResponse>()
        list.add(HistoryResponse("Sambudi", "Alamatnya", "Jamnya"))
        list.add(HistoryResponse("Sambudi", "Alamatnya", "Jamnya"))
        list.add(HistoryResponse("Sambudi", "Alamatnya", "Jamnya"))
        list.add(HistoryResponse("Sambudi", "Alamatnya", "Jamnya"))
        list.add(HistoryResponse("Sambudi", "Alamatnya", "Jamnya"))

        //val listOfHistory = mutableListOf<HistoryResponse>()
        val historyAdapter = HistoryAdapter(list, this)

        rv_list?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = historyAdapter
        }
    }
}