package com.example.boundservicer;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class CounterService extends Service {
    int Counter =0;
    CountBinder countBinder = new CountBinder();
    public CounterService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
     return countBinder ;
    }

    public int getCounter()
    {
        return  ++Counter  ;
    }

    class  CountBinder extends Binder {
        public   CounterService getCounterService()
        {
            return  CounterService.this ;
        }

    }

}