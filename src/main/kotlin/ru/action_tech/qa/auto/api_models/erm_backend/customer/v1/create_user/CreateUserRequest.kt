package ru.action_tech.qa.auto.api_models.erm_backend.customer.v1.create_user

import ru.action_tech.qa.auto.utils.getRandom

data class CreateUserRequest(
    var customerType: Int? = 2,
    var email: String? = "autotest${getRandom()}@action-autotest.ru",
    var firstName: String? = "ERM",
    var middleName: String? = "api",
    var lastName: String? = "Ермапи",
    var jobTitleId: String? = "b9626a79-269d-4627-9cb4-308bd33e92f4",
    var phoneNumber: String? = "3000000000",
    var countryId: String? = "89867ae0-3b4e-4a33-9246-4eae3e22e850"
)