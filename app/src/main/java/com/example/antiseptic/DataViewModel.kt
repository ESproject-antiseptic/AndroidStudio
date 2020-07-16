package com.example.antiseptic

import android.content.ContentUris
import android.media.Image
import android.net.Uri
import android.provider.MediaStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.Serializable

class DataViewModel : ViewModel(){
    val data = ArrayList<DataSignUp>()
    var dataImage = ArrayList<DataImage>()
    val LiveData = MutableLiveData<ArrayList<DataSignUp>>()
    val LiveDataImage = MutableLiveData<ArrayList<DataImage>>()


    fun setDataImage(item : List<com.esafirm.imagepicker.model.Image> ) {
        //중복되어서 붙여지므로 지워주고 시작함.
        dataImage.clear()
        //이미지 객체를 가져와서 uri 형태로 변환&대입.
        for (i in 0 until item.size) {
            val items =
                ContentUris.withAppendedId(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    item[i].id
                )
            val imagedata = DataImage(Image = items)
            dataImage.add(imagedata)
        }
        LiveDataImage.value=dataImage
    }

    fun deleteDataImage(position: Int) {
//        dataImage.removeAt(position)
//        LiveDataImage.value = dataImage

    }
}