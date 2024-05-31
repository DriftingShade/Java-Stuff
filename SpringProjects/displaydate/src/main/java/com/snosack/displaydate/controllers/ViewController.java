package com.snosack.displaydate.controllers;

import com.snosack.displaydate.model.DateTimeModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ViewController {

    @GetMapping("/")
    public String index() {
        return "index.jsp";
    }

    @GetMapping("/date")
    public String date(Model model) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(new Date());

        model.addAttribute("formattedDate", formattedDate);

        return "date.jsp";
    }

    @GetMapping("/time")
    public String time(Model model) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = timeFormat.format(new Date());

        model.addAttribute("formattedTime", formattedTime);

        return "time.jsp";
    }
}
