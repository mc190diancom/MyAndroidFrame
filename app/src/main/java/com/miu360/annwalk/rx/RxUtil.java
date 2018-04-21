package com.miu360.annwalk.rx;

import com.codeest.geeknews.model.http.exception.ApiException;
import com.codeest.geeknews.model.http.response.GankHttpResponse;
import com.codeest.geeknews.model.http.response.GoldHttpResponse;
import com.codeest.geeknews.model.http.response.MyHttpResponse;
import com.codeest.geeknews.model.http.response.WXHttpResponse;
import com.miu360.annwalk.base.BaseEntity;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by codeest on 2016/8/3.
 */
public class RxUtil {

    /**
     * 统一线程处理
     */
    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 统一返回结果处理
     */
    public static <T> FlowableTransformer<BaseEntity<T>, T> handleResult() {   //compose判断结果
        return new FlowableTransformer<BaseEntity<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<BaseEntity<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<BaseEntity<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(BaseEntity<T> baseEntity) {
                        if(baseEntity.getError() == 0) {
                            return createData(baseEntity.getResults());
                        } else {
                            return Flowable.error(new ApiException("服务器返回error"));
                        }
                    }
                });
            }
        };
    }

    /**
     * 生成Flowable
     */
    private static <T> Flowable<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }
}
