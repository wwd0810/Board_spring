package kr.myeongdon.board.repository

import kr.myeongdon.board.entity.Board
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository


interface BoardJpaRepository: PagingAndSortingRepository<Board, Long>{

//    fun findAllBoard(title: String?, pageable: Pageable): Page<Board>

    fun findByTitle(board_title: String?, pageable: Pageable): Page<Board>

}