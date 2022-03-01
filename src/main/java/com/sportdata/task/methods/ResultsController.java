package com.sportdata.task.methods;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultsController {
    @RequestMapping("/bestMatches")
    public String getBestMatches(@RequestParam int eventsNum) {

        return ResultsAnalysis.getBestMatches(eventsNum);
    }
}
