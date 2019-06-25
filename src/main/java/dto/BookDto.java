package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {


    private Long id;
    private String title;
    private int pagesNumber;
    private Long isbn;
    private SimplePublisherDto simplePublisherDto;
}
