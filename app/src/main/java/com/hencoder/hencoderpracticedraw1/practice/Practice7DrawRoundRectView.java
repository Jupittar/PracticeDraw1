package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice7DrawRoundRectView extends View {

  private Paint paint;
  private RectF rectF;

  private void init() {
    paint = new Paint();
    rectF = new RectF(100, 100, 400, 300);
  }

  public Practice7DrawRoundRectView(Context context) {
    super(context);
    init();
  }

  public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    //        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
    canvas.drawRoundRect(rectF, 50, 50, paint);
  }
}
