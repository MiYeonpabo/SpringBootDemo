package com.Sources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author guanzhiding
 * @date 2020/12/24 16:29
 */
@Component
public class HelloProperties {
    @Value("${com.demo.title}")
    private String title;

    @Value("${com.demo.description}")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
