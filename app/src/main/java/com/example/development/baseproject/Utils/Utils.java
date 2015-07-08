package com.example.development.baseproject.Utils;

import android.content.Context;
import android.content.res.TypedArray;

import com.example.development.baseproject.R;

public class Utils {

    public Utils() {
    }

    public static int getToolbarHeight(Context context) {
        final TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
                new int[]{R.attr.actionBarSize});
        int toolbarHeight = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();

        return toolbarHeight;
    }

    public static int getTabsHeight(Context context) {
        return (int) context.getResources().getDimension(R.dimen.tabsHeight);
    }

    public static int getScrollingHeight(Context context) {
        return (int) context.getResources().getDimension(R.dimen.add_item_view_height);
    }
}
