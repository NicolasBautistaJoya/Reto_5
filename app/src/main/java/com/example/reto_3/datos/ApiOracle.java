package com.example.reto_3.datos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Build;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.RequiresApi;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.reto_3.adaptadores.ProductoAdapter;
import com.example.reto_3.casos_uso.CasoUsoProducto;
import com.example.reto_3.modelo.Productos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ApiOracle {
    private RequestQueue queue;
    private CasoUsoProducto casoUsoProducto;
    private Context context;
    private String urlProductos = "https://g2ff89fe92350c1-firefood.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/productos/productos";

    public ApiOracle(Context context) {
        this.queue = Volley.newRequestQueue(context);
        this.context = context;
        casoUsoProducto = new CasoUsoProducto();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void insertProducto(String name, String description, String price, ImageView imageView){
        JSONObject json = new JSONObject();
        String image = casoUsoProducto.imageViewToString(imageView);
        try {
            json.put("name", name);
            json.put("description", description);
            json.put("price", price);
            json.put("image",image);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, urlProductos, json, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);
    }

    public void getAllProductos(GridView gridView, ProgressBar progressBar){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlProductos, null, new Response.Listener<JSONObject>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    ArrayList<Productos> list = new ArrayList<>();
                    for(int i=0; i<jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        byte[] image = casoUsoProducto.stringToByte(jsonObject.getString("image"));
                        Productos productos = new Productos(
                                jsonObject.getInt("id"),
                                jsonObject.getString("name"),
                                jsonObject.getString("description"),
                                jsonObject.getString("price"),
                                image

                        );
                        list.add(productos);
                    }
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    ProductoAdapter productoAdapter = new ProductoAdapter(context, list);
                    gridView.setAdapter(productoAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);
    }

    public void deleteProducto(String id){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.DELETE, urlProductos + "/" + id, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);
    }
    public void getProductoById(String id, ImageView imageView, EditText name, EditText description, EditText price){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlProductos + "/" + id, null, new Response.Listener<JSONObject>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    byte[] image = casoUsoProducto.stringToByte(jsonObject.getString("image"));
                    Productos productos = new Productos(
                            jsonObject.getInt("id"),
                            jsonObject.getString("name"),
                            jsonObject.getString("description"),
                            jsonObject.getString("price"),
                            image

                    );
                    byte[] imageProd = productos.getImage();
                    Bitmap bitmap = BitmapFactory.decodeByteArray(imageProd, 0, imageProd.length);
                    imageView.setImageBitmap(bitmap);
                    name.setText(productos.getName());
                    description.setText(productos.getDescription());
                    price.setText(productos.getPrice());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void updateProducto(String id, String name, String description, String price, ImageView imageView){
        JSONObject json = new JSONObject();
        String image = casoUsoProducto.imageViewToString(imageView);
        try {
            json.put("id", id);
            json.put("name", name);
            json.put("description", description);
            json.put("price", price);
            json.put("image", image);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, urlProductos, json, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
            queue.add(jsonObjectRequest);
    }
}
