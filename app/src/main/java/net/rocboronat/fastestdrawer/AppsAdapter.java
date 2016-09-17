package net.rocboronat.fastestdrawer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.ViewHolder> {
  private List<InstalledApp> apps;

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public TextView name;

    public ViewHolder(TextView v) {
      super(v);
      name = v;
    }
  }

  public AppsAdapter(List<InstalledApp> apps) {
    this.apps = apps;
  }

  @Override
  public AppsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app, parent, false);
    TextView name = (TextView) v.findViewById(R.id.app_name);
    ViewHolder vh = new ViewHolder(name);
    return vh;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.name.setText(apps.get(position).getName());
  }

  @Override
  public int getItemCount() {
    return apps.size();
  }
}