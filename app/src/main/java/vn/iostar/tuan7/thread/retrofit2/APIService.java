package vn.iostar.tuan7.thread.retrofit2;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import vn.iostar.tuan7.thread.retrofit2.Category;

public interface APIService {
    @GET("categories.php")
    Call<List<Category>> getCategoryAll();
}
