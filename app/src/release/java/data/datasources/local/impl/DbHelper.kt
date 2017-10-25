package com.nodomain.onlynote.data.datasources.local.impl


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.google.gson.Gson
import nl.littlerobots.cupboard.tools.gson.GsonListFieldConverterFactory
import nl.qbusict.cupboard.CupboardFactory.cupboard
import nl.qbusict.cupboard.CupboardBuilder
import nl.qbusict.cupboard.CupboardFactory


class DbHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {

        private const val DB_NAME = "OnlyNote.db"
        private const val DB_VERSION = 1

        init {
            setUpCupboard()
            cupboard().register(NoteDbo::class.java)
        }

        private fun setUpCupboard() {
            val cupboard = CupboardBuilder()
                    .registerFieldConverterFactory(GsonListFieldConverterFactory(Gson()))
                    .build()
            CupboardFactory.setCupboard(cupboard)
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        cupboard().withDatabase(db).createTables()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        cupboard().withDatabase(db).upgradeTables()
    }
}