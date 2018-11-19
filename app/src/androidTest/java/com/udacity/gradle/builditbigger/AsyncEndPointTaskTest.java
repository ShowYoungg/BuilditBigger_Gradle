package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.util.Log;

import com.example.android.showmyjokes.ShowJokes;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by SHOW on 11/18/2018.
 */

@RunWith(AndroidJUnit4.class)
public class AsyncEndPointTaskTest {

    @Test
    public void AsyncTaskTest() throws Exception {

        Context context = InstrumentationRegistry.getContext();

        assertTrue(true);
        final CountDownLatch signal = new CountDownLatch(1);
        AsyncEndPointTask asyncEndPointTask = new AsyncEndPointTask(){
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                if (result != null){
                    assertTrue(result.length() > 0);
                    signal.countDown();
                }
            }
        };
        asyncEndPointTask.execute(context);
        signal.await();
    }
}