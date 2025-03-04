package com.commerce.e_commerce.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@CrossOrigin(origins = "http://localhost:63342")
public class DashboardUserController
{

    @GetMapping("/dashboard")
    public boolean showDashboard() {
        return true;  // Ensure the file name is dashboard_user.html
    }
}
