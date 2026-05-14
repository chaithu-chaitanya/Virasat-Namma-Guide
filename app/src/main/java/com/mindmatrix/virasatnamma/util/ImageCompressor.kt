package com.mindmatrix.virasatnamma.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import java.io.File
import java.io.FileOutputStream

object ImageCompressor {
    fun compressToInternalStorage(context: Context, uri: Uri): String {
        val input = context.contentResolver.openInputStream(uri) ?: error("Unable to open image")
        val original = BitmapFactory.decodeStream(input) ?: error("Unsupported image")
        val maxSide = 1280
        val ratio = minOf(maxSide.toFloat() / original.width, maxSide.toFloat() / original.height, 1f)
        val bitmap = if (ratio < 1f) {
            Bitmap.createScaledBitmap(original, (original.width * ratio).toInt(), (original.height * ratio).toInt(), true)
        } else {
            original
        }
        val dir = File(context.filesDir, "site_images").apply { mkdirs() }
        val file = File(dir, "site_${System.currentTimeMillis()}.jpg")
        FileOutputStream(file).use { out ->
            bitmap.compress(Bitmap.CompressFormat.JPEG, 78, out)
        }
        if (bitmap !== original) bitmap.recycle()
        original.recycle()
        return file.absolutePath
    }

    fun deleteIfInternal(path: String) {
        runCatching {
            val file = File(path)
            if (file.exists() && file.absolutePath.contains("${File.separator}site_images${File.separator}")) {
                file.delete()
            }
        }
    }
}
