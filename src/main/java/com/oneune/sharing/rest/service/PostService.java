package com.oneune.sharing.rest.service;

import com.oneune.sharing.rest.contract.CRUDed;
import com.oneune.sharing.rest.reader.PostReader;
import com.oneune.sharing.rest.repository.PostRepository;
import com.oneune.sharing.rest.store.dto.PostDto;
import com.oneune.sharing.rest.store.entity.PostEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Log4j2
public class PostService implements CRUDed<PostDto> {

    ModelMapper modelMapper;
    PostRepository postRepository;
    PostReader postReader;

    @Override
    public PostDto post(PostDto postDto) {
        PostEntity postEntity = modelMapper.map(postDto, PostEntity.class);
        postRepository.saveAndFlush(postEntity);
        return postReader.getById(postEntity.getId());
    }

    @Override
    public PostDto put(Long postId, PostDto postDto) {
        PostEntity postEntity = postReader.getEntityById(postId);
        modelMapper.map(postDto, postEntity);
        postRepository.saveAndFlush(postEntity);
        return postReader.getById(postEntity.getId());
    }

    @Override
    public PostDto deleteById(Long postId) {
        PostDto postDto = postReader.getById(postId);
        postRepository.deleteById(postId);
        return postDto;
    }

    @Override
    public PostDto getById(Long postId) {
        return postReader.getById(postId);
    }

    @Override
    public List<PostDto> getAll() {
        return postReader.getAll();
    }
}
