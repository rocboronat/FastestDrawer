package net.rocboronat.fastestdrawer;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import java.util.ArrayList;
import java.util.List;

public class InstalledAppsLoader {

  private final Context context;
  private final ResolveInfoMapper mapper;

  public InstalledAppsLoader(Context context, ResolveInfoMapper mapper) {
    this.context = context;
    this.mapper = mapper;
  }

  public List<InstalledApp> getInstalledApps() {
    Intent intent = new Intent(Intent.ACTION_MAIN, null);
    intent.addCategory(Intent.CATEGORY_LAUNCHER);

    List<ResolveInfo> installedApps = context.getPackageManager().queryIntentActivities(intent, 0);

    List<InstalledApp> result = new ArrayList<>(installedApps.size());
    for (ResolveInfo resolveInfo : installedApps) {
      result.add(mapper.toInstalledApp(resolveInfo));
    }
    return result;
  }
}
