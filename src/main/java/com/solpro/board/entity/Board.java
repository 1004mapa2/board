package com.solpro.board.entity;

import lombok.Data;

/*
@Data 구성요소
@Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
 */
@Data
public class Board {

    private int idx;
    private String title;
    private String content;
    private String writer;
    private String indate;
    private int count;
}
