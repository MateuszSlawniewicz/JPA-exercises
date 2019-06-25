package dto;

import org.hibernate.transform.ResultTransformer;

import java.util.Arrays;
import java.util.List;

public class BookDtoResultTransformer implements ResultTransformer {
    @Override
    public Object transformTuple(Object[] objects, String[] strings) {

        int id = Arrays.asList(strings).indexOf("id");
        int title = Arrays.asList(strings).indexOf("title");
        int isbn = Arrays.asList(strings).indexOf("isbn");
        int pagesNumber = Arrays.asList(strings).indexOf("pagesNumber");
        int publisherId = Arrays.asList(strings).indexOf("publisherId");
        int publisherName = Arrays.asList(strings).indexOf("publisherName");

        BookDto bookDto = new BookDto();
        bookDto.setId(id != -1 ? (Long) objects[id] : 0);
        bookDto.setTitle(title != -1 ? (String) objects[title] : null);
        bookDto.setIsbn(isbn != -1 ? (Long) objects[isbn] : 0);
        bookDto.setPagesNumber(pagesNumber != -1 ? (int) objects[pagesNumber] : 0);

        SimplePublisherDto simplePublisherDto = new SimplePublisherDto();
        simplePublisherDto.setId(publisherId != -1 ? (Long) objects[publisherId] : 0);
        simplePublisherDto.setName(publisherName != -1 ? (String) objects[publisherName] : null);

        bookDto.setSimplePublisherDto(simplePublisherDto);

        return bookDto;
    }

    @Override
    public List transformList(List list) {
        return list;
    }
}
