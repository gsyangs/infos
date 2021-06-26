package com.app.mvvm_jetpack.ui.activity.main;

import android.os.Bundle;

import com.app.baselib.base.BaseActivity;
import com.app.mvvm_jetpack.R;

public class MainActivity extends BaseActivity {

    //    public static final String BASE_URL = "https://api.apiopen.top/";
    //    /**
    //     * 获取图片资源
    //     * @param params
    //     * @return
    //     */
    //    @FormUrlEncoded
    //    @POST("getImages")
    //    Observable<BaseResponse<List<ImageBo>>> getImages(@FieldMap Map<String,Object> params);
    //
    //    /**
    //     * 获取咨询列表
    //     */
    //    @FormUrlEncoded
    //    @POST("getWangYiNews")
    //    Observable<BaseResponse<List<InfosBo>>> getWangYiNews(@FieldMap Map<String,Object> params);
    //  map.put("page","2");
    //        map.put("count","20");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}