package ru.kolyukaev.testreso;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import moxy.MvpAppCompatActivity;
import ru.kolyukaev.testreso.data.model.ProgressEuroProtocol;
import ru.kolyukaev.testreso.view.fragments.ButtonsFragment;

public class MainActivity extends MvpAppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        commitFragmentTransaction(new ButtonsFragment());
    }

    public void commitFragmentTransaction(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        Fragment current = fragmentManager.findFragmentById(R.id.container);
        if (current instanceof ButtonsFragment) {
            finish();
        } else {
            super.onBackPressed();
        }
    }
}