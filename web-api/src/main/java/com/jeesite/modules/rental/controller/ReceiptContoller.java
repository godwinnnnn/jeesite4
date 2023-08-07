package com.jeesite.modules.rental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;
@RestController
public class ReceiptContoller {

    @RequestMapping(value = "/receipt/",method = RequestMethod.GET)
    public String getReceipt(String tid){

        return "";
    }

}
