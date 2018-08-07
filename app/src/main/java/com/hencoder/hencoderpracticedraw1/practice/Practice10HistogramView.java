package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

  private Paint paint;
  private float barWidth;
  private float barPadding;
  private float width;
  private float height;
  private RectF rectF;

  private int[] values = { 5, 30, 25, 150, 200, 250, 125 };
  private String[] versions = { "Froyo", "GB", "ICS", "JB", "KitKat", "L", "M" };

  private void init() {
    paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    barPadding = 20;
    barWidth = 80;
    rectF = new RectF();
  }

  public Practice10HistogramView(Context context) {
    super(context);
    init();
  }

  public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    width = w;
    height = h;
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    //        综合练习
    //        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
    paint.setColor(Color.WHITE);
    paint.setStrokeWidth(6);
    canvas.drawLine(width / 10, height / 10, width / 10, height * 0.9f, paint);
    canvas.drawLine(width / 10, height * 0.9f, width * 0.9f, height * 0.9f, paint);

    paint.setStyle(Paint.Style.FILL);
    paint.setTextSize(24);
    float nextX = width / 10 + barPadding;
    for (int i = 0; i < versions.length; i++) {
      rectF.left = nextX;
      rectF.top = height * 0.9f - values[i];
      rectF.right = nextX + barWidth;
      rectF.bottom = height * 0.9f;
      paint.setColor(Color.GREEN);
      canvas.drawRect(rectF, paint);
      paint.setColor(Color.WHITE);
      canvas.drawText(versions[i], nextX + 10, height * 0.9f + 20, paint);
      nextX += barWidth + barPadding;
    }
  }
}
