package com.UploadFile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author guanzhiding
 * @date 2021/1/13 16:57
 */
@Controller
public class UploadController {

    private static String UPLOADED_FOLDER = "D:\\temp\\";

    @RequestMapping("/uploadStatus")
    public String upStatus(@ModelAttribute("message") String message) {
        return "uploadStatus";
    }

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile multipartFile, RedirectAttributes redirectAttributes) {
        if (multipartFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload!");
            return "redirect:uploadStatus";
        }
        try {
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + multipartFile.getOriginalFilename());
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + multipartFile.getOriginalFilename() + "!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:uploadStatus";
    }
}
