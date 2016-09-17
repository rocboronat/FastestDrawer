package net.rocboronat.fastestdrawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private MainPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ResolveInfoMapper mapper = new ResolveInfoMapper();
    InstalledAppsLoader installedAppsLoader = new InstalledAppsLoader(this, mapper);
    presenter = new MainPresenter(this, installedAppsLoader);
    presenter.onCreate();
  }

  public void refreshApps(List<InstalledApp> apps) {
    Toast.makeText(this, "Apps loaded", Toast.LENGTH_SHORT).show();
  }
}
