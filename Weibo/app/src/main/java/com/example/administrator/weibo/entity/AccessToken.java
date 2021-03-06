package com.example.administrator.weibo.entity;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.concurrent.TimeUnit;

/**
 * Created by ZZB on 2016/3/29.
 */
public class AccessToken {
    @Expose
    @SerializedName("access_token")
    public String token;//用于调用access_token，接口获取授权后的access token
    @Expose
    @SerializedName("expires_in")
    public long expiresIn;//access_token的生命周期，单位是秒数

    public long expiresTime;//具体过期时间点,单位是毫秒

    public boolean isValid(){
        long leftMillis = expiresTime - System.currentTimeMillis();
        Log.i("AccessToken", "过期时间还剩：" + TimeUnit.MILLISECONDS.toMinutes(leftMillis) + "分");
        return leftMillis > 0;
    }

    public String getToken() {
        return token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public long getExpiresTime() {
        return expiresTime;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public void setExpiresTime(long expiresTime) {
        this.expiresTime = expiresTime;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "token='" + token + '\'' +
                ", expiresIn=" + expiresIn +
                ", expiresTime=" + expiresTime +
                '}';
    }
}
