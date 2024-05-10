package ru.adavydova.recommendation_feature.util


data class PositionOffset(
    val startPosition: Float,
    val endPosition: Float
)


fun HashMap<Int, Float>.getStartPositionOffset(
    currentPosition: Int,
    margin: Float
): PositionOffset {
    var position = 0
    var result = 0f
    while (position != currentPosition) {
        result += this[position]?.plus(margin) ?: throw IllegalArgumentException("err")
        position++
    }
    return PositionOffset(
        startPosition = result,
        endPosition = result + (this[currentPosition] ?: 0f)
    )
}
