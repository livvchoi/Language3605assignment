package com.example.language3605;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressDialogHelper {

    private final ProgressDialog pd;

    private final Context context;

    public ProgressDialogHelper(Context context) {
        this.context = context;
        pd = new ProgressDialog(context);
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);
    }

    public void show(String title, String msg) {
        if (pd != null && !pd.isShowing()) {
            pd.setTitle(title);
            pd.setMessage(msg);
            pd.show();
        }
    }

    public void dismiss() {
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
    }
}
