package pk.getsub.www.getsub.retrofit;

import okhttp3.ResponseBody;
import pk.getsub.www.getsub.UserSharPrefer;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by hp on 12/30/2017.
 */

public interface LaraService {
    @POST("userlogin")
    Call<UserPojo> saveUser(@Body UserPojo u);




    @PUT("userlogin/{id}")
    Call<UserPojo> updateUser(@Path("id") int id, @Body UserPojo u);

    @GET("userlogin/{id}")
    Call<UserPojo> getUser(@Path("id") String phone);


}