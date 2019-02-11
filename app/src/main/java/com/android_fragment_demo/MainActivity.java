package com.android_fragment_demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	FragmentManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.show_one).setOnClickListener(this);
		findViewById(R.id.show_two).setOnClickListener(this);
		findViewById(R.id.remove_fragment).setOnClickListener(this);

		// FragmentManager for managing fragments
		manager = getSupportFragmentManager();

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {

		case R.id.show_one:

			// Replace fragment
			manager.beginTransaction()
					.replace(R.id.container, new Fragment_One(), "First")
					.commit();

			break;
		case R.id.show_two:
			manager.beginTransaction()
					.replace(R.id.container, new Fragment_Two(), "Second")
					.commit();
			break;

		case R.id.remove_fragment:

			// First find fragment by their tags
			Fragment fragment_one = manager.findFragmentByTag("First");
			Fragment fragment_two = manager.findFragmentByTag("Second");

			// Now check if the fragment is null or not
			if (fragment_one != null) {

				// If fragment is not null then remove that frgament
				manager.beginTransaction().remove(fragment_one).commit();
			}
			if (fragment_two != null) {

				manager.beginTransaction().remove(fragment_two).commit();
			}
			break;
		}
	}

}
