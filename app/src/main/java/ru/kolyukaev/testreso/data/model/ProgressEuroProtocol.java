package ru.kolyukaev.testreso.data.model;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import ru.kolyukaev.testreso.R;

public class ProgressEuroProtocol extends androidx.appcompat.widget.AppCompatTextView {

    private int mMaxValue = 100;

    public ProgressEuroProtocol(Context context) {
        super(context);
    }

    public ProgressEuroProtocol(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressEuroProtocol(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void setMaxValue(int maxValue) {
        mMaxValue = maxValue;
    }

    // Установка значения
    public synchronized void setValue(int value) {
        // Установка надписи
        this.setText(R.string.euro_protocol_registration);
        this.setTextSize(18);
        this.setTextColor(getResources().getColor(R.color.white));
        this.setPadding(10,10,10,10);

        // Drawable отвечающий за фон
        LayerDrawable background = (LayerDrawable) this.getBackground();

        // Достаём Clip, отвечающий за шкалу, по индексу 1
        ClipDrawable barValue = (ClipDrawable) background.getDrawable(1);

        // Устанавливаем уровень шкалы
        int newClipLevel = (int) (value * 10000 / mMaxValue);
        barValue.setLevel(newClipLevel);

        // Уведомляем об изменении Drawable
        drawableStateChanged();


    }
}
