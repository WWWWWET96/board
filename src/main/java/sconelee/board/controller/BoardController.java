package sconelee.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sconelee.board.dto.BoardDto;
import sconelee.board.service.BoardService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("")
    public String list(Model model){
        /*
        repository-serivce: entity
        controller-service: dto
        controller-view: moodel
        로 데이터 주고받음  따라서 각 단에서 매핑 필요한 것
         */
        List<BoardDto> boardDtoList = boardService.getBoardList();
        model.addAttribute("postList",boardDtoList);
        return "board/list";
    }

    @GetMapping("post")
    public String post(){

        return "board/post";
    }

    @PostMapping("post")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }

    @GetMapping("post/{id}")
    public String detail(@PathVariable("id") Long id, Model model){
        BoardDto boardDto = boardService.getPost(id);
        model.addAttribute("post", boardDto);
        return "board/detail";
    }
}
