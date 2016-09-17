package net.rocboronat.fastestdrawer;

import java.util.List;

public class MainPresenter {

  private final MainActivity activity;
  private final InstalledAppsLoader installedAppsLoader;

  public MainPresenter(MainActivity activity, InstalledAppsLoader installedAppsLoader) {
    this.activity = activity;
    this.installedAppsLoader = installedAppsLoader;
  }

  public void onCreate() {
    requestApps();
  }

  private void requestApps() {
    List<InstalledApp> installedApps = installedAppsLoader.getInstalledApps();
    activity.refreshApps(installedApps);
  }
}
