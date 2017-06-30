package sys.ecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by My System on 6/30/2017.
 */
@Controller(value = "error")
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {
    private static final String PATH = "/error";
    @Override
    public String getErrorPath() {
        return PATH;
    }

    @GetMapping(value = PATH)
    public String error(){
        return "/404";
    }
}
