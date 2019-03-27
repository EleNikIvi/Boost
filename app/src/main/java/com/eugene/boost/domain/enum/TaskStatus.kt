package com.eugene.boost.domain.enum

enum class TaskStatus(var statusInt: Int) {
    OPEN(0),
    IN_PROGRESS(1),
    CLOSE(2);


    companion object {

        fun getStatusByInt(statusInt: Int): TaskStatus {

            return when (statusInt) {

                1 -> IN_PROGRESS
                2 -> CLOSE
                else -> OPEN
            }
        }
    }
}
