package com.jio.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.io.StringWriter;

@RestController
@Slf4j
public class SampleController {

    @GetMapping(value = "/home", produces= MediaType.APPLICATION_JSON_VALUE)
    public SampleMessage sampleController() {
        SampleMessage response = SampleMessage
                .builder()
                .message("Successfully retrieved ")
                .data("This is sample output")
                .build();
        log.info("Home rest endpoint is called", response);

        return response;
    }

    @GetMapping(value = "/exception")
    public String exception() {
        String response = "";
        try {
            throw new Exception("Exception has occured....");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("",   e);

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            log.error("Exception - " + stackTrace);
            response = stackTrace;
        }

        return response;
    }
}
