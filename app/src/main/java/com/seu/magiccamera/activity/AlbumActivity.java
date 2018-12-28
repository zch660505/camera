package com.seu.magiccamera.activity;

import android.app.Activity;
import android.os.Bundle;

import com.seu.magiccamera.R;
import com.seu.magicfilter.filter.advanced.MagicBlackCatFilter;
import com.seu.magicfilter.filter.base.gpuimage.GPUImageFilter;
import com.seu.magicfilter.utils.MagicParams;
import com.seu.magicfilter.widget.MagicImageView;

/**
 * Created by why8222 on 2016/3/18.
 */
public class AlbumActivity extends Activity{

    private MagicImageView magicImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

    }
}
