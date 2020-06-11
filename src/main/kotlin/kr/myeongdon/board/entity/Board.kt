package kr.myeongdon.board.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "tbl_board")
@Entity
data class Board(
        @get:Id
        @get:GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,

        @get:Column
        var title: String,

        @get:Column
        var contents: String
) {
    @get:CreatedDate
    lateinit var created_at: LocalDateTime

    @get:LastModifiedDate
    var updated_at: LocalDateTime? = null
}