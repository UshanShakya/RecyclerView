package adapter;

import android.content.Context;

public class SearchAdapter {
    Context searchContext;
    String searchValue;

    public SearchAdapter(Context searchContext, String searchValue) {
        this.searchContext = searchContext;
        this.searchValue = searchValue;
    }
}
