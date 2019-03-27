package com.eugene.boost.domain.enum

enum class ProjectColor(var colorInt: Int) {
    BLACK(0x000000),
    BERRY_RED(0xB8255F),
    RED(0xDB4035),
    ORANGE(0xFF9933),
    YELLOW(0xFAD000),
    OLIVE_GREEN(0xAFB83B),
    LIME_GREEN(0x7ECC49),
    GREEN(0x299438),
    MINT_GREEN(0x6ACCBC),
    TEAL(0x158FAD),
    SKY_BLUE(0x14AAF5),
    LIGHT_BLUE(0x96C3EB),
    BLUE(0x4073FF),
    GRAPE(0x884DFF),
    VIOLET(0xAF38EB),
    LAVENDER(0xEB96EB),
    MAGENTA(0xE05194),
    SALMON(0xFF8D85),
    CHARCOAL(0x808080),
    GREY(0xB8B8B8),
    TAUPE(0xCCAC93);


    companion object {

        fun getColorByInt(colorInt: Int): ProjectColor {

            return when (colorInt) {
                0xB8255F -> BERRY_RED
                0xDB4035 -> RED
                0xFF9933 -> ORANGE
                0xFAD000 -> YELLOW
                0xAFB83B -> OLIVE_GREEN
                0x7ECC49 -> LIME_GREEN
                0x299438 -> GREEN
                0x6ACCBC -> MINT_GREEN
                0x158FAD -> TEAL
                0x14AAF5 -> SKY_BLUE
                0x96C3EB -> LIGHT_BLUE
                0x4073FF -> BLUE
                0x884DFF -> GRAPE
                0xAF38EB -> VIOLET
                0xEB96EB -> LAVENDER
                0xE05194 -> MAGENTA
                0xFF8D85 -> SALMON
                0x808080 -> CHARCOAL
                0xB8B8B8 -> GREY
                0xCCAC93 -> TAUPE
                else -> BLACK
            }
        }
    }
}
