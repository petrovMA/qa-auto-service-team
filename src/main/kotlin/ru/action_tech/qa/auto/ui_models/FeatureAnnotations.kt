package ru.action_tech.qa.auto.ui_models

import io.qameta.allure.Feature

// region [SALE]
@Feature("[SALE] Helper")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Helper

@Feature("Демо-доступы")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DemoAccesses

@Feature("[SALE] A360")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Sale_A360

@Feature("[SALE] Отправка документов")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Sale_SendDocuments
// endregion
