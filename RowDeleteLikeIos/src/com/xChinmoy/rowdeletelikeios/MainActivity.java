package com.xChinmoy.rowdeletelikeios;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;

import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;

public class MainActivity extends Activity {
	private ArrayList<String> allContacts = new ArrayList<String>();
	private SwipeListView listview_contact;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String products[] = {"Dell Inspiron", "HTC One X", "HTC Wildfire S", "HTC Sense", "HTC Sensation XE",
                "iPhone 4S", "Samsung Galaxy Note 800",
                "Samsung Galaxy S3", "MacBook Air", "Mac Mini", "MacBook Pro"};
		
		for (int i = 0; i < products.length; i++) {
			allContacts.add(products[i]);
		}
		
		listview_contact = (SwipeListView) findViewById(R.id.listview_products);		
		listview_contact.setAdapter(new ProductsAdapter(this, allContacts));
		
		listview_contact.setSwipeListViewListener(new BaseSwipeListViewListener() {
			int openItem = -1;
		    int lastOpenedItem = -1;
		    int lastClosedItem = -1;
		    
            @Override
            public void onOpened(int position, boolean toRight) {
            	lastOpenedItem = position;
                if (openItem > -1 && lastOpenedItem != lastClosedItem) {
                	listview_contact.closeAnimate(openItem);
                }
                openItem = position;
            }

            @Override
            public void onClosed(int position, boolean fromRight) {
            }

            @Override
            public void onListChanged() {
            }

            @Override
            public void onMove(int position, float x) {
            }

            @Override
            public void onStartOpen(int position, int action, boolean right) {
            }

            @Override
            public void onStartClose(int position, boolean right) {
            	lastClosedItem = position;
            }

            @Override
            public void onClickFrontView(int position) {            
            }

            @Override
            public void onClickBackView(int position) {
            }

            @Override
            public void onDismiss(int[] reverseSortedPositions) {
            	
            }

        });
	}
	
	public int convertDpToPixel(float dp) {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return (int) px;
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
