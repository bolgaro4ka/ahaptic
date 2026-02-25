package com.bolgaro4ka.advanced.haptics;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.PluginMethod;

@CapacitorPlugin(name = "AdvancedHaptics")
public class AdvancedHapticsPlugin extends Plugin {

    private Vibrator getVibrator() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            VibratorManager vibratorManager =
                    (VibratorManager) getContext().getSystemService(Context.VIBRATOR_MANAGER_SERVICE);
            return vibratorManager.getDefaultVibrator();
        } else {
            return (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
        }
    }

    @PluginMethod
    public void vibrate(PluginCall call) {
        long duration = call.getLong("duration", 200);
        int amplitude = call.getInt("amplitude", 255);

        Vibrator vibrator = getVibrator();

        if (vibrator == null || !vibrator.hasVibrator()) {
            call.reject("No vibrator available");
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            VibrationEffect effect =
                    VibrationEffect.createOneShot(duration, amplitude);
            vibrator.vibrate(effect);
        } else {
            vibrator.vibrate(duration);
        }

        call.resolve();
    }

    @PluginMethod
    public void vibratePattern(PluginCall call) {
        long[] pattern = call.getArray("pattern").toList().stream()
                .mapToLong(obj -> ((Number) obj).longValue())
                .toArray();

        int repeat = call.getInt("repeat", -1);

        Vibrator vibrator = getVibrator();

        if (vibrator == null || !vibrator.hasVibrator()) {
            call.reject("No vibrator available");
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            VibrationEffect effect =
                    VibrationEffect.createWaveform(pattern, repeat);
            vibrator.vibrate(effect);
        } else {
            vibrator.vibrate(pattern, repeat);
        }

        call.resolve();
    }

    @PluginMethod
    public void predefined(PluginCall call) {
        String type = call.getString("type", "click");

        Vibrator vibrator = getVibrator();

        if (vibrator == null || !vibrator.hasVibrator()) {
            call.reject("No vibrator available");
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            int effectId;

            switch (type) {
                case "tick":
                    effectId = VibrationEffect.EFFECT_TICK;
                    break;
                case "heavy":
                    effectId = VibrationEffect.EFFECT_HEAVY_CLICK;
                    break;
                default:
                    effectId = VibrationEffect.EFFECT_CLICK;
            }

            vibrator.vibrate(VibrationEffect.createPredefined(effectId));
            call.resolve();
        } else {
            vibrator.vibrate(50);
            call.resolve();
        }
    }

    @PluginMethod
    public void cancel(PluginCall call) {
        Vibrator vibrator = getVibrator();
        if (vibrator != null) {
            vibrator.cancel();
        }
        call.resolve();
    }

    @PluginMethod
    public void hasAmplitudeControl(PluginCall call) {
        Vibrator vibrator = getVibrator();
        boolean result = false;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && vibrator != null) {
            result = vibrator.hasAmplitudeControl();
        }

        call.resolve(
            new com.getcapacitor.JSObject().put("value", result)
        );
    }
}
