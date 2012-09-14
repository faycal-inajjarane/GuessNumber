package com.appspot.faycalinajjarane.guessnumber.assets;

import java.util.Locale;

import com.appspot.faycalinajjarane.guessnumber.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public class ApplicationBehaviors {

	
	public static void setLocale(Locale locale, Activity activityToReload, int level){

    	Resources res = activityToReload.getResources();
    	Configuration conf = res.getConfiguration();
    	conf.locale = locale;
    	res.updateConfiguration(conf, res.getDisplayMetrics());

		try {
			Context context = activityToReload.createPackageContext(activityToReload.getPackageName(), Context.CONTEXT_INCLUDE_CODE);
			Intent intent = new Intent(context, activityToReload.getClass());
			intent.putExtra(ApplicationConstantes.FLAG_INTENT_EXTCHANGE_GAME_LEVEL, level);
			activityToReload.startActivity(intent);
			activityToReload.finish();

		} catch (Exception e) {
			Log.e("Error", e.getMessage());
		}

    }
	
	public static void setLevel(Activity activityToReload ,int level) {

		try {
			Context context = activityToReload.createPackageContext(activityToReload.getPackageName(), Context.CONTEXT_INCLUDE_CODE);
			Intent intent = new Intent(context, activityToReload.getClass());
			intent.putExtra(ApplicationConstantes.FLAG_INTENT_EXTCHANGE_GAME_LEVEL, level);
			activityToReload.startActivity(intent);
			activityToReload.finish();

		} catch (Exception e) {
			Log.e("Error", e.getMessage());
		}
	}
	
	public static void createLevelChooserMenu(Menu menu, Activity currentActivity){
		int menuIdStartsAt=1000;
		
		SubMenu menuLevel = menu.addSubMenu(0, 0, 0, currentActivity.getResources().getString(R.string.menu_level));
		menuLevel.add(0, menuIdStartsAt++, 0, currentActivity.getResources().getString(R.string.menu_level_easy));
		menuLevel.add(0, menuIdStartsAt++, 0, currentActivity.getResources().getString(R.string.menu_level_medium));
		menuLevel.add(0, menuIdStartsAt, 0, currentActivity.getResources().getString(R.string.menu_level_hard));
	}
		
	public static void createLanguageChooserMenu(Menu menu, Activity currentActivity){
		int menuIdStartsAt=2000;
		SubMenu menuLang = menu.addSubMenu(0, 0, 0, currentActivity.getResources().getString(R.string.menu_lang));
		menuLang.add(0, menuIdStartsAt++, 0, currentActivity.getResources().getString(R.string.menu_lang_english));
		menuLang.add(0, menuIdStartsAt, 0, currentActivity.getResources().getString(R.string.menu_lang_french));
	}

	public static void catchLanguageChooserMenu(MenuItem item, Activity currentActivity, int level){
		switch (item.getItemId()) {
			case 1001:
				ApplicationBehaviors.setLocale(Locale.ENGLISH, currentActivity, level);
				break;
		
			case 1002:
				ApplicationBehaviors.setLocale(Locale.FRANCE, currentActivity, level);
				break;
		}
	
	}
	
	public static void catchLevelChooserMenu(MenuItem item, Activity currentActivity){
		switch (item.getItemId()) {
			case 2001:
				ApplicationBehaviors.setLevel(currentActivity,ApplicationConstantes.FLAG_GAME_LEVEL_EASY);
				break;
		
			case 2002:
				ApplicationBehaviors.setLevel(currentActivity,ApplicationConstantes.FLAG_GAME_LEVEL_MEDIUM);
				break;
		
			case 2003:
				ApplicationBehaviors.setLevel(currentActivity,ApplicationConstantes.FLAG_GAME_LEVEL_HARD);
				break;
			}
	}
	
}
