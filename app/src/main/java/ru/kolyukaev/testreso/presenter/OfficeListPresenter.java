package ru.kolyukaev.testreso.presenter;

import android.util.Log;

import java.util.Calendar;
import java.util.List;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.kolyukaev.testreso.data.model.Office;
import ru.kolyukaev.testreso.data.network.response.Graf;
import ru.kolyukaev.testreso.data.providers.OfficeListProvider;
import ru.kolyukaev.testreso.view.OfficeListView;

@InjectViewState
public class OfficeListPresenter extends MvpPresenter<OfficeListView> {


    public void loadOffices(int region) {
        new OfficeListProvider(this).loadingOffices(region);
    }

    public void onError(String text) {
        getViewState().showError(text);
    }

    public void onListOfficeLoaded(List<Office> offices) {

        for (Office office : offices) {
            Graf currentGraf = null;

            for (Graf graf : office.getGraf()) {
                if (graf.getNday() == getDayOfWeek()) {
                    currentGraf = graf;
                    break;
                }
            }

            if (currentGraf == null) continue;

            int startOfficeHours = getSimpleTime(currentGraf.getSbegin(), true);
            int startOfficeMinutes = getSimpleTime(currentGraf.getSbegin(), false);
            int endOfficeHours = getSimpleTime(currentGraf.getSend(), true);
            int endOfficeMinutes = getSimpleTime(currentGraf.getSend(), false);

            Calendar cal = Calendar.getInstance();
            int currentHours = cal.get(Calendar.HOUR_OF_DAY);
            int currentMinutes = cal.get(Calendar.MINUTE);

            boolean isOpen;

            if (currentHours > startOfficeHours && currentHours < endOfficeHours) {
                isOpen = true;
            } else if (currentHours == startOfficeHours) {
                isOpen = currentMinutes > startOfficeMinutes;
            } else if (currentHours == endOfficeHours){
                isOpen = currentMinutes < endOfficeMinutes;
            } else {
                isOpen = false;
            }

            office.setOpen(isOpen);
        }
        getViewState().showOffices(offices);
    }

    private String[] getTimeArrayFromGraf(String time) {
        return time.trim().split("[.–]");
    }

    private int getSimpleTime(String grafTime, boolean isHour) {
        int index = isHour ? 0 : 1;
        return grafTime.isEmpty() ? 0 : Integer.parseInt(getTimeArrayFromGraf(grafTime)[index].trim());
    }

    private int getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }
}
