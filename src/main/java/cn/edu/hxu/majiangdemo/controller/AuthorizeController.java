package cn.edu.hxu.majiangdemo.controller;

import cn.edu.hxu.majiangdemo.dto.AccessTokenDTO;
import cn.edu.hxu.majiangdemo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,@RequestParam(name="state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("Iv1.f75f6f1d8e3cc58a");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_secret("b1dd34b86abec32c4cca719e620c89f5a48519c3");
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        githubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }
}
