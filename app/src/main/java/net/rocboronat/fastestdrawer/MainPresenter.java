package net.rocboronat.fastestdrawer;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter {

  private final MainActivity activity;

  public MainPresenter(MainActivity activity) {
    this.activity = activity;
  }

  public void onCreate() {
    requestApps();
  }

  private void requestApps() {
    List<App> apps = new ArrayList<>();
    apps.add(new App("QuitNow!"));
    apps.add(new App("Vicing"));
    apps.add(new App("Car Station"));
    activity.refreshApps(apps);
  }
}
