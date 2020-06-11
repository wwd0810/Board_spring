package kr.myeongdon.board.common.define

enum class ApiErrorCode(
        val code: String,
        val msg: String
) {
    // Board
    BOARD_NOT_FOUND("api.error.board_not_found", "게시글을 찾을 수가 없습니다.")

}