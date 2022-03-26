/*
 * Copyright Mixtape Bot 2019 - 2022 All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package mixtape.oss.kedis.protocol

public enum class RedisType(public val char: Char) : Rawable {
    SimpleString('+'),
    BulkString('$'),
    Error('-'),
    Integer(':'),
    Array('*');

    override val raw: ByteArray
        get() = byteArrayOf(char.code.toByte())

    public companion object {
        public fun find(byte: Byte): RedisType? = values().find { it.char.code.toByte() == byte }

        public fun find(char: Char): RedisType? = values().find { it.char == char }
    }
}
