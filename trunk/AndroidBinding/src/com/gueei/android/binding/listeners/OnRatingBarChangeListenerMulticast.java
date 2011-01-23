package com.gueei.android.binding.listeners;

import android.view.View;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class OnRatingBarChangeListenerMulticast extends MulticastListener<OnRatingBarChangeListener>
	implements OnRatingBarChangeListener{

	@Override
	public void registerToView(View v) {
		if (!(v instanceof RatingBar)) return;
		((RatingBar)v).setOnRatingBarChangeListener(this);
	}

	public void onRatingChanged(RatingBar view, float arg0, boolean fromUser) {
		if (fromUser){
			this.invokeCommands(view, arg0, fromUser);
		}
		this.notifyViewAttributes(view, arg0, fromUser);
	}
}