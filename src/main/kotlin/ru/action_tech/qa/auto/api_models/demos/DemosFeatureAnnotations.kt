package ru.action_tech.qa.auto.api_models.demos

import io.qameta.allure.Feature

@Feature(demoV1)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DemoV1

@Feature(demoAccessInfoV1)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DemoAccessInfoV1

@Feature(demoAccessGetListByContactsV1)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class DemoAccessGetListByContactsV1

@Feature(licensesForCustomerV1)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ForCustomerV1

@Feature(licenseGetBySubscribeV1)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseGetBySubscribeV1

@Feature(jobTitlesV1)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class JobTitlesV1

@Feature(licenseV1)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseV1

@Feature(licenseV2)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class LicenseV2