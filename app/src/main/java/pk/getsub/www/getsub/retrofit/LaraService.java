package pk.getsub.www.getsub.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by hp on 12/30/2017.
 */

public interface LaraService {
    @POST("userlogin")
    Call<UserPojo> saveUser(@Body UserPojo u);
}
