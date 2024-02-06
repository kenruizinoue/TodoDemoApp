package com.kenruizinoue.tododemoapp

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltTestApplication

class CustomTestRunner : AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader?, name: String?, context: Context?): Application {
        // 3. Super Application Call
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }
}