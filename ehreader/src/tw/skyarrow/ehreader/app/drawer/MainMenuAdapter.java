package tw.skyarrow.ehreader.app.drawer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tw.skyarrow.ehreader.R;

public class MainMenuAdapter extends BaseMenuAdapter {
    public MainMenuAdapter(MenuItem[] items) {
        super(items);
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_header, parent, false);
        HeaderViewHolder vh = new HeaderViewHolder(view);

        return vh;
    }

    @Override
    public int getHeaderItemCount() {
        return 1;
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }
}