package pk.getsub.www.getsub.orderfrontpageactivity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by hp on 12/30/2017.
 */

public interface OrderService {

    @POST("userorder")
    Call<OrderPojo> userOrder(@Body OrderPojo o);
}
