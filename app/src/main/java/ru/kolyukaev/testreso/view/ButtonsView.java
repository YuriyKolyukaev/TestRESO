package ru.kolyukaev.testreso.view;


import moxy.MvpView;
import moxy.viewstate.strategy.SingleStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = SingleStateStrategy.class)
public interface ButtonsView extends MvpView {
    void init();
    void getRegion(double lat, double lon);
    void regionReceived(int regionNumber);
    void showError(String text);

}
