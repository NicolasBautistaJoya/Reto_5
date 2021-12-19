package com.example.reto_3.presentacion;

import org.osmdroid.config.Configuration;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.reto_3.BuildConfig;
import com.example.reto_3.R;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;


public class Sucursales extends Fragment {

    private String TABLE_NAME = "SUCURSALES";
    View v;

    public int height=8;

    private MapView myOpenMapView;
    private MapController myMapController;

    public Sucursales() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_sucursales, container, false);

        myOpenMapView = (MapView) v.findViewById(R.id.openmapview);

        //pre 5.6
        //OpenStreetMapTileProviderConstants.setUserAgentValue(BuildConfig.APPLICATION_ID);
        //5.6 and newer
        /* ---- necesitamos establecer el valor del agente de usuario en la configuración ------- */
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);

        GeoPoint Bogota = new GeoPoint(4.675752, -74.104050);
        GeoPoint Sucursal1 = new GeoPoint(4.676387, -74.103707);
        GeoPoint Sucursal2 = new GeoPoint(4.688252, -74.061549);
        GeoPoint Sucursal3 = new GeoPoint(4.591622, -74.122900);

        Drawable icon = this.getResources().getDrawable(R.drawable.logo_mapa);

        myOpenMapView.setBuiltInZoomControls(true);

        myMapController = (MapController) myOpenMapView.getController();
        myMapController.setCenter(Bogota);
        myMapController.setZoom(12);

        myOpenMapView.setMultiTouchControls(true);

        final MyLocationNewOverlay myLocationoverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(getContext()), myOpenMapView);
        myOpenMapView.getOverlays().add(myLocationoverlay);
        myLocationoverlay.enableMyLocation();

        myLocationoverlay.runOnFirstFix(new Runnable() {
            public void run() {
                myMapController.animateTo(myLocationoverlay.getMyLocation());
            }
        });


        ArrayList<OverlayItem> puntos = new ArrayList<OverlayItem>();
        puntos.add(new OverlayItem("Bogota", "Ciudad de Bogota", Bogota));

        OverlayItem over = new OverlayItem("Sucursal1", "Calle 63f #72-55", Sucursal1);
        over.setMarker(icon);
        puntos.add(over);

        OverlayItem over2 = new OverlayItem("Sucursal2", "Ac. 100 ##49- 54", Sucursal2);
        over2.setMarker(icon);
        puntos.add(over2);

        OverlayItem over3 = new OverlayItem("Sucursal3", "Carrera 34 B # 38-97SUR", Sucursal3);
        over3.setMarker(icon);
        puntos.add(over3);

        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemLongPress(int arg0, OverlayItem arg1) {
                return false;
            }
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }
        };

        ItemizedOverlayWithFocus<OverlayItem> capa = new ItemizedOverlayWithFocus<OverlayItem>(getContext(), puntos, tap);
        capa.setFocusItemsOnTap(true);
        myOpenMapView.getOverlays().add(capa);




        return v;
    }
}