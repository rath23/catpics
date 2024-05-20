package com.mycompany.catpics.Controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.catpics.Service.CatPicService;

@Controller
public class ImgController {
    private final CatPicService catPicService;

    public ImgController(CatPicService catPicService){
        this.catPicService = catPicService;
    }

      @GetMapping("/")
    public String index() {
        return "index"; 
    }

    @GetMapping("/cat")
    @ResponseBody
    public String getCatPicData() {
        return catPicService.CapPicUrl(); 
    }
}
