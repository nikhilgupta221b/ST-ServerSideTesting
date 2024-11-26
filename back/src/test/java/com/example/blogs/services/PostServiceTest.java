package com.example.blogs.services;

import com.example.blogs.Repositories.CategoryRepository;
import com.example.blogs.Repositories.PostRepository;
import com.example.blogs.Repositories.UserRepository;
import com.example.blogs.entities.Category;
import com.example.blogs.entities.Post;
import com.example.blogs.entities.User;
import com.example.blogs.exceptions.ResourceNotFoundException;
import com.example.blogs.payloads.CategoryDto;
import com.example.blogs.payloads.PostDto;
import com.example.blogs.payloads.PostResponse;
import com.example.blogs.services.implementations.PostImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PostServiceTest {

    @InjectMocks
    private PostImplementation postService;

    @Mock
    private PostRepository postRepo;

    @Mock
    private UserRepository userRepo;

    @Mock
    private CategoryRepository categoryRepo;

    @Mock
    private ModelMapper modelMapper;

    private Post post;
    private PostDto postDto;
    private User user;
    private Category category;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setId(1);
        user.setName("Test User");

        category = new Category();
        category.setCategoryId(1);
        category.setCategoryTitle("Test Category");

        post = new Post();
        post.setPostId(1);
        post.setTitle("Test Post");
        post.setContent("This is a test post.");
        post.setUser(user);
        post.setCategory(category);

        postDto = new PostDto();
        postDto.setPostId(1);
        postDto.setTitle("Test Post");
        postDto.setContent("This is a test post.");
    }

    // -- TESTS FOR CREATE POST --
    @Test
    void testCreatePost() {
        when(userRepo.findById(1)).thenReturn(Optional.of(user));
        when(categoryRepo.findById(1)).thenReturn(Optional.of(category));
        when(modelMapper.map(any(PostDto.class), eq(Post.class))).thenReturn(post);
        when(postRepo.save(any(Post.class))).thenReturn(post);
        when(modelMapper.map(any(Post.class), eq(PostDto.class))).thenReturn(postDto);

        PostDto createdPost = postService.createPost(postDto, 1, 1);

        assertNotNull(createdPost);
        assertEquals(postDto.getPostId(), createdPost.getPostId());
        verify(postRepo, times(1)).save(any(Post.class));
    }

    @Test
    void testCreatePostUserNotFound() {
        when(userRepo.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> postService.createPost(postDto, 1, 1));
    }

    @Test
    void testCreatePostCategoryNotFound() {
        when(userRepo.findById(1)).thenReturn(Optional.of(user));
        when(categoryRepo.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> postService.createPost(postDto, 1, 1));
    }

    // -- TESTS FOR UPDATE POST --
    @Test
    void testUpdatePost() {
        when(postRepo.findById(1)).thenReturn(Optional.of(post));
        when(categoryRepo.findById(1)).thenReturn(Optional.of(category));
        when(postRepo.save(any(Post.class))).thenReturn(post);
        when(modelMapper.map(any(Post.class), eq(PostDto.class))).thenReturn(postDto);

        // Setting the category for the PostDto
        CategoryDto categoryDto = new CategoryDto(1, "Test Category", "Test Description");
        postDto.setCategory(categoryDto);

        PostDto updatedPost = postService.updatePost(postDto, 1);

        assertNotNull(updatedPost);
        assertEquals(postDto.getPostId(), updatedPost.getPostId());
        verify(postRepo, times(1)).save(any(Post.class));
    }

    @Test
    void testUpdatePostPostNotFound() {
        when(postRepo.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> postService.updatePost(postDto, 1));
        verify(postRepo, never()).save(any(Post.class));
    }

    @Test
    void testUpdatePostCategoryNotFound() {
        when(postRepo.findById(1)).thenReturn(Optional.of(post));
        when(categoryRepo.findById(anyInt())).thenReturn(Optional.empty());

        // Setting the category for the PostDto
        CategoryDto categoryDto = new CategoryDto(1, "Test Category", "Test Description");
        postDto.setCategory(categoryDto);

        assertThrows(ResourceNotFoundException.class, () -> postService.updatePost(postDto, 1));
        verify(categoryRepo, times(1)).findById(1);
        verify(postRepo, never()).save(any(Post.class));
    }

    // -- TESTS FOR DELETE POST --
    @Test
    void testDeletePost() {
        when(postRepo.findById(1)).thenReturn(Optional.of(post));
        doNothing().when(postRepo).delete(post);

        postService.deletePost(1);

        verify(postRepo, times(1)).delete(post);
    }

    @Test
    void testDeletePostNotFound() {
        when(postRepo.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> postService.deletePost(1));
    }

    // -- TESTS FOR GET POST BY ID--
    @Test
    void testGetPostByIdSuccess() {
        when(postRepo.findById(1)).thenReturn(Optional.of(post));
        when(modelMapper.map(post, PostDto.class)).thenReturn(postDto);

        PostDto foundPost = postService.getPostById(1);

        assertNotNull(foundPost);
        assertEquals(postDto.getPostId(), foundPost.getPostId());
    }

    @Test
    void testGetPostByIdNotFound() {
        when(postRepo.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> postService.getPostById(1));
    }

    // -- TESTS FOR GET POST BY USER--
    @Test
    void testGetPostsByUserSuccess() {
        when(userRepo.findById(1)).thenReturn(Optional.of(user));
        when(postRepo.findByUser(user)).thenReturn(List.of(post));
        when(modelMapper.map(any(Post.class), eq(PostDto.class))).thenReturn(postDto);

        List<PostDto> posts = postService.getPostByUser(1);

        assertFalse(posts.isEmpty());
        assertEquals(1, posts.size());
    }

    @Test
    void testGetPostsByUserNotFound() {
        when(userRepo.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> postService.getPostByUser(1));
    }

    // -- TESTS FOR GET POST BY CATEGORY--
    @Test
    void testGetPostsByCategorySuccess() {
        when(categoryRepo.findById(1)).thenReturn(Optional.of(category));
        when(postRepo.findByCategory(category)).thenReturn(List.of(post));
        when(modelMapper.map(any(Post.class), eq(PostDto.class))).thenReturn(postDto);

        List<PostDto> posts = postService.getPostsByCategory(1);

        assertFalse(posts.isEmpty());
        assertEquals(1, posts.size());
    }

    @Test
    void testGetPostsByCategoryNotFound() {
        when(categoryRepo.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> postService.getPostsByCategory(1));
    }

    // -- TESTS FOR GET ALL POSTS--
    @Test
    void testGetAllPostSuccess() {
        List<Post> posts = List.of(post);
        Page<Post> postPage = new PageImpl<>(posts);

        when(postRepo.findAll(any(PageRequest.class))).thenReturn(postPage);
        when(modelMapper.map(any(Post.class), eq(PostDto.class))).thenReturn(postDto);

        PostResponse postResponse = postService.getAllPost(0, 10, "title", "asc");

        assertNotNull(postResponse);
        assertEquals(1, postResponse.getContent().size());
        assertEquals("Test Post", postResponse.getContent().get(0).getTitle());
        assertTrue(postResponse.isLastPage());
        verify(postRepo, times(1)).findAll(any(PageRequest.class));
    }

    @Test
    void testGetAllPostEmpty() {
        Page<Post> emptyPage = new PageImpl<>(List.of());

        when(postRepo.findAll(any(PageRequest.class))).thenReturn(emptyPage);

        PostResponse postResponse = postService.getAllPost(0, 10, "title", "asc");

        assertNotNull(postResponse);
        assertTrue(postResponse.getContent().isEmpty());
        verify(postRepo, times(1)).findAll(any(PageRequest.class));
    }

    @Test
    void testGetAllPostInvalidSortingDirection() {
        // Verify if the implementation gracefully handles invalid sorting directions.
        List<Post> posts = List.of(post);
        Page<Post> postPage = new PageImpl<>(posts);

        when(postRepo.findAll(any(PageRequest.class))).thenReturn(postPage);
        when(modelMapper.map(any(Post.class), eq(PostDto.class))).thenReturn(postDto);

        PostResponse postResponse = postService.getAllPost(0, 10, "title", "INVALID_DIRECTION");

        assertNotNull(postResponse);
        assertEquals(1, postResponse.getContent().size());
        verify(postRepo, times(1)).findAll(any(PageRequest.class));
    }

    // -- TESTS FOR SEARCH POST BY TITLE--
    @Test
    void testSearchPostsByTitleSuccess() {
        when(postRepo.findByTitleContaining("Test")).thenReturn(List.of(post));
        when(modelMapper.map(any(Post.class), eq(PostDto.class))).thenReturn(postDto);

        List<PostDto> posts = postService.searchPosts("Test");

        assertFalse(posts.isEmpty());
        assertEquals(1, posts.size());
    }

}
