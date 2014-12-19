/**
 * CountDownView.java
 * Copyright(C) 2014
 * creator:cuiran 2014-12-19 下午2:18:59
 */
package com.cayden.countdown.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

/**
 * 倒计时View 
 * @author cuiran
 * @version 1.0.0
 */
public class CountDownView extends SurfaceView implements Runnable, Callback {

	private SurfaceHolder mHolder;    //用于控制SurfaceView
	private Canvas mCanvas;    //声明画布
	private Paint mPaint;    //声明画笔
    private int mX, mY;    //用于控制图形的坐标
    
    private Thread mThread;    //声明一个线程

	public CountDownView(Context context) {
		super(context);
		  mHolder = this.getHolder();    	//获得SurfaceHolder对象
	      mHolder.addCallback(this);    	//添加状态监听
	      mPaint = new Paint();    			//创建一个画笔对象
	      mPaint.setColor(Color.BLUE);   	//设置画笔的颜色

	      //设置坐标为50,100
	      mX = 50;
	      mY = 100;

	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		  mThread = new Thread(this);    //创建线程对象
		  
		  mThread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		
	}

	
	@Override
	public void run() {
		
		mDraw();
	}
	
	/**
	 * 自定义绘图方法
	 * 2014-12-19 下午2:22:45
	 *
	 */
	public void mDraw() {
		 mCanvas = mHolder.lockCanvas();   			 //获得画布对象,开始对画布画画
		 mCanvas.drawColor(Color.BLACK);    		 //设置画布颜色为黑色
		 canvas(mCanvas);
		 mHolder.unlockCanvasAndPost(mCanvas);       //把画布显示在屏幕上
	}

	public void canvas(Canvas mCanvas) {
		//画圆,(x轴,y轴,半径,画笔)
        mCanvas.drawCircle(mX + 10, mY + 60, 10, mPaint);
	}
}
