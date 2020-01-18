package com.sambudisp.made.localization

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HistoryResponse(
        val nama: String? = null,
        val alamat: String? = null,
        val jam: String? = null
) : Parcelable