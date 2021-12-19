package com.example.reto_3.casos_uso;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;

import com.example.reto_3.modelo.Productos;
import com.example.reto_3.modelo.Sucursales;
import com.example.reto_3.modelo.Productos;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class CasoUsoProducto {
    public ArrayList<Productos> llenarListaProductos(Cursor cursor){
        ArrayList<Productos> list = new ArrayList<>();
        if(cursor.getCount() == 0){
            return list;
        }else{
            while (cursor.moveToNext()){
                Productos producto = new Productos(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getBlob(4)
                );
                list.add(producto);
            }
            return list;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String imageViewToString(ImageView imageView){
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        String result = java.util.Base64.getEncoder().encodeToString(byteArray);
        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public byte[] stringToByte(String string){
        byte[] result = java.util.Base64.getDecoder().decode(string);
        return result;
    }
}
