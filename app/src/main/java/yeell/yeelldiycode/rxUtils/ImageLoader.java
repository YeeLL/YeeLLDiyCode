package yeell.yeelldiycode.rxUtils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * 图片加载工具类
 * Created by YeeLL on 11/24/16.
 */

public class ImageLoader {

    private static ImageLoader mInstance;

    public static ImageLoader getInstance() {
        if (mInstance == null) {
            mInstance = new ImageLoader();
        }
        return mInstance;
    }


    public void loadImage(ImageView imageView, String url, Context context) {
        if (TextUtils.isEmpty(url)) {
            return;
        }

        Glide.with(context).load(url).into(imageView);

    }

    public void loadImage(ImageView imageView, String url, Activity context) {
        if (TextUtils.isEmpty(url)) {
            return;
        }

        Glide.with(context).load(url).into(imageView);

    }

    public void loadImage(ImageView imageView, String url, Fragment context) {
        if (TextUtils.isEmpty(url)) {
            return;
        }

        Glide.with(context).load(url).into(imageView);
    }

    public void loadWithAndHeightImage(int with, int height, String url, ImageView imageView, Context context) {
        if (TextUtils.isEmpty(url)) {
            return;
        }

        Glide.with(context).load(url).override(with, height).into(imageView);
    }


}
