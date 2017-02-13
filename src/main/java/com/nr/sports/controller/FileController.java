package com.nr.sports.controller;

import com.nr.sports.utils.DB;
import com.nr.sports.utils.KeyGeneratorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by nr on 2017/02/13 0013.
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    public KeyGeneratorImpl keyGeneratorImpl;
    @Autowired
    public DB db;
    /**
     * 返回文件上传视图
     * @return
     */
    @RequestMapping("/fileUI")
    public String uploadUI(ModelMap modelMap){
        modelMap.put("files", db.getAllFile());
        return "/file/file";
    }
    /**
     * 处理文件上传
     * @param file
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("upload")
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model){
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.nr.sports.model.MyFile mode = new com.nr.sports.model.MyFile();
        try {
            mode.setId(keyGeneratorImpl.getKey());
            mode.setName(fileName);
            mode.setUrl(request.getContextPath()+"/upload/"+fileName);
            db.saveFile(mode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);
        return "redirect:/file/fileUI.html";
    }
}
