package hu.progmatic.rockpaperscissors.controller;

import hu.progmatic.rockpaperscissors.service.Game;
import hu.progmatic.rockpaperscissors.service.UserInput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {

    Game game = new Game();

    @GetMapping({"", "/", "/homePage"})
    public String getHome(Model model) {
        model.addAttribute("input", new UserInput());
        model.addAttribute("game", game);
        return "homePage";
    }
    @PostMapping("/play")
    public String choose(@ModelAttribute("input") UserInput input) {
        game.useChoice(input.getChoice());
        if (game.isEnd()) {
            return "redirect:/gameEnd";
        } else {
            return "redirect:/homePage";
        }
    }

    @GetMapping("/gameEnd")
    public String gameEnd(Model model) {
        model.addAttribute("message", game.isEnd() ? "noob" : "gg");
        return "gameEnd";
    }

    @PostMapping("/new_game")
    public String newGame(){
        game = new Game();
        return "redirect:/homePage";
    }

}
