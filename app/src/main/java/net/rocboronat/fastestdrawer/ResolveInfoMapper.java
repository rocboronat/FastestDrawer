package net.rocboronat.fastestdrawer;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

public class ResolveInfoMapper {

  private final PackageManager packageManager;

  public ResolveInfoMapper(PackageManager packageManager) {
    this.packageManager = packageManager;
  }

  public InstalledApp toInstalledApp(ResolveInfo resolveInfo) {
    return new InstalledApp((String) resolveInfo.loadLabel(packageManager));
  }
}
