package com.ezechuka.digitconverter

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DigitConverterTest {

    @Test
    fun `single digit size returns correct word representation`() {
        val word = DigitConverter.onesSize(8)
        assertThat(word).isEqualTo("eight")
    }

    @Test
    fun `tens digit size returns correct word representation`() {
        val word = DigitConverter.tensSize(88)
        assertThat(word).isEqualTo("eighty eight")
    }

    @Test
    fun `hundreds digit size returns correct word representation`() {
        val word = DigitConverter.hundredsSize(107)
        assertThat(word).isEqualTo("one hundred and seven")
    }

    @Test
    fun `thousands digit size returns correct word representation`() {
        val word = DigitConverter.thousandsSize(1005)
        assertThat(word).isEqualTo("one thousand and five")
    }

    @Test
    fun `ten thousands digit size returns correct word representation`() {
        val word = DigitConverter.tenThousandsSize(10003)
        assertThat(word).isEqualTo("ten thousand and three")
    }

    @Test
    fun `hundred thousands digit size returns correct word representation`() {
        val word = DigitConverter.hundredThousandsSize(100003)
        assertThat(word).isEqualTo("one hundred thousand and three")
    }

    @Test
    fun `one millions digit size returns correct word representation`() {
        val word = DigitConverter.oneMillionsSize(1541231)
        assertThat(word).isEqualTo("one million five hundred and forty one thousand two hundred and thirty one")
    }

    @Test
    fun `asWords correctly converts each digit to words`() {
        val asWords = DigitConverter.asWords(6343)
        assertThat(asWords).isEqualTo("six thousand three hundred and forty three")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `digit not supported returns an exception`() {
        val asWords = DigitConverter.asWords(0)
        assertThat(asWords).isEqualTo("zero")
    }

}