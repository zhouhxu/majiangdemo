package cn.edu.hxu.majiangdemo.provider;

import cn.edu.hxu.majiangdemo.dto.AccessTokenDTO;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 作为Spring容器的上下文对象
 *
 */
@Component
public class GithubProvider {

    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        //RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
             .url("https://github.com/login/oauth/access_token")
             //.post(body)
             .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
