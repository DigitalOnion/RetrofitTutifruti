# RetrofitTutifruti
## Practice app for Retrofit. 
RetrofitTutifruti uses thee techniques to handle threading:
(just in case you do not know: in Android you cannot and should not call the network on the UI Thread. You should always use a background work thread to do that heavy process, leaving the UI responsive, clean and rosy. 
* Retrofit with Callbacks - Basic. It uses retrofit's own implementation of threading
* Retrofit on AsyncTask - it creates an AsyncTask to handle threading, more control
* Retrofit and RxAndroid - RxJava is reactive programming. the networking is handled by an Observer in a working thread.

## Other niceties:
I dunno of other.

## Luis Virueña!
