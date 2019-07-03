package com.hanzone.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author Hanzone
 * @date 2019年07月03日
 */
@Controller
@Slf4j
public class HelloController {

    @GetMapping("/hello")
    public String test(Model model) {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("+8"));
        String dateTime = formatDateTime(now, "yyyy-MM-dd HH:mm:ss");
        log.info("this is hello visiting...at: " + dateTime);
        model.addAttribute("visitTime", dateTime);
        model.addAttribute("greetings", getGreetings(now));
        return "hello";
    }

    private String getGreetings(LocalDateTime now) {

        int hour = now.getHour();
        if (hour <= 5) {
            return "Good night ~";
        } else if (hour <= 11) {
            return "Good morning ~";
        } else if (hour <= 18) {
            return "Good afternoon ~";
        } else {
            return "Good evening ~";
        }
    }

    private static String formatDateTime(LocalDateTime time, String format) {
        return time == null ? null : DateTimeFormatter.ofPattern(format).format(time);
    }

}
