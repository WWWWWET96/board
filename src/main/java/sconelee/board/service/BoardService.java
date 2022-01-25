package sconelee.board.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sconelee.board.domain.entity.Board;
import sconelee.board.domain.repository.BoardRepository;
import sconelee.board.dto.BoardDto;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class BoardService {
    private final BoardRepository boardRepository;


    @Transactional
    public Long savePost(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    public List<BoardDto> getBoardList(){
        List<Board> boardList = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();
        //dto로 매핑시켜줌

        for(Board board : boardList){//boardList에 있는 값을 하나씩 꺼내 boardDto로 매핑시켜 넣어줌
            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .author(board.getAuthor())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .createDate(board.getCrateDate())
                    .build();
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

}
