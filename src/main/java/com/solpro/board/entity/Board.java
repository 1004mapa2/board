package com.solpro.board.entity;

import lombok.Data;

/*
@Data 구성요소
@Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
 */
@Data
public class Board {

    private int boardIdx;
    private String memId;
    private String boardTitle;
    private String boardContent;
    private String boardWriter;
    private String boardIndate;
    private int boardCount;
}
