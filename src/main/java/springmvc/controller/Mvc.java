package springmvc.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class Mvc {

    // http://localhost:8080/springmvc_test/mvc/hello?name=xiaoying
    // 跳转到hello.jsp页面
    @RequestMapping(value = "mvc/hello", method = {RequestMethod.POST, RequestMethod.GET})
    public String hello(HttpServletRequest request, Model model, @RequestParam(value = "name", required = false) String name) {
        if (name == null) {
            model.addAttribute("name", "no param");
        } else {
            model.addAttribute("name", name);
        }
        return "hello";
    }

    // http://localhost:8080/springmvc_test/mvc/ajax
    // 返回json数据(使用ajax进行访问请求)
    @RequestMapping(value = "mvc/ajax/{name}", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Map<String, String> json(@PathVariable("name") String name) {
        Map<String, String> data = new HashMap<String, String>();
        data.put("a", "aa");
        data.put("b", "bb");
        data.put("c", "cc");
        if (name == null) {
            System.out.println("null");
        } else {
            System.out.println(name);
        }
        return data;
    }

    // 文件上传功能
    @RequestMapping(value = "mvc/upload", method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest req) throws Exception {

        // 可以设置上传大小
        if (file.getSize() > 0) {
            String fileName = file.getOriginalFilename();
            // 限制上传格式
            if (fileName.endsWith(".png") || fileName.endsWith("gif") || fileName.endsWith("jpg")) {
                String path = "/Users/apple/Downloads/applesystem/springmvc_test/upload";
                File targetFile = new File(path, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                file.transferTo(targetFile);
            }
        } else {
            return "failure";
        }

        return "hello";
    }


    // 多文件上传功能
    @RequestMapping(value = "mvc/multiUpload", method = RequestMethod.POST)
    public String multiUpload(@RequestParam(value = "file", required = false) MultipartFile[] uploadFile, HttpServletRequest req)
            throws Exception {

        for (MultipartFile item : uploadFile) {
            String fileName = item.getOriginalFilename();
            if (fileName.endsWith(".png") || fileName.endsWith("gif") || fileName.endsWith("jpg")) {
                String path = "/Users/apple/Downloads/applesystem/springmvc_test/upload";
                File targetFile = new File(path, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                item.transferTo(targetFile);
            }
        }
        return "hello";
    }


}
