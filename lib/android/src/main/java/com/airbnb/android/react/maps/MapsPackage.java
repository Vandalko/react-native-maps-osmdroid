package com.airbnb.android.react.maps;

import android.app.Activity;

import com.airbnb.android.react.maps.osmdroid.OsmMapCalloutManager;
import com.airbnb.android.react.maps.osmdroid.OsmMapCircleManager;
import com.airbnb.android.react.maps.osmdroid.OsmMapFileTileManager;
import com.airbnb.android.react.maps.osmdroid.OsmMapManager;
import com.airbnb.android.react.maps.osmdroid.OsmMapMarkerManager;
import com.airbnb.android.react.maps.osmdroid.OsmMapPolygonManager;
import com.airbnb.android.react.maps.osmdroid.OsmMapPolylineManager;
import com.airbnb.android.react.maps.osmdroid.OsmMapUrlTileManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MapsPackage implements ReactPackage {
  public MapsPackage(Activity activity) {
  } // backwards compatibility

  public MapsPackage() {
  }

  @Override
  public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
    return Arrays.<NativeModule>asList(new AirMapModule(reactContext));
  }

  // Deprecated RN 0.47
  public List<Class<? extends JavaScriptModule>> createJSModules() {
    return Collections.emptyList();
  }

  @Override
  public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
    OsmMapCalloutManager osmCalloutManager = new OsmMapCalloutManager();
    OsmMapMarkerManager osmMarkerManager = new OsmMapMarkerManager();
    OsmMapPolylineManager osmPolylineManager = new OsmMapPolylineManager(reactContext);
    OsmMapPolygonManager osmPolygonManager = new OsmMapPolygonManager(reactContext);
    OsmMapCircleManager osmMapCircleManager = new OsmMapCircleManager(reactContext);
    OsmMapManager osmMapManager = new OsmMapManager(reactContext);
    OsmMapUrlTileManager osmUrlTileManager = new OsmMapUrlTileManager();
    OsmMapFileTileManager osmMapFileTileManager = new OsmMapFileTileManager();

    return Arrays.<ViewManager>asList(
            osmCalloutManager,
            osmMarkerManager,
            osmPolylineManager,
            osmPolygonManager,
            osmMapCircleManager,
            osmMapManager,
            osmUrlTileManager,
            osmMapFileTileManager
    );
  }
}
