package ru.kolyukaev.testreso.view.fragments;

import android.os.Bundle;
import android.util.Log;

import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;
import ru.kolyukaev.testreso.presenter.ButtonsPresenter;

abstract class BaseFragment extends MvpAppCompatFragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("kyus","OnCreate");


    }
}
