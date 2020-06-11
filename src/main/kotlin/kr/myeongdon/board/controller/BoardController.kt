package kr.myeongdon.board.controller

import kr.myeongdon.board.common.define.ApiErrorCode
import kr.myeongdon.board.common.exception.ApiException
import kr.myeongdon.board.service.board.BoardService
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse


@RestController
@RequestMapping("/boards")
class BoardController(
        private val boardService: BoardService
): BaseController() {

    @RequestMapping(method = [ RequestMethod.GET ])
    fun readBoardList(
    @RequestParam(required = false, defaultValue = "0") page: Int,
    @RequestParam(required = false, defaultValue = "10") size: Int,
    @RequestParam(required = false, defaultValue = "") query: String?,
    res: HttpServletResponse
    ): Map<String, Any> {

        val returnMap: MutableMap<String, Any> = HashMap()

        try {
            returnMap["result"] = 1
            returnMap["data"] = boardService.readBoardList(page, size, query)
        } catch (e: ApiException) {
            res.status = e.status
            returnMap["result"] = 0
            returnMap["resultCode"] = e.code
            returnMap["resultMsg"] = e.msg
        } catch (e: Exception) {
            log.error("" , e)
            res.status = 500
            returnMap["result"] = 0
            returnMap["resultCode"] = ApiErrorCode.BOARD_NOT_FOUND
            returnMap["resultMsg"] = ApiErrorCode.BOARD_NOT_FOUND
        }

        return returnMap
    }

}