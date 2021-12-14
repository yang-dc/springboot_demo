package com.test.controller;

import com.baidu.ueditor.ActionEnter;
import com.test.service.UeditorService;
import com.test.vo.Result;
import com.test.vo.UeditorVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@Log4j2
public class UeditorController {

    @Autowired
    private UeditorService ueditorService;

    @GetMapping("/index")
    public String  helloUeditor() {
        return "index";
    }

    @RequestMapping(value="/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println("rootPath = " + rootPath);
        try {
            String exec = new ActionEnter(request, rootPath +"jsp/", "config.json").exec();
            System.out.println("exec = " + exec);
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @PostMapping("/addContent")
    public Result addBody(@RequestBody UeditorVo ueditorVo) {
        log.info(" 【UeditorController==>addContent请求: {}", ueditorVo, " 】");
        return ueditorService.addBody(ueditorVo);
    }

    @ResponseBody
    @GetMapping("/queryContentById")
    public Result queryContentById(@RequestParam("contentKey") String contentKey) {
        log.info("【UeditorController==>queryContentById：{}",contentKey, "】");
        return ueditorService.queryContentById(contentKey);
    }

    @ResponseBody
    @PostMapping("/queryCntentList")
    public Result queryCntentList() {
        return ueditorService.queryCntentList();
    }
}
