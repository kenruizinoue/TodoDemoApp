package com.kenruizinoue.tododemoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// 1. Entity Annotation
@Entity
data class TodoItem(
    // 2. Primary Key with Auto-Generate
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    var isDone: Boolean = false
)