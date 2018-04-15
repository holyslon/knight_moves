package com.onikiychuk.xmexersize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class AppController {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppController.class, args);
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(BoardPosition.class, new BoardPositionEditor());
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/path/knight", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    Path[] knightPath(
            @RequestParam(value = "start") BoardPosition start,
            @RequestParam(value = "end") BoardPosition end,
            @RequestParam(value = "max_number_of_moves", required = false, defaultValue = "3") int maxNumberOfMoves
    ) {

        var figure = new KnightFigure();

        return new PathFinder(figure, maxNumberOfMoves).find(start, end);
    }
}
