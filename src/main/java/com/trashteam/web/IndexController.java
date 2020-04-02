package com.trashteam.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//시작페이지 URL 매핑 컨트롤러
@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/save")
    public String idCardSave(){
        return "idCard-save";
    }
}