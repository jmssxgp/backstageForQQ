package com.program.qq.Controller;

import com.program.qq.Util.imageRename;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.function.ServerResponse;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author xgp
 * @version 1.0
 * @date 2019/11/21 15:19
 */
@RestController
public class imageReceiveController {

    @PostMapping("/uploadImage")
    public String uploadImage(HttpServletRequest request, String preName) throws IOException{
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile file = req.getFile("file");
        String name = imageRename.name(preName);
        String realPath = "D:/icon";
        try {
            File dir = new File(realPath);
            if(!dir.exists()){
                dir.mkdir();
            }
            File f = new File(realPath, name);
            file.transferTo(f);
        }catch (IOException e){
            e.printStackTrace();
        }catch (IllegalStateException e){
            e.printStackTrace();
        }
        return name;
    }
}
