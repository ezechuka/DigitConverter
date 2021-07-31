package com.ezechuka.digitconverter

class Constants {

    companion object {
        const val ONE = "one"
        const val TWO = "two"
        const val THREE = "three"
        const val FOUR = "four"
        const val FIVE = "five"
        const val SIX = "six"
        const val SEVEN = "seven"
        const val EIGHT = "eight"
        const val NINE = "nine"
        const val TEN = "ten"
        const val ELEVEN = "eleven"
        const val TWELVE = "twelve"
        const val THIRTEEN = "thirteen"
        const val FOURTEEN = "fourteen"
        const val FIFTEEN = "fifteen"
        const val SIXTEEN = "sixteen"
        const val SEVENTEEN = "seventeen"
        const val EIGHTEEN = "eighteen"
        const val NINETEEN = "nineteen"
        const val TWENTY = "twenty"
        const val THIRTY = "thirty"
        const val FORTY = "forty"
        const val FIFTY = "fifty"
        const val SIXTY = "sixty"
        const val SEVENTY = "seventy"
        const val EIGHTY = "eighty"
        const val NINETY = "ninety"
        const val HUNDRED = "hundred"
        const val THOUSAND = "thousand"
        const val MILLION = "million"

        // one's constant ranges from 1 - 9
        val onesConstant = arrayOf(ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE)

        // middle's constant ranges from 11 - 19
        val middlesConstant = arrayOf(
            ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTEEN, SIXTEEN,
            SEVENTEEN, EIGHTEEN, NINETEEN
        )

        // ten's constant ranges from 10 - 90
        val tensConstant =
            arrayOf(TEN, TWENTY, THIRTY, FORTY, FIFTY, SIXTY, SEVENTY, EIGHTY, NINETY)

        // base case constants
        const val TENS = 10
        const val TWENTYS = 20
        const val HUNDREDS = 100
        const val ONE_THOUSAND = 1_000
        const val TEN_THOUSAND = 10_000
        const val ONE_HUNDRED_THOUSAND = 100_000
        const val ONE_MILLION = 1_000_000
        const val TEN_MILLION = 10_000_000

    }
}