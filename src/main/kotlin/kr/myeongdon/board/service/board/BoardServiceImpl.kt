package kr.myeongdon.board.service.board

import kr.myeongdon.board.common.lib.logger
import kr.myeongdon.board.entity.Board
import kr.myeongdon.board.entity.common.Paging
import kr.myeongdon.board.repository.BoardJpaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service


@Service("BoardService")
class BoardServiceImpl(
        private val boardJpaRepository: BoardJpaRepository
): BoardService {

    companion object {
        private val log = logger()
    }

    @Throws(Exception::class)
    override fun readBoardList(
            page: Int,
            size: Int,
            query: String?
    ): Map<String, Any> {
        val returnMap: MutableMap<String, Any> = HashMap()

        val pageRequest =  PageRequest.of(page, size)

        val data: Page<Board>

        data = if (query != "") {
            boardJpaRepository.findByTitle(query, pageRequest)
        } else {
            boardJpaRepository.findAll(pageRequest)
        }

        val paging = Paging.parse(data)

        run {
            returnMap["content"] = data.content
            returnMap["paging"] = paging
        }

        return returnMap
    }

}