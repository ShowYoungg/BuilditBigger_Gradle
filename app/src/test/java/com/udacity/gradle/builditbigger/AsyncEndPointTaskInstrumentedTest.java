package com.udacity.gradle.builditbigger;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.android.showmyjokes.ShowJokes;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by SHOW on 11/18/2018.
 */


public class AsyncEndPointTaskInstrumentedTest {



    @Test
    public void testAsyncTask(){

        final AsyncEndPointTask asyncEndPointTask = new AsyncEndPointTask(){

            private MyApi myApiService = null;
            private Context context;

            @Override
            protected String doInBackground(Context...params) {
                if(myApiService == null) {  // Only do this once
                    MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                            new AndroidJsonFactory(), null)
                            // options for running against local devappserver
                            // - 10.0.2.2 is localhost's IP address in Android emulator
                            // - turn off compression when running against local devappserver
                            .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                            .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                                @Override
                                public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                    abstractGoogleClientRequest.setDisableGZipContent(true);
                                }
                            });
                    // end options for devappserver
                    myApiService = builder.build();
                }

                try {

                    String s = myApiService.sayHi().execute().getData();
                    Assert.assertEquals(5,s.length());
                    return myApiService.sayHi().execute().getData();
                } catch (IOException e) {
                    return e.getMessage();
                }
            }
        };
        
    }
}