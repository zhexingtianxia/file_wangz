package com.baizhi.controller;

import com.baizhi.entity.Document;
import com.baizhi.entity.User;
import com.baizhi.service.DocumentService;
import com.baizhi.service.UserService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("document")
@SessionAttributes({"documents","login"})
public class DocumentController {
    @Autowired
    private DocumentService documentService;
    @Autowired
    private UserService userService;

    @RequestMapping("queryAll")
    public String queryAll(String id, ModelMap map){
        List<Document> documents = documentService.queryAll(id);
        if(documents!=null) {
            map.addAttribute("documents", documents);
        }
        return "showAllFiles";
    }

    @RequestMapping("upload")
    public String upload(MultipartFile aaa, HttpServletRequest request,ModelMap map) throws IOException {

        //将文件放入服务器指定位置
        String realPath = request.getSession().getServletContext().getRealPath("/files");
        //将接收的文件放入服务器中指定位置
        String formatDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //如果文件夹不存在则创建
        File f = new File(realPath+"/"+formatDate+"/"+ aaa.getOriginalFilename());
        if(!f.exists()){
            f.mkdirs();
        }
        aaa.transferTo(f);

        Document document = new Document();

        //设置id
        document.setId(UUID.randomUUID().toString());

        //设置原始名
        aaa.getOriginalFilename();
        document.setOriginalName(aaa.getOriginalFilename());

        String extension = FilenameUtils.getExtension(aaa.getOriginalFilename());
        //设置新名
        String newName = UUID.randomUUID().toString().replace("-","")+"."+extension;
        document.setNewName(newName);
        //设置后缀
        document.setExtension(extension);
        //设置存储路径名
        document.setStoragePath(realPath+"/"+formatDate);

        //设置大小
        Double size = (double)aaa.getSize()/1024;
        document.setFileSize(size);

        //设置类型
        String type = aaa.getContentType();
        System.out.println(type);
        document.setFileType(type);

        //设置是否为图片
        if(extension.equalsIgnoreCase("image")){
            document.setIsImage("是");
        }else if(extension.equalsIgnoreCase("jpg")){
            document.setIsImage("是");
        }else if(extension.equalsIgnoreCase("png")){
            document.setIsImage("是");
        }else if(extension.equalsIgnoreCase("bmp")){
            document.setIsImage("是");
        }
        else{
            document.setIsImage("否");
        }

        //设置下载次数
        document.setDownloadTimes(0);

        //设置用户id
        User login = (User) map.get("login");
        User user = userService.queryByUsername(login);
        document.setUserId(user.getId());


        documentService.add(document);
        return "redirect:/document/queryAll?userId="+login.getId();
    }

    //用来测试文件下载
    @RequestMapping("/download")
    public void download(String name, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //0.根据相对路径获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/files");
        //1.根据获取的文件名读取指定目录中文件
        FileInputStream is = new FileInputStream(new File(realPath, name));

        //1.5 指定浏览器以附件形式下载  inline: 默认值 在线打开  attachment: 附件
        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode(name,"UTF-8"));
        //1.8动态获取文件类型
        String extension = FilenameUtils.getExtension(name);//获取文件名后缀 没有"."
        String contentType = request.getSession().getServletContext().getMimeType("."+extension);
        System.out.println("动态获取文件类型: "+contentType);
        response.setContentType(contentType);

        //2.获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //3.文件拷贝   1028
        int len = 0;
        byte[] b = new byte[1024];
        while (true){
            len = is.read(b);
            if (len==-1)break;
            os.write(b,0,len);
        }
        is.close();
        os.close();
    }



}
