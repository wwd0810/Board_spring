package kr.myeongdon.board.common.exception

import kr.myeongdon.board.common.define.ApiErrorCode
import java.lang.Exception

data class ApiException(
        val status: Int,
        private val _code: ApiErrorCode,
        val msg: String
): Exception(msg) {
    val code: String
        get() {
            return _code.code
        }

    constructor(code: ApiErrorCode): this(400, code, code.msg)

    constructor(status: Int, code: ApiErrorCode): this(status, code, code.msg)

    override fun toString(): String{
        return _code.code
    }
}