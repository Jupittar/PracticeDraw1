package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice6DrawLineView extends View {

  private Paint paint;

  private void init() {
    paint = new Paint();
  }

  public Practice6DrawLineView(Context context) {
    super(context);
    init();
  }

  public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    //        练习内容：使用 canvas.drawLine() 方法画直线
    canvas.drawLine(100, 100, 400, 300, paint);
  }
}
