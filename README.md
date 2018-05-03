# RetrofitTutifruti
## Practice app for Retrofit. 
RetrofitTutifruti uses two methods to handle threading:
* Retrofit with Callbacks - Basic. It uses retrofit's own implementation of threading
* Retrofit and RxAndroid - RxJava is reactive programming. the networking is handled by an Observer in a working thread.

Note:
just in case you do not know it: Android does not allow network activity on the UI Thread. That would leave a slow, irresponsive UI. You should always use a background work thread to do that heavy process, leaving the UI responsive, clean and rosy.

## Other niceties:
I dunno of other.

## Luis Virueña!
