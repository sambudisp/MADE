package com.sambudisp.made.sqliteNoteApp

import android.net.Uri
import android.provider.BaseColumns
import android.service.notification.Condition.SCHEME

object DatabaseContract {

    const val AUTHORITY = "com.sambudisp.made"
    const val SCHEME = "content"

    internal class NoteColumns : BaseColumns{
        companion object {
            const val TABLE_NAME = "note"
            const val _ID = "_id"
            const val TITLE = "title"
            const val DESCRIPTION = "description"
            const val DATE = "date"

            // untuk membuat URI content://com.dicoding.picodiploma.mynotesapp/note
            val CONTENT_URI: Uri = Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_NAME)
                .build()
        }
    }
}