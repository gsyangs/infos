package com.app.mvvm_jetpack.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/**
 * @author:create by ys
 * 时间:2021/6/29 14
 * 邮箱 894417048@qq.com
 */
public class BaseLiveDataBus {

    private final Map<String, MyMutableLiveData<Object>> bus;

    public BaseLiveDataBus() {
        this.bus = new HashMap<>();
    }

    public static class SingleHolder{
        private static final BaseLiveDataBus DATA_BUS = new BaseLiveDataBus();
    }

    /**
     * 使用单利获取唯一对象实体
     * @return
     */
    public static BaseLiveDataBus getInstance(){
        return BaseLiveDataBus.SingleHolder.DATA_BUS;
    }

    /**
     * 将liveData添加到map中统一管理 实现跨界面数据通讯
     * @param key
     * @param t
     * @param <T>
     * @return
     */
    public <T> MyMutableLiveData<T> with(String key, Class<T> t){
        if (!bus.containsKey(key)){
            bus.put(key,new MyMutableLiveData<Object>());
        }
        return (MyMutableLiveData<T>) bus.get(key);
    }

    /**
     * 绑定
     * @param target
     * @return
     */
    public MyMutableLiveData<Object> with(String target){
        return with(target,Object.class);
    }

    /**
     * 移除对应数据
     * @param key
     */
    public void remove(String key){
        if (bus.containsKey(key)){
            bus.remove(key);
        }
    }

    /**
     * 封装一个livedata 通过反射机制对mlastversion 进行修改 解决先创建 set 后没有注册导致的粘性事件
     * mlastversion -> observer = iterator.next.getValue() -> livedata.mobservers -> livedata
     * 反射先找到livedata
     * Livedata -> mobservers -> iterator.next.getValue -> observer  -> mlastversion
     * @param <T>
     */
    public static class MyMutableLiveData<T> extends MutableLiveData<T> {
        @Override
        public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
            super.observe(owner, observer);
            try {
                hook(observer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void hook(Observer observer) throws Exception{
            Class<LiveData> classLiveData = LiveData.class;
            Field fieldObservers = classLiveData.getDeclaredField("mObservers");
            fieldObservers.setAccessible(true);
            Object mObservers = fieldObservers.get(this);
            Class<?> classObservers = mObservers.getClass();

            Method methodGet = classObservers.getDeclaredMethod("get",Object.class);
            methodGet.setAccessible(true);
            Object entry = methodGet.invoke(mObservers,observer);
            Object objectWrapper = ((Map.Entry)entry).getValue();
            Class<?> mObserver = objectWrapper.getClass().getSuperclass();

            Field mLastVersion = mObserver.getDeclaredField("mLastVersion");
            mLastVersion.setAccessible(true);
            Field mVersion = classLiveData.getDeclaredField("mVersion");
            mVersion.setAccessible(true);
            Object mVersionValue = mVersion.get(this);
            mLastVersion.set(objectWrapper,mVersionValue);

        }
    }
}