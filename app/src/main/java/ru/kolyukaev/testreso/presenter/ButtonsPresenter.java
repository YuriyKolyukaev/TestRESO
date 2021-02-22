package ru.kolyukaev.testreso.presenter;


import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.kolyukaev.testreso.data.providers.ButtonsProvider;
import ru.kolyukaev.testreso.view.ButtonsView;

@InjectViewState
public class ButtonsPresenter extends MvpPresenter<ButtonsView> {

    public void loadRegion(double lat, double lon) {
        new ButtonsProvider(this).loadingRegion(lat, lon);
    }

    public void loadedRegion(int region) {
        getViewState().regionReceived(region);
    }

    public void onError(String text) {
        getViewState().showError(text);
    }

}

