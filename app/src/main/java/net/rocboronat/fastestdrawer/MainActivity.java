package net.rocboronat.fastestdrawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private RecyclerView appsRecyclerView;
  private AppsAdapter appsAdapter;

  private MainPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    appsRecyclerView = (RecyclerView) findViewById(R.id.apps);
    appsRecyclerView.setHasFixedSize(true);
    appsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    ResolveInfoMapper mapper = new ResolveInfoMapper(getPackageManager());
    InstalledAppsLoader installedAppsLoader = new InstalledAppsLoader(this, mapper);
    presenter = new MainPresenter(this, installedAppsLoader);
    presenter.onCreate();
  }

  public void refreshApps(List<InstalledApp> apps) {
    appsAdapter = new AppsAdapter(apps);
    appsRecyclerView.setAdapter(appsAdapter);
    Toast.makeText(this, "Apps loaded", Toast.LENGTH_SHORT).show();
  }
}
