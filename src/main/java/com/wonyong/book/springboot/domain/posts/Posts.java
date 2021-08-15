package com.wonyong.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //lombok 게터
@NoArgsConstructor //lombok
@Entity //테이블과 링크될 클래스
public class Posts extends BaseTimeEntity {

    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //GenerationType.IDENTITY : auto increment
    private Long Id;

    //column이 없더라고 컬럼이 적용되지만 기본값 이외에 변경이 필요한 옵션이 있을때 사용
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
