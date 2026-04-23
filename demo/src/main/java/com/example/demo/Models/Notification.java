package com.example.demo.Models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private String message;

    public Notification(String message){
        this.message=message;
    }
}