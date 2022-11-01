package com.example.test.service

import com.example.test.dto.BoardFormDto
import com.example.test.model.Board
import com.example.test.repository.BoardRepository
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BoardService @Autowired constructor(
    val boardRepository: BoardRepository,
    val modelMapper: ModelMapper
){
    fun save(boardFormDto: BoardFormDto): Long? {
        return boardRepository.save(modelMapper.map(boardFormDto, Board::class.java)).id
    }

    fun getPost(id: Long): Board? {
        return boardRepository.findById(id).get()
    }

    fun deletePost(id: Long) {
        boardRepository.deleteById(id)
    }

    fun updatePost(id: Long, boardFormDto: BoardFormDto): Board {
        val post = boardRepository.findById(id).get()
        post.updatePost(boardFormDto)
        return post
    }

    fun getPostList(): List<Board> {
        return boardRepository.findAll()
    }
}