package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

  private Paint paint;
  private RectF rectF;

  private void init() {
    paint = new Paint();
    rectF = new RectF(100, 100, 400, 300);
  }

  public Practice8DrawArcView(Context context) {
    super(context);
    init();
  }

  public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    //        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
    paint.setStyle(Paint.Style.FILL);
    canvas.drawArc(rectF, -110, 90, true, paint);
    canvas.drawArc(rectF, 45, 90, false, paint);
    paint.setStyle(Paint.Style.STROKE);
    canvas.drawArc(rectF, 180, 45, false, paint);
  }
}
