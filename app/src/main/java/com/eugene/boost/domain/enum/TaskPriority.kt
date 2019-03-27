package com.eugene.boost.domain.enum

enum class TaskPriority(var priorityInt: Int) {
    PRIORITY_0(0),
    PRIORITY_1(1),
    PRIORITY_2(2),
    PRIORITY_3(3);


    companion object {

        fun getPriorityByInt(priorityInt: Int): TaskPriority {

            return when (priorityInt) {
                2 -> PRIORITY_1
                3 -> PRIORITY_2
                4 -> PRIORITY_3
                else -> PRIORITY_0
            }
        }
    }
}
