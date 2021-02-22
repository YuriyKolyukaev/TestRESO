package ru.kolyukaev.testreso.view;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.SingleStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;
import ru.kolyukaev.testreso.data.model.Office;

@StateStrategyType(value = SingleStateStrategy.class)
public interface OfficeListView extends MvpView {

    void showOffices(List<Office> offices);
    void showError(String text);
}
