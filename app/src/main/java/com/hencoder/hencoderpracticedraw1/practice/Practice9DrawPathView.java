package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

  private Paint paint = new Paint();
  private Path path = new Path();
  private RectF rectF = new RectF(200, 200, 400, 400);
  private RectF rectF2 = new RectF(400, 200, 600, 400);

  public Practice9DrawPathView(Context context) {
    super(context);
  }

  public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    //        练习内容：使用 canvas.drawPath() 方法画心形
    path.addArc(rectF, -225, 225);
    path.arcTo(rectF2, -180, 225, false);
    path.lineTo(400, 542);

    canvas.drawPath(path, paint);
  }
}
