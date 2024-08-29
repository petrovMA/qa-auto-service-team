package ru.action_tech.qa.auto.api_models

import io.qameta.allure.Story

//region [API]
@Story("Positive scenario")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class PositiveScenario

@Story("Negative scenario")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class NegativeScenario

@Story("200 Ok")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Response_200_Ok

@Story("204_No_Content")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Response_204_No_Content

@Story("400 Bad Request")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Response_400_Bad_Request

@Story("401 Unauthorized")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Response_401_Unauthorized

@Story("404 Not Found")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Response_404_Not_Found

@Story("403 Forbidden")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Response_403_Forbidden

@Story("Wrong Request Data")
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class WrongRequestData
//endregion