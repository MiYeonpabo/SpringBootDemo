package com.UploadFile;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author guanzhiding
 * @date 2021/1/13 17:09
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e, RedirectAttributes attributes) {
        attributes.addFlashAttribute("message", e.getCause().getMessage());
        return "redirect:uploadStatus";
    }
}
