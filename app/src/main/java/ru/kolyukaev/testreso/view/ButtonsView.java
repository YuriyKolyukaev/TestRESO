package ru.kolyukaev.testreso.view;


import moxy.MvpView;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = OneExecutionStateStrategy.class)
public interface ButtonsView extends MvpView {
    void findLocation();
    void getRegion(double lat, double lon);
    void regionReceived(int regionNumber);
    void showError(String text);

}
