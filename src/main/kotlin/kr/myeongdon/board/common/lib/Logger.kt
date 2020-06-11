package kr.myeongdon.board.common.lib

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.invoke.MethodHandles

inline fun logger(): Logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())