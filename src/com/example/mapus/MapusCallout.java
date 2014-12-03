package com.example.mapus;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * This is just a random View used to show callouts.
 * It's old and is probably chock-full of errors and
 * bad-practice, but was handy and looks decent.
 */

public class MapusCallout extends RelativeLayout {

	// they deprecated setBackgroundDrawable just so they could rename it
	// the new method (setBackground) doesn't work with older SDKs, and the
	// old method (setBackgroundDrawable) gives a deprecation warning.
	// it's unreasonable to expect us to go through the min/target sdk 
	// dance while having to fork conditionals in each call to set a
	// drawable to a View.  Thus the suppresswarnings.  So there.
	@SuppressWarnings("deprecation")
	public MapusCallout( Context context ) {

		super( context );

		LinearLayout bubble = new LinearLayout( context );
		bubble.setOrientation( LinearLayout.HORIZONTAL );
		int[] colors = { 0xBBfd6624, 0xFFfd6624 };	//gradient alpha orig: E6
		GradientDrawable drawable = new GradientDrawable( GradientDrawable.Orientation.TOP_BOTTOM, colors );
		drawable.setCornerRadius( 6 );
		drawable.setStroke( 2, 0xDD000000 );
		bubble.setBackgroundDrawable( drawable );
		bubble.setId( 1 );
		bubble.setGravity( Gravity.CENTER_VERTICAL );
		bubble.setPadding( 10, 10, 10, 10 );
		LayoutParams bubbleLayout = new LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT );
		addView( bubble, bubbleLayout );
		
		//button test
		Button cancelBtn = new Button(context); 
	    cancelBtn.setText("Remove"); 
	    
	    /*
	    //param test: position buttons at bottom
	    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)cancelBtn.getLayoutParams();
	    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
	    cancelBtn.setLayoutParams(params);
	    
	    bubble.addView(cancelBtn, params);
	    									*/
	    
	    //original params
	    bubble.addView(cancelBtn, new LayoutParams(
								                   LayoutParams.WRAP_CONTENT, 
								                   LayoutParams.WRAP_CONTENT)
								                  );
	    

	    
		Button sendBtn = new Button(context); 
	    sendBtn.setText("Share"); 
	    bubble.addView(sendBtn, new LayoutParams(
							                     LayoutParams.WRAP_CONTENT, 
							                     LayoutParams.WRAP_CONTENT)
							                	);
	  
	    /*LinearLayout.LayoutParams layoutParams = new  LinearLayout.LayoutParams(70, 70);
	    layoutParams.setMargins(5, 3, 0, 0); // left, top, right, bottom
	    btn.setLayoutParams(layoutParams);*/
	    

		Nub nub = new Nub( context );
		LayoutParams nubLayout = new LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT );
		nubLayout.addRule( RelativeLayout.BELOW, bubble.getId() );
		nubLayout.addRule( RelativeLayout.CENTER_IN_PARENT );
		addView( nub, nubLayout );

		LinearLayout labels = new LinearLayout( context );
		labels.setGravity( Gravity.CENTER_VERTICAL );
		labels.setOrientation( LinearLayout.VERTICAL );
		LinearLayout.LayoutParams labelLayout = new LinearLayout.LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT );
		labelLayout.setMargins( 12, 0, 12, 0 );
		bubble.addView( labels, labelLayout );

		TextView titleView = new TextView( getContext() );
		titleView.setTextColor( 0xFFFFFFFF );
		titleView.setTextSize( 15 );
		titleView.setMaxWidth( 250 );
		titleView.setTypeface( Typeface.SANS_SERIF, Typeface.BOLD );
		titleView.setText( "Position" );
		labels.addView( titleView );

		TextView subTitleView = new TextView( getContext() );
		subTitleView.setTextColor( 0xFFFFFFFF );
		subTitleView.setTextSize( 12 );
		subTitleView.setTypeface( Typeface.SANS_SERIF );
		subTitleView.setText( "Somebody is studying here..." );
		labels.addView( subTitleView );

	}

	public void transitionIn() {

		ScaleAnimation scaleAnimation = new ScaleAnimation( 0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1f );
		scaleAnimation.setInterpolator( new OvershootInterpolator( 1.2f ) );
		scaleAnimation.setDuration( 250 );

		AlphaAnimation alphaAnimation = new AlphaAnimation( 0, 1f );
		alphaAnimation.setDuration( 200 );

		AnimationSet animationSet = new AnimationSet( false );

		animationSet.addAnimation( scaleAnimation );
		animationSet.addAnimation( alphaAnimation );

		startAnimation( animationSet );

	}

	private static class Nub extends View {

		private Paint paint = new Paint();
		private Path path = new Path();

		public Nub( Context context ) {

			super( context );

			paint.setStyle( Paint.Style.FILL );
			paint.setColor( 0xFFFD6624 );
			paint.setAntiAlias( true );

			path.lineTo( 20, 0 );
			path.lineTo( 10, 15 );
			path.close();

		}

		@Override
		protected void onMeasure( int widthMeasureSpec, int heightMeasureSpec ) {
			setMeasuredDimension( 20, 15 );
		}

		@Override
		public void onDraw( Canvas canvas ) {
			canvas.drawPath( path, paint );
			super.onDraw( canvas );
		}
	}

}