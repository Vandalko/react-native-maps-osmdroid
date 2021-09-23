package com.airbnb.android.react.maps;

import android.app.Activity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.module.annotations.ReactModule;

import java.io.Closeable;
import java.io.IOException;

import java.util.Map;
import java.util.HashMap;

@ReactModule(name = AirMapModule.NAME)
public class AirMapModule extends ReactContextBaseJavaModule {

  public static final String NAME = "AirMapModule";

  public AirMapModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public Map<String, Object> getConstants() {
    final Map<String, Object> constants = new HashMap<>();
    constants.put("legalNotice", "This license information is displayed in Settings > Google > Open Source on any device running Google Play services.");
    return constants;
  }

  public Activity getActivity() {
    return getCurrentActivity();
  }

  public static void closeQuietly(Closeable closeable) {
    if (closeable == null) return;
    try {
      closeable.close();
    } catch (IOException ignored) {
    }
  }

}
