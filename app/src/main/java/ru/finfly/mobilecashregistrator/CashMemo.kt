package ru.finfly.mobilecashregistrator

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.service.carrier.CarrierIdentifier
import java.time.Instant
import java.util.*

@Entity
data class CashMemo
(
        /** \brief Локальный ключ заметки на устройстве.
         *
         * Локальный ключ заметки генерируется на устройстве и не передается на сервер.
         * На сервер передается GUID устройства (инсталляции) и содержание заметки.
         */
        @PrimaryKey(autoGenerate = true)
        var lid: Int = 0,

        /** \brief Глобальный идентификатор заметки.
         *
         * Сервер, получив заметку, присваивает ей GUID и возвращает его
         * устройству. Наличие GUID у заметки указывает на статус заметки -
         * "зафиксировано на сервере".
         */
        var guid:   String = "",

        /** \brief Сумма заметки.
         *
         * Сумма заметки положительна при приходе денег и отризательна - при расходе.
         */
        var quantum:  Double = 0.0,

        /** \brief Дата и время создания заметки на устойстве.
         *
         * Автоматически присваивается заметке при создании. Используется локальное время
         * устройства.
         */
        var cum: Date = Date(),

        /** \brief Источник денег (кто).
         *
         * Комментарий о том, кто передал деньги или кто их получил.
         */
        var qui: String = "",

        /** \brief Назначени денег (что).
         *
         * Комментарий о том, на что получены или переданы деньги.
         */
        var quid: String = "",

        /** \brief Номер валюты.
         *
         * Валюта, в которой получены деньги. Может быть
         * 0 - рубли,
         * 1 - евро,
         * 2 - доллар
         */
        var monetae: Int = 0
)
