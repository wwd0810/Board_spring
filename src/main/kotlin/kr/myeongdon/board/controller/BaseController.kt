package kr.myeongdon.board.controller

import org.slf4j.LoggerFactory
import java.lang.invoke.MethodHandles

abstract class BaseController {

    companion object {
        val log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
    }

}