package com.sanket.portfolio.controller;

import com.sanket.portfolio.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;
import org.json.JSONException;

@RestController
@RequestMapping("/email")
public class FormController {

    @Autowired
    private EmailService emailService;

    @CrossOrigin
    @PostMapping("/send")
    public String sendMail(@RequestBody String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);

            // Accessing values from the JSON object
            String name = jsonObject.getString("name");
            String email = jsonObject.getString("email");
            String subject = jsonObject.getString("subject");
            String message = jsonObject.getString("message");
            emailService.sendEmail("sanketsonone11@gmail.com", subject, (message + "\n\n\n" + "Additional Details : \n" + name + '\n' + email + '\n'));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "Email sent";
    }
}
