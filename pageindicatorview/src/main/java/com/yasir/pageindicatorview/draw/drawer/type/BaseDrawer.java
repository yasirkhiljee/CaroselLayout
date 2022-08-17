package com.yasir.pageindicatorview.draw.drawer.type;

import android.graphics.Paint;
import androidx.annotation.NonNull;

import com.yasir.pageindicatorview.draw.data.Indicator;

class BaseDrawer {

    Paint paint;
    Indicator indicator;

    BaseDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        this.paint = paint;
        this.indicator = indicator;
    }
}
