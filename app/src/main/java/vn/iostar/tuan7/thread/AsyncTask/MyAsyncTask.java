package vn.iostar.tuan7.thread.AsyncTask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import vn.iostar.tuan7.R;

public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {
    Activity contextParent;

    // Tạo constructor
    public MyAsyncTask(Activity contextParent) {
        this.contextParent = contextParent;
    }

    // Implement Method
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Hàm này sẽ chạy đầu tiên
        Toast.makeText(contextParent, "Bắt đầu", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 0; i <= 100; i++) {
            SystemClock.sleep(100);
            publishProgress(i); // Gửi tiến trình đến onProgressUpdate
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        ProgressBar progressBar = contextParent.findViewById(R.id.prbDemo);
        TextView textView = contextParent.findViewById(R.id.txtStatus);

        int number = values[0]; // Lấy giá trị từ doInBackground
        progressBar.setProgress(number);
        textView.setText(number + " %");
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        // Hàm này được thực hiện khi tiến trình kết thúc
        Toast.makeText(contextParent, "Đã hoàn thành", Toast.LENGTH_SHORT).show();
    }
}
