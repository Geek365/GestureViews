package com.alexvasilkov.gestures.sample.items;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import com.alexvasilkov.gestures.widgets.GImageView;
import com.squareup.picasso.Picasso;

public class PaintingsAdapter extends PagerAdapter {

    private final ViewPager mViewPager;
    private final Painting[] mPaintings;

    public PaintingsAdapter(ViewPager pager, Painting[] paintings) {
        mViewPager = pager;
        mPaintings = paintings;
    }

    @Override
    public int getCount() {
        return mPaintings.length;
    }

    @Override
    public View instantiateItem(final ViewGroup container, int position) {
        Context context = container.getContext();

        GImageView viewer = new GImageView(context);
        container.addView(viewer, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        viewer.fixViewPagerScroll(mViewPager);

        Picasso.with(context).load(mPaintings[position].getImageId()).into(viewer);

        return viewer;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
