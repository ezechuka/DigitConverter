package com.ezechuka.digitconverter

import com.ezechuka.digitconverter.Constants.Companion.HUNDRED
import com.ezechuka.digitconverter.Constants.Companion.HUNDREDS
import com.ezechuka.digitconverter.Constants.Companion.ONE_HUNDRED_THOUSAND
import com.ezechuka.digitconverter.Constants.Companion.ONE_MILLION
import com.ezechuka.digitconverter.Constants.Companion.ONE_THOUSAND
import com.ezechuka.digitconverter.Constants.Companion.TENS
import com.ezechuka.digitconverter.Constants.Companion.TEN_MILLION
import com.ezechuka.digitconverter.Constants.Companion.TEN_THOUSAND
import com.ezechuka.digitconverter.Constants.Companion.THOUSAND
import com.ezechuka.digitconverter.Constants.Companion.TWENTYS
import com.ezechuka.digitconverter.Constants.Companion.middlesConstant
import com.ezechuka.digitconverter.Constants.Companion.onesConstant
import com.ezechuka.digitconverter.Constants.Companion.tensConstant

class DigitConverter {

    companion object {

        fun onesSize(figure: Int): String {
            return buildString {
                if (figure < TENS)
                    append(onesConstant[figure - 1])
            }
        }

        fun tensSize(figure: Int): String {
            var position: Int
            return buildString {
                if ((figure >= TENS) && (figure < HUNDREDS)) {
                    val stringValue = figure.toString()
                    if ((figure > TENS) && (figure < TWENTYS)) {
                        position = stringValue[1].toString().toInt() - 1
                        append(middlesConstant[position])
                    } else if (stringValue.endsWith("0")) {
                        position = stringValue[0].toString().toInt() - 1
                        append(tensConstant[position])
                    } else {
                        for (i in stringValue.indices) {
                            if (i == (stringValue.length - 1)) {
                                position = stringValue[i].toString().toInt() - 1
                                append(onesConstant[position])
                            } else {
                                position = stringValue[i].toString().toInt() - 1
                                append(tensConstant[position]).append(" ")
                            }
                        }
                    }
                } else
                    append(onesSize(figure))
            }
        }

        fun hundredsSize(figure: Int): String {
            val position: Int
            return buildString {
                if ((figure >= HUNDREDS) && (figure < ONE_THOUSAND)) {
                    val stringValue = figure.toString()
                    when {
                        stringValue.endsWith("00") -> {
                            position = stringValue[0].toString().toInt() - 1
                            append("${onesConstant[position]} $HUNDRED")
                        }
                        else -> {
                            append(
                                "${
                                    onesConstant[stringValue[0].toString().toInt() - 1]
                                } $HUNDRED and "
                            )
                            append(tensSize(stringValue.substring(1).toInt()))
                        }
                    }
                } else
                    append(tensSize(figure))
            }
        }

        fun thousandsSize(figure: Int): String {
            val position: Int
            return buildString {
                if ((figure >= ONE_THOUSAND) && (figure < TEN_THOUSAND)) {
                    val stringValue = figure.toString()
                    if (stringValue.endsWith("000")) {
                        position = stringValue[0].toString().toInt() - 1
                        append("${onesConstant[position]} $THOUSAND")
                    } else {
                        append("${onesConstant[stringValue[0].toString().toInt() - 1]} $THOUSAND")
                        val hundreds = stringValue.substring(1)
                        if (hundreds.startsWith("0"))
                            append(" and ").append(hundredsSize(hundreds.toInt()))
                        else
                            append(" ").append(hundredsSize(hundreds.toInt()))
                    }
                } else
                    append(hundredsSize(figure))
            }
        }

        fun tenThousandsSize(figure: Int): String {
            val position: Int
            return buildString {
                if ((figure >= TEN_THOUSAND) && (figure < ONE_HUNDRED_THOUSAND)) {
                    val stringValue = figure.toString()
                    if (stringValue.endsWith("000")) {
                        position = stringValue.substring(0, 2).toInt()
                        append("${tensSize(position)} $THOUSAND")
                    } else {
                        append("${tensSize(stringValue.substring(0, 2).toInt())} $THOUSAND")
                        val thousands = stringValue.substring(2)
                        if (thousands.startsWith("0"))
                            append(" and ").append(thousandsSize(thousands.toInt()))
                        else
                            append(" ").append(thousandsSize(thousands.toInt()))
                    }
                } else
                    append(thousandsSize(figure))
            }
        }

        fun hundredThousandsSize(figure: Int): String {
            val position: Int
            return buildString {
                if ((figure >= ONE_HUNDRED_THOUSAND) && (figure < ONE_MILLION)) {
                    val stringValue = figure.toString()
                    if (stringValue.endsWith("000")) {
                        position = stringValue.substring(0, 3).toInt()
                        append("${hundredsSize(position)} $THOUSAND")
                    } else {
                        append("${hundredsSize(stringValue.substring(0, 3).toInt())} $THOUSAND")
                        val hundredThousands = stringValue.substring(3)
                        if (hundredThousands.startsWith("0"))
                            append(" and ").append(thousandsSize(hundredThousands.toInt()))
                        else
                            append(" ").append(thousandsSize(hundredThousands.toInt()))
                    }
                } else
                    append(tenThousandsSize(figure))
            }
        }

        fun oneMillionsSize(figure: Int): String {
            val position: Int
            return buildString {
                if ((figure >= ONE_MILLION) && (figure < TEN_MILLION)) {
                    val stringValue = figure.toString()
                    if (stringValue.endsWith("000")) {
                        position = stringValue[0].toString().toInt() - 1
                        append("${onesConstant[position]} ${Constants.MILLION}")
                    } else {
                        append("${onesConstant[(stringValue[0].toString()).toInt() - 1]} ${Constants.MILLION}")
                        val millions = stringValue.substring(1)
                        if (millions.startsWith("0"))
                            append(" and ").append(hundredThousandsSize(millions.toInt()))
                        else
                            append(" ").append(hundredThousandsSize(millions.toInt()))
                    }
                } else
                    append(hundredThousandsSize(figure))
            }
        }

        fun asWords(figure: Int): String {
            if ((figure <= 0) || (figure >= TEN_MILLION)) throw IllegalArgumentException("figure not supported.")
            else return oneMillionsSize(figure)
        }
    }
}