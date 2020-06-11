package kr.myeongdon.board.service.board

interface BoardService {

    fun readBoardList(page: Int, size: Int, query: String?): Map<String, Any>

}