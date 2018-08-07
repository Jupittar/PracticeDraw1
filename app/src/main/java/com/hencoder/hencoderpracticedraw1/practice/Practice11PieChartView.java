package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class Practice11PieChartView extends View {

  private Paint paint;
  private float width;
  private float height;
  private List<PieModel> data;
  private RectF rectF;
  private Rect rect;
  private float radius;
  private int selectedIndex;

  private void init() {
    data = new ArrayList<>();
    data.add(new PieModel("Lollipop", 50, Color.RED));
    data.add(new PieModel("Marshmallow", 30, Color.YELLOW));
    data.add(new PieModel("Froyo", 10, Color.GREEN));
    data.add(new PieModel("Gingerbread", 5, Color.BLUE));
    data.add(new PieModel("Ice Cream Sandwich", 15, Color.CYAN));
    data.add(new PieModel("Jelly Bean", 35, Color.MAGENTA));
    data.add(new PieModel("Kitkat", 40, Color.LTGRAY));

    paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    radius = 200;
    rectF = new RectF();
    rect = new Rect();

    float sum = 0;
    for (PieModel model : data) {
      sum += model.value;
    }
    for (PieModel model : data) {
      model.percentage = model.value / sum;
      model.angle = model.percentage * 360;
    }
  }

  public Practice11PieChartView(Context context) {
    super(context);
    init();
  }

  public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
    //        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
    if (data == null) return;

    canvas.translate(width / 2, height / 2);
    float startAngle = 0;
    rectF.left = -radius;
    rectF.top = -radius;
    rectF.right = radius;
    rectF.bottom = radius;

    paint.setStyle(Paint.Style.FILL);

    for (int i = 0; i < data.size(); i++) {
      PieModel model = data.get(i);
      paint.setColor(model.color);
      // 扇形中心线夹角对应的坐标系弧度
      float theta = (float) ((startAngle + model.angle / 2) * Math.PI / 180);
      if (i == selectedIndex) {
        canvas.save();
        canvas.translate((float) (20 * Math.cos(theta)), (float) (20 * Math.sin(theta)));
        canvas.drawArc(rectF, startAngle, model.angle, true, paint);
        drawInfo(canvas, model, theta);
        canvas.restore();
      } else {
        canvas.drawArc(rectF, startAngle, model.angle - 2, true, paint);
        drawInfo(canvas, model, theta);
      }

      startAngle += model.angle;
    }
  }

  private void drawInfo(Canvas canvas, PieModel model, float theta) {
    // 画线和文字
    float startPointX = (float) (radius * Math.cos(theta));
    float startPointY = (float) (radius * Math.sin(theta));
    float middlePointX = (float) ((radius + 40) * Math.cos(theta));
    float middlePointY = (float) ((radius + 40) * Math.sin(theta));

    paint.setColor(Color.WHITE);
    paint.setStrokeWidth(3);
    paint.setTextSize(24);
    canvas.drawLine(startPointX, startPointY, middlePointX, middlePointY, paint);

    float endPointX;
    paint.getTextBounds(model.name, 0, model.name.length(), rect);

    if (theta > Math.PI / 2 && theta < Math.PI * 3 / 2) { // 左边
      endPointX = middlePointX - 40;
      canvas.drawLine(middlePointX, middlePointY, endPointX, middlePointY, paint);
      canvas.drawText(model.name, endPointX - rect.width() - 10, middlePointY + rect.height()/2, paint);
    } else { // 右边
      endPointX = middlePointX + 40;
      canvas.drawLine(middlePointX, middlePointY, endPointX, middlePointY, paint);
      canvas.drawText(model.name, endPointX + 10, middlePointY + rect.height()/2, paint);
    }
  }

  private static class PieModel {
    public String name;
    public float value;
    public float percentage;
    public int color;
    public float angle;

    public PieModel(String name, float value, int color) {
      this.name = name;
      this.value = value;
      this.color = color;
    }
  }
}
