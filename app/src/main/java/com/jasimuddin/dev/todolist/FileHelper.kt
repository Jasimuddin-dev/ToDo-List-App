package com.jasimuddin.dev.todolist

import android.content.Context
import java.io.*

class FileHelper {

    val FILENAME="listinfo.dat"
    fun writeData(item:ArrayList<String>,context:Context){
        var fos:FileOutputStream=context.openFileOutput(FILENAME,Context.MODE_PRIVATE)

        var oas=ObjectOutputStream(fos)
        oas.writeObject(item)
        oas.close()
    }

    fun readDate(context: Context):ArrayList<String>
    {
        var itemList:ArrayList<String> = try {
            var fis:FileInputStream=context.openFileInput(FILENAME)
            var ois=ObjectInputStream(fis)
            ois.readObject() as ArrayList<String>
        } catch (e: FileNotFoundException){
            ArrayList()
        }

        return itemList
    }

}