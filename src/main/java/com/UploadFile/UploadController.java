package com.UploadFile;

import com.FastDFS.FastDFSClient;
import com.FastDFS.FastDFSFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.InputStream;

/**
 * @author guanzhiding
 * @date 2021/1/13 16:57
 */
@Controller
public class UploadController {

    private static Logger logger = LoggerFactory.getLogger(UploadController.class);
    private static String UPLOADED_FOLDER = "D:\\temp\\";


    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @RequestMapping("/deleteFile")
    public String deleteFile(@ModelAttribute("message") String message, RedirectAttributes redirectAttributes) throws Exception {
        FastDFSClient.deleteFile("group1", "M00/00/00/rBKWQmAH0CSAReDVAAGLAwEefYo190.jpg");
        redirectAttributes.addFlashAttribute("message", "deleteFile!");
        return "redirect:uploadStatus";
    }

    @RequestMapping("/downFile")
    public String downFile(@ModelAttribute("message") String message, RedirectAttributes redirectAttributes) throws Exception {
        InputStream inputStream = FastDFSClient.downFile("group1", "M00/00/00/rBKWQmAH0CSAReDVAAGLAwEefYo190.jpg");
        redirectAttributes.addFlashAttribute("message", "ddownFile:" + inputStream.available());
        return "redirect:uploadStatus";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile multipartFile, RedirectAttributes redirectAttributes) {
        if (multipartFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload!");
            return "redirect:uploadStatus";
        }
        try {
            //普通上传
            //byte[] bytes = multipartFile.getBytes();
            //Path path = Paths.get(UPLOADED_FOLDER + multipartFile.getOriginalFilename());
            //Files.write(path, bytes);
            //FastDFS上传
            String path = saveFile(multipartFile);
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded :" + multipartFile.getOriginalFilename()
                    + "file path url:'" + path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:uploadStatus";
    }

    public String saveFile(MultipartFile multipartFile) throws Exception {
        String[] filePath = {};
        String fileName = multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] file_buff = null;
        InputStream inputStream = multipartFile.getInputStream();
        if (null != inputStream) {
            int len = inputStream.available();
            file_buff = new byte[len];
            inputStream.read(file_buff);
        }
        inputStream.close();
        FastDFSFile fastDFSFile = new FastDFSFile(fileName, file_buff, ext);
        try {
            filePath = FastDFSClient.uploadFile(fastDFSFile);
        } catch (Exception e) {
            logger.error("upload file Exception!", e);
        }
        if (filePath == null) {
            logger.error("upload file failed,please upload again!");
        }
        String path = FastDFSClient.getTrackerUrl() + filePath[0] + "/" + filePath[1];
        return path;
    }

    @RequestMapping("/uploadStatus")
    public String upStatus(@ModelAttribute("message") String message) {
        return "uploadStatus";
    }

}
