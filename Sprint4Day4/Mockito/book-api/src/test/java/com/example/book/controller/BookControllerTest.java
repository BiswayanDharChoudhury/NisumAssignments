package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.service.BookService;
import com.example.book.exception.BookNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = BookController.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void getBookById_ReturnsBook_WhenExists() throws Exception {
        Book book = new Book(1L, "Test Title", "Test Author");
        Mockito.when(bookService.findById(eq(1L))).thenReturn(book);

        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/books/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andDo(document("get-book",
                        pathParameters(
                                parameterWithName("id").description("Book ID")
                        ),
                        responseFields(
                                fieldWithPath("id").description("The book's ID"),
                                fieldWithPath("title").description("The book's title"),
                                fieldWithPath("author").description("The author of the book")
                        )
                ));
    }

    @Test
    void getBookById_Returns404_WhenNotExists() throws Exception {
        Mockito.when(bookService.findById(eq(42L)))
                .thenThrow(new BookNotFoundException(42L));

        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/books/{id}", 42L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andDo(document("get-book-not-found",
                        pathParameters(
                                parameterWithName("id").description("Book ID")
                        )
                ));
    }
}
