package com.networkspeed;

import android.net.TrafficStats;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.Locale;

/**
 * This plugin utilizes the Android TrafficStats class to get the network speed.
 */
public class NetworkSpeedPlugin extends CordovaPlugin {
    private static final String GET_NETWORK_SPEED = "getNetworkSpeed";

    private long mLastRxBytes = 0;
    private long mLastTxBytes = 0;
    private long mLastTime = 0;

    @Override
    protected void pluginInitialize() {
        super.pluginInitialize();
        mLastRxBytes = TrafficStats.getTotalRxBytes();
        mLastTxBytes = TrafficStats.getTotalTxBytes();
        mLastTime = System.currentTimeMillis();
        Log.e("Network Plugin Data", mLastRxBytes + "" + mLastTxBytes + "" + mLastTime);
    }

    /**
     * Executes the request.
     * <p>
     * This method is called from the WebView thread. To do a non-trivial
     * amount of work, use:
     * cordova.getThreadPool().execute(runnable);
     * <p>
     * To run on the UI thread, use:
     * cordova.getActivity().runOnUiThread(runnable);
     *
     * @param action          The action to execute.
     * @param args            The exec() arguments in JSON form.
     * @param callbackContext The callback context used when calling back into
     *                        JavaScript.
     * @return Whether the action was valid.
     */
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals(GET_NETWORK_SPEED)) {
            this.getNetworkSpeed(callbackContext);
            return true;
        }
        return false;
    }

    /**
     * Gets the network speed.
     *
     * @param callbackContext The callback context used when calling back into
     *                        JavaScript.
     * @return The network speed.
     */
    private void getNetworkSpeed(CallbackContext callbackContext) {
        try {
            long currentRxBytes = TrafficStats.getTotalRxBytes();
            long currentTxBytes = TrafficStats.getTotalTxBytes();
            long usedRxBytes = currentRxBytes - mLastRxBytes;
            long usedTxBytes = currentTxBytes - mLastTxBytes;
            long currentTime = System.currentTimeMillis();
            long usedTime = currentTime - mLastTime;

            mLastRxBytes = currentRxBytes;
            mLastTxBytes = currentTxBytes;
            mLastTime = currentTime;

            long totalBytes = usedRxBytes + usedTxBytes;
            long totalSpeed = 0;
            if (usedTime > 0) {
                totalSpeed = totalBytes * 1000 / usedRxBytes;
            }

            double speed = (double) totalSpeed / 1024;
            if (speed > 1) {
                callbackContext.success(String.valueOf((int) speed) + " KB/s");
            } else {
                callbackContext.success(String.format(Locale.ENGLISH, "%.3f", (double) totalSpeed / 1024) + " KB/s");
            }
        } catch (Exception e) {
            callbackContext.error(e.getMessage());
        }
    }
}
