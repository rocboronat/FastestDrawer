package net.rocboronat.fastestdrawer;

import android.content.pm.ResolveInfo;

public class ResolveInfoMapper {
  public InstalledApp toInstalledApp(ResolveInfo resolveInfo) {
    return new InstalledApp();
  }
}
