package ru.action_tech.qa.auto.api_tests.accesses.a360.v1.action360_access_get_by_account.ok

import io.qameta.allure.AllureId
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ru.action_tech.qa.auto.api_models.CheckBadRequests.checkNoContent
import ru.action_tech.qa.auto.api_models.Response_204_No_Content
import ru.action_tech.qa.auto.api_models.Sale_Accesses
import ru.action_tech.qa.auto.api_models.accesses.AccessesRequests
import ru.action_tech.qa.auto.api_models.accesses.Aktion360AccessGetByAccountV1
import ru.action_tech.qa.auto.core.annotations.Requirements
import ru.action_tech.qa.auto.data.enums.Company.UKD_DONT_TOUCH
import ru.action_tech.qa.auto.utils.accessesCrmClient


class Test_Action360AccessGetByAccountNotContent {

    @Test
    @Requirements("REQCRM-1576")
    @Sale_Accesses
    @Aktion360AccessGetByAccountV1
    @Response_204_No_Content
    @DisplayName("/api/v1/aktion360-access_get-by-account -> 204 Not Content")
    @AllureId("154445")
    fun test() {
        checkNoContent(accessesCrmClient, AccessesRequests.aktion360AccessGetByAccount(UKD_DONT_TOUCH.id))
    }
}