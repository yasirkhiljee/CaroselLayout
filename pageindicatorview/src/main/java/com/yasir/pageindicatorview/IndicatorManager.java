package com.yasir.pageindicatorview;

import androidx.annotation.Nullable;

import com.yasir.pageindicatorview.animation.AnimationManager;
import com.yasir.pageindicatorview.animation.controller.ValueController;
import com.yasir.pageindicatorview.animation.data.Value;
import com.yasir.pageindicatorview.draw.DrawManager;
import com.yasir.pageindicatorview.draw.data.Indicator;

public class IndicatorManager implements ValueController.UpdateListener {

    private final DrawManager drawManager;
    private final AnimationManager animationManager;
    private final Listener listener;

    interface Listener {
        void onIndicatorUpdated();
    }

    IndicatorManager(@Nullable Listener listener) {
        this.listener = listener;
        this.drawManager = new DrawManager();
        this.animationManager = new AnimationManager(drawManager.indicator(), this);
    }

    public AnimationManager animate() {
        return animationManager;
    }

    public Indicator indicator() {
        return drawManager.indicator();
    }

    public DrawManager drawer() {
        return drawManager;
    }

    @Override
    public void onValueUpdated(@Nullable Value value) {
        drawManager.updateValue(value);
        if (listener != null) {
            listener.onIndicatorUpdated();
        }
    }
}
