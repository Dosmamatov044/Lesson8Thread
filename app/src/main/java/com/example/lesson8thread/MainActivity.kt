package com.example.lesson8thread


import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.annotation.RequiresApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit




//Сделать с flowable также как с остальными тоесть указать в каком потоке он должен работаь и перепопределить методы также сделать так чтобы оно не вылетала ищ системы если памяти мало остаенться в оперативке за счет удаление старых элмементов
class MainActivity : AppCompatActivity() {
    @SuppressLint("CheckResult")
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


val list= listOf<String>("job","job","rain")



      //  fun getApi():Observable<String>{}

        //   getApi().subscribe {


     //   }
       // Schedulers.io()





  // val flowable=Flowable.fromArray(list)



            Observable.fromArray(list).subscribeOn(Schedulers.io()).observeOn(
                AndroidSchedulers.mainThread()).map {

                val list1= mutableListOf<String>()

                it.forEach {
                    list1.add(it+")009")
                }
                list1

            }.distinct().take(3).skip(2)
                .subscribe(object :Observer<List<String>>{
                    override fun onSubscribe(d: Disposable) {}

                    override fun onError(e: Throwable) {



                    }

                    override fun onComplete() {}

                    override fun onNext(t: List<String>) {
                    }


                })










        Single.just(list).subscribeOn(Schedulers.io()).observeOn(
            AndroidSchedulers.mainThread()).


        subscribe(object :SingleObserver<List<String>>{
            override fun onSubscribe(d: Disposable) {

                d.dispose()

            }

            override fun onError(e: Throwable) {

            }

            override fun onSuccess(t: List<String>) {



            }


        })





        val maybe= Maybe.just(list)



        maybe.subscribeOn(Schedulers.io())


            .observeOn(AndroidSchedulers.mainThread()).subscribe(object :
                MaybeObserver<List<String>> {
                override fun onSubscribe(d: Disposable) {
                    TODO("Not yet implemented")
                }

                override fun onError(e: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onComplete() {
                    TODO("Not yet implemented")
                }

                override fun onSuccess(t: List<String>) {
                    TODO("Not yet implemented")
                }


            })

















    }
}